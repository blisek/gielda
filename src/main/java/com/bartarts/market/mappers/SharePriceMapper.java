package com.bartarts.market.mappers;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.bartarts.market.model.entities.SharePriceEntity;
import com.bartarts.market.model.to.SharePriceTo;

public class SharePriceMapper {

	public static SharePriceTo map(SharePriceEntity sharePriceEntity) {
		if (sharePriceEntity != null) {
			return new SharePriceTo(sharePriceEntity.getId(),
					sharePriceEntity.getDate(), sharePriceEntity.getPrice(),
					sharePriceEntity.getStock().getId());
		}
		return null;
	}

	public static SharePriceEntity map(SharePriceTo sharePriceTo) {
		if (sharePriceTo != null) {
			return new SharePriceEntity(sharePriceTo.getId(),
					sharePriceTo.getDate(), sharePriceTo.getPrice(), null);
		}
		return null;
	}

	public static List<SharePriceTo> mapEntities(
			Collection<SharePriceEntity> entities) {
		if (entities != null) {
			return entities.stream().map(SharePriceMapper::map)
					.collect(Collectors.toList());
		}
		return null;
	}

	public static List<SharePriceEntity> mapTo(
			Collection<SharePriceTo> sharePriceTos) {
		if (sharePriceTos != null) {
			return sharePriceTos.stream().map(SharePriceMapper::map)
					.collect(Collectors.toList());
		}
		return null;
	}
}
