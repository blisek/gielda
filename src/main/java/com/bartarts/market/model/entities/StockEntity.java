package com.bartarts.market.model.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "stock")
public class StockEntity {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@Column(name = "company_name", nullable = false)
	private String companyName;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "stock", cascade = { CascadeType.ALL })
	private List<SharePriceEntity> sharePrices;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "stock", cascade = { CascadeType.ALL })
	private List<ShareEntity> shares;

	protected StockEntity() {
	}

	public StockEntity(Long id, String companyName,
			List<SharePriceEntity> sharePrices) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.sharePrices = sharePrices;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public List<SharePriceEntity> getSharePrices() {
		return sharePrices;
	}

	public void setSharePrices(List<SharePriceEntity> sharePrices) {
		this.sharePrices = sharePrices;
	}

}
