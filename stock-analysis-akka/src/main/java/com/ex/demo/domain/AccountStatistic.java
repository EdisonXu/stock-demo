package com.ex.demo.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author edison
 * On 2018/8/8 10:57
 */
public class AccountStatistic {

	private long userId;
	private BigDecimal capital;
	private BigDecimal profitAndLoss;
	private BigDecimal yield;
	private LocalDateTime fromTime;
	private LocalDateTime createTime;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public BigDecimal getCapital() {
		return capital;
	}

	public void setCapital(BigDecimal capital) {
		this.capital = capital;
	}

	public BigDecimal getProfitAndLoss() {
		return profitAndLoss;
	}

	public void setProfitAndLoss(BigDecimal profitAndLoss) {
		this.profitAndLoss = profitAndLoss;
	}

	public BigDecimal getYield() {
		return yield;
	}

	public void setYield(BigDecimal yield) {
		this.yield = yield;
	}

	public LocalDateTime getFromTime() {
		return fromTime;
	}

	public void setFromTime(LocalDateTime fromTime) {
		this.fromTime = fromTime;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}
}
