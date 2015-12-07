package com.bartarts.market.business.structures;

import java.math.BigDecimal;

public class Offer {

	private final BigDecimal availableMoney;
	private final BigDecimal sharePrice;
	private final long amount;

	public Offer(BigDecimal availableMoney, BigDecimal sharePrice, long amount) {
		super();
		this.availableMoney = availableMoney;
		this.sharePrice = sharePrice;
		this.amount = amount;
	}

	public BigDecimal getAvailableMoney() {
		return availableMoney;
	}

	public BigDecimal getSharePrice() {
		return sharePrice;
	}

	public long getAmount() {
		return amount;
	}

}
