package com.bartarts.market.business.strategies.impl;

import java.util.List;

import com.bartarts.market.business.strategies.InvestStrategy;
import com.bartarts.market.business.strategies.InvestStrategyGenerator;
import com.bartarts.market.model.to.StockTo;
import com.bartarts.market.model.to.WalletTo;

public class FallowTrendStrategyGenerator implements InvestStrategyGenerator {

	@Override
	public InvestStrategy generate(WalletTo wallet, List<StockTo> stock) {
		return new FallowTrendStrategy(wallet, stock);
	}

}
