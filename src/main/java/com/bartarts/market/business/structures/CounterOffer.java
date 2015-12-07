package com.bartarts.market.business.structures;

import java.math.BigDecimal;

public class CounterOffer {

	private final long amount;
	private final BigDecimal totalPrice;

	public CounterOffer(long amount, BigDecimal totalPrice) {
		super();
		this.amount = amount;
		this.totalPrice = totalPrice;
	}

	public long getAmount() {
		return amount;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

}
