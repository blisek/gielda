package com.bartarts.market.model.to;

import java.util.List;

public class WalletTo {
	private Long id;
	private String firstName;
	private String lastName;
	private List<SavingTo> savings;
	private List<ShareTo> shares;

	public WalletTo() {
	}

	public WalletTo(Long id, String firstName, String lastName,
			List<SavingTo> savings, List<ShareTo> shares) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.savings = savings;
		this.shares = shares;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<SavingTo> getSavings() {
		return savings;
	}

	public void setSavings(List<SavingTo> savings) {
		this.savings = savings;
	}

	public List<ShareTo> getShares() {
		return shares;
	}

	public void setShares(List<ShareTo> shares) {
		this.shares = shares;
	}

}
