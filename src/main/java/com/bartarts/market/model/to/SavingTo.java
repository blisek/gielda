package com.bartarts.market.model.to;

import java.math.BigDecimal;

public class SavingTo {

	private Long id;
	private String currency;
	private BigDecimal quantity;
	private WalletTo wallet;

	public SavingTo() {
	}

	public SavingTo(Long id, String currency, BigDecimal quantity,
			WalletTo wallet) {
		super();
		this.id = id;
		this.currency = currency;
		this.quantity = quantity;
		this.wallet = wallet;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public WalletTo getWallet() {
		return wallet;
	}

	public void setWallet(WalletTo wallet) {
		this.wallet = wallet;
	}

}
