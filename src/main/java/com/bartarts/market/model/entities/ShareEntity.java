package com.bartarts.market.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ShareEntity {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "quantity")
	private Long quantity;

	@ManyToOne
	@JoinColumn(name = "holder", nullable = false)
	private WalletEntity holder;

	@ManyToOne
	@JoinColumn(name = "stock", nullable = false)
	private StockEntity stock;

	protected ShareEntity() {
	}

	public ShareEntity(Long id, Long quantity, WalletEntity holder,
			StockEntity stock) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.holder = holder;
		this.stock = stock;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public WalletEntity getHolder() {
		return holder;
	}

	public void setHolder(WalletEntity holder) {
		this.holder = holder;
	}

	public StockEntity getStock() {
		return stock;
	}

	public void setStock(StockEntity stock) {
		this.stock = stock;
	}

}
