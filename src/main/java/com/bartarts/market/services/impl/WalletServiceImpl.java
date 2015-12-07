package com.bartarts.market.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bartarts.market.mappers.WalletMapper;
import com.bartarts.market.model.entities.WalletEntity;
import com.bartarts.market.model.to.WalletTo;
import com.bartarts.market.repositories.WalletRepository;
import com.bartarts.market.services.WalletService;

@Service("walletService")
@Transactional(readOnly = true)
public class WalletServiceImpl implements WalletService {

	@Autowired
	private WalletRepository walletRepository;

	@Override
	public List<WalletTo> findAll() {
		return WalletMapper.mapEntities(walletRepository.findAll());
	}

	@Override
	public WalletTo findById(Long id) {
		return WalletMapper.map(walletRepository.findOne(id));
	}

	@Override
	@Transactional(readOnly = false)
	public WalletTo save(WalletTo wallet) {
		WalletEntity entity = WalletMapper.map(wallet);
		entity = walletRepository.save(entity);
		return WalletMapper.map(entity);
	}

	@Override
	@Transactional(readOnly = false)
	public void update(WalletTo wallet) {
		WalletEntity entity = WalletMapper.map(wallet);
		walletRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Long id) {
		walletRepository.delete(id);
	}

}
