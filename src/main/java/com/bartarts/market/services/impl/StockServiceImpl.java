package com.bartarts.market.services.impl;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bartarts.market.mappers.StockMapper;
import com.bartarts.market.model.entities.StockEntity;
import com.bartarts.market.model.to.StockTo;
import com.bartarts.market.repositories.StockRepository;
import com.bartarts.market.services.StockService;

@Service("stockService")
@Transactional(readOnly = true)
public class StockServiceImpl implements StockService {

	@Autowired
	private StockRepository stockRepository;

	@Override
	public List<StockTo> findAll() {
		return StockMapper.mapEntities(stockRepository.findAll());
	}

	@Override
	@Transactional(readOnly = false)
	public List<StockTo> saveAll(Collection<StockTo> stocks) {
		List<StockEntity> entities = StockMapper.mapTo(stocks);
		List<StockEntity> persistedEntieties = stockRepository.save(entities);
		return StockMapper.mapEntities(persistedEntieties);
	}

	@Override
	@Transactional(readOnly = false)
	public StockTo save(StockTo stockTo) {
		StockEntity tmp = StockMapper.map(stockTo);
		tmp = stockRepository.save(tmp);
		return StockMapper.map(tmp);
	}

	@Override
	public List<StockTo> findAllByDateBetween(Date start, Date end) {
		return StockMapper.mapEntities(stockRepository.findAllDateBetween(
				start, end));
	}

	@Override
	public List<StockTo> findAllByDate(Date date) {
		return StockMapper.mapEntities(stockRepository.findAllByDate(date));
	}

	@Override
	public Optional<StockTo> findByCompanyNameAndDate(String companyName,
			Date date) {
		List<StockEntity> entities = stockRepository.findByCompanyNameAndDate(
				companyName, date);
		return entities.isEmpty() ? Optional.<StockTo> empty() : Optional
				.of(StockMapper.map(entities.get(0)));
	}

	@Override
	public StockTo findById(Long id) {
		return StockMapper.map(stockRepository.findOne(id));
	}

	@Override
	@Transactional(readOnly = false)
	public void update(StockTo stockTo) {
		StockEntity tmp = StockMapper.map(stockTo);
		stockRepository.save(tmp);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Long id) {
		stockRepository.delete(id);
	}

}
