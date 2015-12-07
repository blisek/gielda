package com.bartarts.market.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bartarts.market.mappers.SharePriceMapper;
import com.bartarts.market.model.to.SharePriceTo;
import com.bartarts.market.repositories.SharePriceRepository;
import com.bartarts.market.services.SharePriceService;

@Service("sharePriceService")
@Transactional(readOnly = true)
public class SharePriceServiceImpl implements SharePriceService {

	@Autowired
	private SharePriceRepository sharePriceRepository;

	@Override
	public List<SharePriceTo> findByDateBetween(Date start, Date end) {
		return SharePriceMapper.mapEntities(sharePriceRepository
				.findByDateBetween(start, end));
	}

	@Override
	public SharePriceTo findById(Long id) {
		return SharePriceMapper.map(sharePriceRepository.findOne(id));
	}

}
