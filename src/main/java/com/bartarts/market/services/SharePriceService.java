package com.bartarts.market.services;

import java.util.Date;
import java.util.List;

import com.bartarts.market.model.to.SharePriceTo;

public interface SharePriceService {

	List<SharePriceTo> findByDateBetween(Date start, Date end);

	SharePriceTo findById(Long id);
}
