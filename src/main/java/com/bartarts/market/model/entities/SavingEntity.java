package com.bartarts.market.model.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class SavingEntity {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@Column(name = "currency", nullable = false)
	private String currency;

	@Column(name = "quantity", nullable = false)
	private BigDecimal quantity;

	@ManyToOne
	@JoinColumn(name = "wallet_id")
	private WalletEntity wallet;

	protected SavingEntity() {
	}

	public SavingEntity(Long id, String currency, BigDecimal quantity,
			WalletEntity wallet) {
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

	public WalletEntity getWallet() {
		return wallet;
	}

	public void setWallet(WalletEntity wallet) {
		this.wallet = wallet;
	}

}
