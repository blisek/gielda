package com.bartarts.market.services;

import java.util.List;

import com.bartarts.market.model.to.WalletTo;

public interface WalletService {
	List<WalletTo> findAll();

	WalletTo findById(Long id);

	WalletTo save(WalletTo wallet);

	void update(WalletTo wallet);

	void delete(Long id);
}
