package com.ex.demo.sa.mapper;

import com.ex.demo.sa.domain.StockSnapshot;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author edison
 * On 2018/8/8 17:52
 */
@Mapper
public interface StockSnapshotMapper {

	void insertOrUpdate(StockSnapshot snapshot);
	void batchUpdateProfitAndLoss(List<StockSnapshot> list);
	void updateProfitAndLoss(StockSnapshot snapshot);
	StockSnapshot findByUserIdAndStockId(long userId, String stockId);
	List<StockSnapshot> findByStockId(String stockId);

}
