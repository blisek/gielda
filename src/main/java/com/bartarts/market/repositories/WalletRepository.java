package com.bartarts.market.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bartarts.market.model.entities.WalletEntity;

public interface WalletRepository extends JpaRepository<WalletEntity, Long> {

}
