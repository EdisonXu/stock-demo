package com.ex.demo.datagenertor;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Random;

/**
 * @author edison
 * On 2018/8/9 16:21
 */
@Service
public class QuoteInforMocker {

	final private Stock[] stocks = {
		new Stock("304123", "测试", 1),
			new Stock("000559", "万向钱潮", 3),
			new Stock("600241", "时代万恒", 101),
	};

	public void send(String url){
		RestUtil.postJson(url, mockQuote());
	}

	public Quote mockQuote(){
		Quote quote = new Quote();
		quote.setCreateTime(LocalDateTime.now(ZoneId.systemDefault()));
		Random random = new Random();
		Stock randomStock = stocks[random.nextInt(stocks.length)];
		quote.setStockId(randomStock.id);
		quote.setPrice(new BigDecimal(random.nextDouble()*randomStock.basePrice*0.2+randomStock.basePrice*0.9));
		return quote;
	}

	class Stock{
		String id;
		String name;
		double basePrice;

		public Stock(String id, String name, double basePrice) {
			this.id = id;
			this.name = name;
			this.basePrice = basePrice;
		}
	}
}
