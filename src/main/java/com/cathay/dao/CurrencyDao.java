package com.cathay.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cathay.entity.CurrencyEntity;

public interface  CurrencyDao extends JpaRepository<CurrencyEntity,Integer>{
	CurrencyEntity findByCurrencyCode(String currencyCode);
}
