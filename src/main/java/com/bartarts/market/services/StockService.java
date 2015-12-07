package com.bartarts.market.services;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.bartarts.market.model.to.StockTo;

public interface StockService {

	List<StockTo> findAll();

	List<StockTo> saveAll(Collection<StockTo> stocks);

	List<StockTo> findAllByDateBetween(Date start, Date end);

	List<StockTo> findAllByDate(Date date);

	Optional<StockTo> findByCompanyNameAndDate(String companyName, Date date);

	StockTo findById(Long id);

	StockTo save(StockTo stockTo);

	void update(StockTo stockTo);

	void delete(Long id);
}
