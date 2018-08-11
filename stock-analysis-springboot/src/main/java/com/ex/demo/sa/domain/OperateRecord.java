package com.ex.demo.sa.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author edison
 * On 2018/8/8 10:12
 */
public class OperateRecord implements Serializable {

	private static final long serialVersionUID = -3156188674120608284L;

	private long userId;
	private String stockId;
	private String stockName;
	private BigDecimal price;
	private long quantity;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createTime;

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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		OperateRecord that = (OperateRecord) o;
		return userId == that.userId &&
				stockId == that.stockId &&
				quantity == that.quantity &&
				Objects.equals(stockName, that.stockName) &&
				Objects.equals(price, that.price) &&
				Objects.equals(createTime, that.createTime);
	}

	@Override
	public int hashCode() {

		return Objects.hash(userId, stockId, stockName, price, quantity, createTime);
	}
}
