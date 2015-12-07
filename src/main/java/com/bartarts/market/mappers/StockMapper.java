package com.bartarts.market.mappers;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.bartarts.market.model.entities.SharePriceEntity;
import com.bartarts.market.model.entities.StockEntity;
import com.bartarts.market.model.to.StockTo;

public class StockMapper {

	public static StockTo map(StockEntity stockEntity) {
		if (stockEntity != null) {
			return new StockTo(stockEntity.getId(),
					stockEntity.getCompanyName(),
					SharePriceMapper.mapEntities(stockEntity.getSharePrices()));
		}
		return null;
	}

	public static StockEntity map(StockTo stockTo) {
		if (stockTo != null) {
			StockEntity stockEntity = new StockEntity(stockTo.getId(),
					stockTo.getCompanyName(), null);
			List<SharePriceEntity> sharePrices = SharePriceMapper.mapTo(stockTo
					.getSharePrices());
			sharePrices.forEach(sp -> sp.setStock(stockEntity));
			stockEntity.setSharePrices(sharePrices);
			return stockEntity;
		}
		return null;
	}

	public static List<StockTo> mapEntities(Collection<StockEntity> entities) {
		if (entities != null) {
			return entities.stream().map(StockMapper::map)
					.collect(Collectors.toList());
		}
		return null;
	}

	public static List<StockEntity> mapTo(Collection<StockTo> stockTos) {
		if (stockTos != null) {
			return stockTos.stream().map(StockMapper::map)
					.collect(Collectors.toList());
		}
		return null;
	}
}
