package com.bartarts.market.business.strategies.impl;

import java.util.Date;
import java.util.List;

import com.bartarts.market.business.strategies.InvestStrategy;
import com.bartarts.market.exceptions.DateOutOfGivenBoundsException;
import com.bartarts.market.model.to.StockTo;
import com.bartarts.market.model.to.WalletTo;

public class FallowTrendStrategy implements InvestStrategy {

	private WalletTo wallet;

	private List<StockTo> stocks;

	FallowTrendStrategy(WalletTo wallet, List<StockTo> stocks) {
		this.wallet = wallet;
		this.stocks = stocks;
	}

	@Override
	public void simulate(Date from, Date to)
			throws DateOutOfGivenBoundsException {
		// TODO Auto-generated method stub

	}

}
