package com.bartarts.market.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bartarts.market.model.entities.StockEntity;

public interface StockRepository extends JpaRepository<StockEntity, Long> {

	@Query("SELECT DISTINCT s FROM StockEntity s JOIN FETCH s.sharePrices p WHERE p.date BETWEEN :start AND :end")
	List<StockEntity> findAllDateBetween(@Param("start") Date start,
			@Param("end") Date end);

	@Query("SELECT DISTINCT s FROM StockEntity s JOIN FETCH s.sharePrices p WHERE p.date = :date")
	List<StockEntity> findAllByDate(@Param("date") Date date);

	@Query("SELECT DISTINCT s FROM StockEntity s JOIN FETCH s.sharePrices p WHERE s.companyName = :name AND p.date = :date")
	List<StockEntity> findByCompanyNameAndDate(
			@Param("name") String companyName, @Param("date") Date date);
}
