package com.bartarts.market.model.to;

import java.util.List;

public class StockTo {

	private Long id;
	private String companyName;
	private List<SharePriceTo> sharePrices;
	
	public StockTo() {}

	public StockTo(Long id, String companyName, List<SharePriceTo> sharePrices) {
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

	public List<SharePriceTo> getSharePrices() {
		return sharePrices;
	}

	public void setSharePrices(List<SharePriceTo> sharePrices) {
		this.sharePrices = sharePrices;
	}

	
}
