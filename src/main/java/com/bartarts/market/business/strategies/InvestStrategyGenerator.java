package com.bartarts.market.business.strategies;

import java.util.List;

import com.bartarts.market.model.to.StockTo;
import com.bartarts.market.model.to.WalletTo;

public interface InvestStrategyGenerator {

	InvestStrategy generate(WalletTo wallet, List<StockTo> stockTo);
}
