package com.ex.demo.sa.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author edison
 * On 2018/8/8 11:13
 */
public class Quote implements Serializable {

	private static final long serialVersionUID = 973416137750930480L;

	private String stockId;
	private BigDecimal price;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createTime;

	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
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
		Quote quote = (Quote) o;
		return Objects.equals(stockId, quote.stockId) &&
				Objects.equals(price, quote.price) &&
				Objects.equals(createTime, quote.createTime);
	}

	@Override
	public int hashCode() {

		return Objects.hash(stockId, price, createTime);
	}
}
