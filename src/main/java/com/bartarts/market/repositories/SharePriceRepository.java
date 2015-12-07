package com.bartarts.market.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bartarts.market.model.entities.SharePriceEntity;

public interface SharePriceRepository extends
		JpaRepository<SharePriceEntity, Long> {

	List<SharePriceEntity> findByDateBetween(Date start, Date end);
}
