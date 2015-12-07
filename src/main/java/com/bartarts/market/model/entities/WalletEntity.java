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
@Table(name = "wallet")
public class WalletEntity {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL }, mappedBy = "wallet")
	private List<SavingEntity> savings;

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL }, mappedBy = "holder")
	private List<ShareEntity> shares;

	protected WalletEntity() {
	}

	public WalletEntity(Long id, String firstName, String lastName,
			List<SavingEntity> savings, List<ShareEntity> shares) {
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

	public List<SavingEntity> getSavings() {
		return savings;
	}

	public void setSavings(List<SavingEntity> savings) {
		this.savings = savings;
	}

	public List<ShareEntity> getShares() {
		return shares;
	}

	public void setShares(List<ShareEntity> shares) {
		this.shares = shares;
	}

}
