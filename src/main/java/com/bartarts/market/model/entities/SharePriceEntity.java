package com.bartarts.market.model.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "share_price")
public class SharePriceEntity {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(name = "date", nullable = false)
	private Date date;

	@Column(name = "price", nullable = false)
	private BigDecimal price;

	@ManyToOne
	@JoinColumn(name = "stock_id")
	private StockEntity stock;

	protected SharePriceEntity() {
	}

	public SharePriceEntity(Long id, Date date, BigDecimal price,
			StockEntity stock) {
		super();
		this.id = id;
		this.date = date;
		this.price = price;
		this.stock = stock;
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

	public StockEntity getStock() {
		return stock;
	}

	public void setStock(StockEntity stock) {
		this.stock = stock;
	}

}
