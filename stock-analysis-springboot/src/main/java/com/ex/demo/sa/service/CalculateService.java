package com.ex.demo.sa.service;

import com.ex.demo.sa.domain.OperateRecord;
import com.ex.demo.sa.domain.OperateRecordSavedEvent;
import com.ex.demo.sa.domain.Quote;
import com.ex.demo.sa.domain.StockSnapshot;
import com.ex.demo.sa.mapper.OperateRecordMapper;
import com.ex.demo.sa.mapper.StockSnapshotMapper;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

/**
 * @author edison
 * On 2018/8/8 17:32
 */
@Service
public class CalculateService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CalculateService.class);

	@Autowired
	private StockSnapshotMapper stockSnapshotMapper;

	@Autowired
	private OperateRecordMapper operateRecordMapper;

	@Autowired
	private QuoteService quoteService;

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Async
	public void calculateSnapshotByQuote(Quote quote){
		List<StockSnapshot> snapshots = stockSnapshotMapper.findByStockId(quote.getStockId());
		snapshots.forEach(s->{
			s.setProfitAndLoss((quote.getPrice().subtract(s.getCost())).multiply(new BigDecimal(s.getQuantity())).setScale(4, RoundingMode.CEILING));
			s.setLastUpdateTime(LocalDateTime.now(ZoneId.systemDefault()));
		});
		batchUpdate2(snapshots);
	}

	@TransactionalEventListener
	public void calculateSnapshotByOperateRecord(OperateRecordSavedEvent event){
		OperateRecord opRecord = event.getOperateRecord();
		String stockId = opRecord.getStockId();
		List<OperateRecord> records = operateRecordMapper.findByUserIdAndStockId(opRecord.getUserId(), stockId);
		if(records.isEmpty())
			return;
		StockSnapshot snapshot = StockSnapshot.newFromOperateRecord(opRecord);
		BigDecimal total = BigDecimal.ZERO;
		for (OperateRecord record : records) {
			snapshot.setQuantity(snapshot.getQuantity()+record.getQuantity());
			total = total.add(record.getPrice().multiply(new BigDecimal(record.getQuantity())));
		}
		BigDecimal quantity = new BigDecimal(snapshot.getQuantity());
		snapshot.setCost(total.divide(quantity, 4, RoundingMode.CEILING));
		Quote latestQuote = quoteService.getLatestQuote(stockId);
		snapshot.setProfitAndLoss(latestQuote.getPrice().multiply(quantity).subtract(total));
		stockSnapshotMapper.insertOrUpdate(snapshot);
	}

	private void batchUpdate1(List<StockSnapshot> snapshots){
		SqlSession session = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);
		//final StockSnapshotMapper snapshotMapper = session.getMapper(StockSnapshotMapper.class);
		session.update("StockSnapshotMapper.batchUpdateProfitAndLoss", snapshots);
		session.commit();
		session.close();
	}

	private void batchUpdate2(List<StockSnapshot> snapshots){
		SqlSession session = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);
		final StockSnapshotMapper snapshotMapper = session.getMapper(StockSnapshotMapper.class);

		try{
			for (StockSnapshot snapshot : snapshots) {
				snapshotMapper.updateProfitAndLoss(snapshot);
			}
		}catch (Exception e){
			LOGGER.error("", e);
		}finally {
			session.commit();
			session.close();
		}
	}
}
