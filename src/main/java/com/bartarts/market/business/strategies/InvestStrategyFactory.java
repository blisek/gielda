package com.bartarts.market.business.strategies;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bartarts.market.business.strategies.impl.FallowTrendStrategyGenerator;
import com.bartarts.market.model.to.StockTo;
import com.bartarts.market.model.to.WalletTo;
import com.bartarts.market.services.StockService;

@Component
public class InvestStrategyFactory {

	@Autowired
	private StockService stockService;

	protected InvestStrategyFactory() {
		if (generators == null) {
			generators = new HashMap<String, InvestStrategyGenerator>();

			generators.put("fallowTrend", new FallowTrendStrategyGenerator());
		}
	}

	public InvestStrategy getStrategy(String strategyName, WalletTo wallet) {
		InvestStrategyGenerator generator = generators.get(strategyName);
		if (generator != null) {
			List<StockTo> stocks = stockService.findAll();
			return generator.generate(wallet, stocks);
		}
		return null;
	}

	public InvestStrategy getStrategy(String strategyName, WalletTo wallet,
			Date from, Date to) {
		InvestStrategyGenerator generator = generators.get(strategyName);
		if (generator != null) {
			List<StockTo> stocks = stockService.findAllByDateBetween(from, to);
			return generator.generate(wallet, stocks);
		}
		return null;
	}

	public Set<String> getGenerators() {
		return new HashSet<>(generators.keySet());
	}

	private static HashMap<String, InvestStrategyGenerator> generators;
}
