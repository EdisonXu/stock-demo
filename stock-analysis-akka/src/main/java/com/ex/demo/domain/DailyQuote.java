package com.ex.demo.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author edison
 * On 2018/8/8 11:23
 */
public class DailyQuote {

	private String stockId;
	private BigDecimal prevClosePrice;
	private BigDecimal openPrice;
	private BigDecimal highPrice;
	private BigDecimal lowPrice;
	private BigDecimal closePrice;
	private LocalDate tradingDay;

	public BigDecimal getPrevClosePrice() {
		return prevClosePrice;
	}

	public void setPrevClosePrice(BigDecimal prevClosePrice) {
		this.prevClosePrice = prevClosePrice;
	}

	public BigDecimal getOpenPrice() {
		return openPrice;
	}

	public void setOpenPrice(BigDecimal openPrice) {
		this.openPrice = openPrice;
	}

	public BigDecimal getHighPrice() {
		return highPrice;
	}

	public void setHighPrice(BigDecimal highPrice) {
		this.highPrice = highPrice;
	}

	public BigDecimal getLowPrice() {
		return lowPrice;
	}

	public void setLowPrice(BigDecimal lowPrice) {
		this.lowPrice = lowPrice;
	}

	public BigDecimal getClosePrice() {
		return closePrice;
	}

	public void setClosePrice(BigDecimal closePrice) {
		this.closePrice = closePrice;
	}

	public LocalDate getTradingDay() {
		return tradingDay;
	}

	public void setTradingDay(LocalDate tradingDay) {
		this.tradingDay = tradingDay;
	}

	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}
}
