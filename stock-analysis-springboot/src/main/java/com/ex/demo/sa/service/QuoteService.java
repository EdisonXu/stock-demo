package com.ex.demo.sa.service;

import com.ex.demo.sa.domain.Quote;
import com.ex.demo.sa.mapper.QuoteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author edison
 * On 2018/8/8 17:29
 */
@Service
public class QuoteService {

	@Autowired
	private QuoteMapper quoteMapper;
	@Autowired
	private CalculateService calculateService;

	public void newQuote(Quote quote){
		// insert new record into db
		quoteMapper.insert(quote);
		// trigger calculation of the StockSnapshot
		calculateService.calculateSnapshotByQuote(quote);
	}

	public Quote getLatestQuote(String stockId){
		return quoteMapper.getLatestQuoteInfo(stockId);
	}
}
