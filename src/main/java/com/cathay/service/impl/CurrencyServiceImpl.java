package com.cathay.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cathay.dao.CurrencyDao;
import com.cathay.entity.CurrencyEntity;
import com.cathay.service.CurrencyService;
import com.cathay.vo.CurrencyVo;


@Component
@Transactional
public class CurrencyServiceImpl implements CurrencyService{

	static final Logger LOG = LoggerFactory.getLogger(CurrencyServiceImpl.class);
	
	@Autowired
	private CurrencyDao currencyDao;
	
	@Override
	public CurrencyVo addCurrency(CurrencyVo currencyVo) {
		
		LOG.info("addCurrency method: currencyVo = " + currencyVo.toString());
		
		CurrencyEntity currencyEntity = new CurrencyEntity();
		BeanUtils.copyProperties(currencyVo, currencyEntity);
		
		currencyEntity = currencyDao.save(currencyEntity);

		BeanUtils.copyProperties(currencyEntity, currencyVo);
		
		return currencyVo;
	}

	@Override
	public CurrencyVo updCurrency(Integer currencyId, CurrencyVo currencyVo) {
		LOG.info("updCurrency method: currencyId = " + currencyId);
		LOG.info("updCurrency method: currencyVo = " + currencyVo.toString());
		
		CurrencyEntity findByCurrencyEntity = currencyDao.findById(currencyId).orElse(null);

		
		CurrencyEntity currencyEntity = null;
		
		if(findByCurrencyEntity != null) {

			LOG.info("updCurrency method: findByCurrencyEntity = " + findByCurrencyEntity.toString());
			
			BeanUtils.copyProperties(currencyVo, findByCurrencyEntity);
			currencyEntity = currencyDao.save(findByCurrencyEntity);
			BeanUtils.copyProperties(currencyEntity, currencyVo);

			return currencyVo;
		}else {
			return null;
		}
	}

	@Override
	public CurrencyVo delCurrency(Integer currencyId) {
		
		LOG.info("delCurrency method: currencyId = " + currencyId);
		
		CurrencyEntity findByCurrencyEntity = currencyDao.findById(currencyId).orElse(null);
		
		CurrencyVo currencyVo = null;
		
		if(findByCurrencyEntity != null) {

			LOG.info("delCurrency method: findByCurrencyEntity = " + findByCurrencyEntity.toString());
			
			currencyDao.deleteById(currencyId);
			
			currencyVo = new CurrencyVo();
			BeanUtils.copyProperties(findByCurrencyEntity, currencyVo);
			
			return currencyVo;
		}else {

			return null;
		}
	}

	@Override
	public CurrencyVo findByid(Integer currencyId) {

		LOG.info("findByid method: currencyId = " + currencyId);
		
		CurrencyEntity currencyEntity = currencyDao.findById(currencyId).orElse(null);
		
		if(currencyEntity != null) {
			
			CurrencyVo currencyVo = new CurrencyVo();
			BeanUtils.copyProperties(currencyEntity, currencyVo);
			
			return currencyVo;
		}else {
			return null;
		}
	}

	@Override
	public CurrencyVo findByCurrencyCode(String currencyCode) {
		LOG.info("findByid method: currencyCode = " + currencyCode);
		
		CurrencyEntity currencyEntity = currencyDao.findByCurrencyCode(currencyCode);
		CurrencyVo currencyVo = new CurrencyVo();
		BeanUtils.copyProperties(currencyEntity, currencyVo);
		
		return currencyVo;
	}

	@Override
	public List<CurrencyVo> findAllCurrency() {
		LOG.info("findAllCurrency method");
		
		List<CurrencyEntity> currencyEntityList = currencyDao.findAll();
		
		List<CurrencyVo> currencyVoList = currencyEntityList.stream().map(emt ->{
			CurrencyVo currencyVo = new CurrencyVo();
			BeanUtils.copyProperties(emt, currencyVo);
			return currencyVo;
		}).collect(Collectors.toList());
		
		LOG.info("findAllCurrency method: CurrencyVo = "+ currencyEntityList.toString());
		
		return currencyVoList;
	}

}
