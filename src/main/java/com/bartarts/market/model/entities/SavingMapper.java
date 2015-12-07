package com.bartarts.market.model.entities;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.bartarts.market.mappers.WalletMapper;
import com.bartarts.market.model.to.SavingTo;

public class SavingMapper {

	public static SavingTo map(SavingEntity entity) {
		if (entity != null) {
			return new SavingTo(entity.getId(), entity.getCurrency(),
					entity.getQuantity(), null);
		}
		return null;
	}

	public static SavingEntity map(SavingTo to) {
		if (to != null) {
			return new SavingEntity(to.getId(), to.getCurrency(),
					to.getQuantity(), WalletMapper.map(to.getWallet()));
		}
		return null;
	}

	public static List<SavingEntity> mapTo(Collection<SavingTo> tos) {
		if (tos != null) {
			return tos.stream().map(SavingMapper::map)
					.collect(Collectors.toList());
		}
		return null;
	}

	public static List<SavingTo> mapEntities(Collection<SavingEntity> entities) {
		if (entities != null) {
			return entities.stream().map(SavingMapper::map)
					.collect(Collectors.toList());
		}
		return null;
	}
}
