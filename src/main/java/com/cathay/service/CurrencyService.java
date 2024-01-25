package com.cathay.service;

import java.util.List;

import com.cathay.vo.CurrencyVo;

public interface CurrencyService {
	public CurrencyVo addCurrency(CurrencyVo currencyVo);
	public CurrencyVo updCurrency(Integer currencyId ,CurrencyVo currencyVo);
	public CurrencyVo delCurrency(Integer currencyId);
	public CurrencyVo findByid(Integer currencyId);
	public CurrencyVo findByCurrencyCode(String currencyCode);
	public List<CurrencyVo> findAllCurrency();
}
