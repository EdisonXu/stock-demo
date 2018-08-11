package com.ex.demo.sa.controller;

import com.ex.demo.sa.domain.Quote;
import com.ex.demo.sa.mapper.QuoteMapper;
import com.ex.demo.sa.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author edison
 * On 2018/8/8 11:22
 */
@RestController
@RequestMapping("/quote")
@Transactional
public class QuoteController {

	@Autowired
	private QuoteMapper quoteMapper;
	@Autowired
	private QuoteService quoteService;

	@GetMapping
	@Transactional(readOnly = true)
	public List<Quote> findAll(){
		return quoteMapper.findAll();
	}

	@GetMapping("/{stock_id}")
	@Transactional(readOnly = true)
	public Quote getLatestQuoteInfo(@PathVariable(name = "stock_id") String stockId){
		return quoteMapper.getLatestQuoteInfo(stockId);
	}

	@PostMapping
	public void newQuote(@RequestBody Quote quote){
		quoteService.newQuote(quote);
	}
}
