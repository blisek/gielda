package com.bartarts.market.mappers;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.bartarts.market.model.entities.SavingMapper;
import com.bartarts.market.model.entities.WalletEntity;
import com.bartarts.market.model.to.WalletTo;

public class WalletMapper {

	public static WalletTo map(WalletEntity entity) {
		if (entity != null) {
			return new WalletTo(entity.getId(), entity.getFirstName(),
					entity.getLastName(), SavingMapper.mapEntities(entity
							.getSavings()), ShareMapper.mapEntities(entity
							.getShares()));
		}
		return null;
	}

	public static WalletEntity map(WalletTo to) {
		if (to != null) {
			return new WalletEntity(to.getId(), to.getFirstName(),
					to.getLastName(), SavingMapper.mapTo(to.getSavings()),
					ShareMapper.mapTo(to.getShares()));
		}
		return null;
	}

	public static List<WalletTo> mapEntities(Collection<WalletEntity> entities) {
		if (entities != null) {
			return entities.stream().map(WalletMapper::map)
					.collect(Collectors.toList());
		}
		return null;
	}

	public static List<WalletEntity> mapTo(Collection<WalletTo> tos) {
		if (tos != null) {
			return tos.stream().map(WalletMapper::map)
					.collect(Collectors.toList());
		}
		return null;
	}

	public static WalletTo mapLazy(WalletEntity entity, boolean includeSaving,
			boolean includeShares) {
		if (entity != null) {
			return new WalletTo(
					entity.getId(),
					entity.getFirstName(),
					entity.getLastName(),
					(includeSaving ? SavingMapper.mapEntities(entity
							.getSavings()) : null),
					(includeShares ? ShareMapper.mapEntities(entity.getShares())
							: null));
		}
		return null;
	}

}
