package com.bartarts.market.business.brokerage;

import com.bartarts.market.business.structures.CounterOffer;
import com.bartarts.market.business.structures.Offer;

public interface Brokerage {

	CounterOffer buy(Offer offer);

	CounterOffer sell(Offer offer);
}
