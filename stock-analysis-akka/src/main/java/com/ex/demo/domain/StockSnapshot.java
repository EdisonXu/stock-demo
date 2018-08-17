package com.ex.demo.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Objects;

/**
 * @author edison
 * On 2018/8/8 10:36
 */
public class StockSnapshot implements Serializable {

	private static final long serialVersionUID = 3017088361339344950L;

	private long userId;
	private String stockId;
	private String stockName;
	private BigDecimal cost;
	private long quantity;
	private BigDecimal profitAndLoss;
	private LocalDateTime lastUpdateTime;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getProfitAndLoss() {
		return profitAndLoss;
	}

	public void setProfitAndLoss(BigDecimal profitAndLoss) {
		this.profitAndLoss = profitAndLoss;
	}

	public LocalDateTime getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(LocalDateTime lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		StockSnapshot snapshot = (StockSnapshot) o;
		return userId == snapshot.userId &&
				stockId == snapshot.stockId &&
				quantity == snapshot.quantity &&
				Objects.equals(stockName, snapshot.stockName) &&
				Objects.equals(cost, snapshot.cost) &&
				Objects.equals(profitAndLoss, snapshot.profitAndLoss) &&
				Objects.equals(lastUpdateTime, snapshot.lastUpdateTime);
	}

	@Override
	public int hashCode() {

		return Objects.hash(userId, stockId, stockName, cost, quantity, profitAndLoss, lastUpdateTime);
	}

	public static StockSnapshot newFromOperateRecord(OperateRecord opRecord){
		StockSnapshot snapshot = new StockSnapshot();
		snapshot = new StockSnapshot();
		snapshot.setUserId(opRecord.getUserId());
		snapshot.setStockId(opRecord.getStockId());
		snapshot.setStockName(opRecord.getStockName());
		snapshot.setCost(BigDecimal.ZERO);
		snapshot.setQuantity(0);
		snapshot.setProfitAndLoss(BigDecimal.ZERO);
		snapshot.setLastUpdateTime(LocalDateTime.now(ZoneId.systemDefault()));
		return snapshot;
	}
}
