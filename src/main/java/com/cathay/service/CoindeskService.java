package com.cathay.service;

import java.util.List;

import com.cathay.vo.CoindeskApiVo;
import com.cathay.vo.CoindeskVo;

public interface CoindeskService {
	
	public CoindeskApiVo findCoindeskApiV1();
	public List<CoindeskVo> findCoindeskApiV2();
}
