package com.bartarts.market.business.brokerage.impl;

import java.math.BigDecimal;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.bartarts.market.business.brokerage.Brokerage;
import com.bartarts.market.business.structures.CounterOffer;
import com.bartarts.market.business.structures.Offer;

@Component("brokerage")
public class BrokerageImpl implements Brokerage {

	private Random randomEngine = new Random();

	@Override
	public CounterOffer buy(Offer offer) {
		long amountFactor = (randomEngine.nextInt(3) + 8);
		double priceFactor = (randomEngine.nextInt(3) + 100) / 100.0;

		long newAmount = offer.getAmount() * amountFactor / 10;
		BigDecimal newAmountBD = new BigDecimal(newAmount);
		BigDecimal newPrice = offer.getSharePrice().multiply(
				new BigDecimal(priceFactor));
		BigDecimal totalCost = newPrice.multiply(newAmountBD);

		if (totalCost.compareTo(offer.getAvailableMoney()) > 0) {
			BigDecimal diff = totalCost.subtract(offer.getAvailableMoney());
			long amount = diff.divide(newPrice).longValue() + 1;
			newAmount -= amount;
			totalCost = newPrice.multiply(new BigDecimal(newAmount));
		}

		return new CounterOffer(newAmount, totalCost);
	}

	@Override
	public CounterOffer sell(Offer offer) {
		long amountFactor = (randomEngine.nextInt(3) + 8);
		double priceFactor = (randomEngine.nextInt(3) + 98) / 100.0;

		long newAmount = offer.getAmount() * amountFactor / 10;
		BigDecimal newPrice = offer.getSharePrice().multiply(
				new BigDecimal(priceFactor));
		BigDecimal totalCost = newPrice.multiply(new BigDecimal(newAmount));

		return new CounterOffer(newAmount, totalCost);
	}

}
