package com.bartarts.market.model.to;


public class ShareTo {

	private Long id;
	private Long quantity;
	private WalletTo holder;
	private StockTo stock;

	public ShareTo() {
	}

	public ShareTo(Long id, Long quantity, WalletTo holder, StockTo stock) {
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

	public WalletTo getHolder() {
		return holder;
	}

	public void setHolder(WalletTo holder) {
		this.holder = holder;
	}

	public StockTo getStock() {
		return stock;
	}

	public void setStock(StockTo stock) {
		this.stock = stock;
	}

}
