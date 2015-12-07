package com.bartarts.market.business.strategies;

import java.util.Date;

import com.bartarts.market.exceptions.DateOutOfGivenBoundsException;

public interface InvestStrategy {

	void simulate(Date from, Date to) throws DateOutOfGivenBoundsException;
}
