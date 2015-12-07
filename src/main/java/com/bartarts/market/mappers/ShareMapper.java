package com.bartarts.market.mappers;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.bartarts.market.model.entities.ShareEntity;
import com.bartarts.market.model.to.ShareTo;

public class ShareMapper {

	public static ShareTo map(ShareEntity shareEntity) {
		if (shareEntity != null)
			return new ShareTo(shareEntity.getId(), shareEntity.getQuantity(),
					null, null);
		return null;
	}

	public static ShareEntity map(ShareTo shareTo) {
		if (shareTo != null)
			return new ShareEntity(shareTo.getId(), shareTo.getQuantity(),
					WalletMapper.map(shareTo.getHolder()),
					StockMapper.map(shareTo.getStock()));
		return null;
	}

	public static List<ShareTo> mapEntities(Collection<ShareEntity> entities) {
		if (entities != null)
			return entities.stream().map(ShareMapper::map)
					.collect(Collectors.toList());
		return null;
	}

	public static List<ShareEntity> mapTo(Collection<ShareTo> shareTos) {
		if (shareTos != null)
			return shareTos.stream().map(ShareMapper::map)
					.collect(Collectors.toList());
		return null;
	}

}
