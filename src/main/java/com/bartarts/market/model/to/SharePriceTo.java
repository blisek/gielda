package com.bartarts.market.model.to;

import java.math.BigDecimal;
import java.util.Date;

public class SharePriceTo {

	private Long id;
	private Date date;
	private BigDecimal price;
	private Long stockId;

	public SharePriceTo() {
	}

	public SharePriceTo(Long id, Date date, BigDecimal price, Long stockId) {
		super();
		this.id = id;
		this.date = date;
		this.price = price;
		this.stockId = stockId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Long getStockId() {
		return stockId;
	}

	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}

}
