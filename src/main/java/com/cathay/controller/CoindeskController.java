package com.cathay.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cathay.service.CoindeskService;
import com.cathay.vo.CoindeskApiVo;
import com.cathay.vo.CoindeskVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Coindesk")
@RestController
public class CoindeskController {

	static final Logger LOG = LoggerFactory.getLogger(CoindeskController.class);
	
	@Autowired
	private CoindeskService coindeskService;
	
	@ApiOperation(value = "呼叫 coindesk API", notes = "coindesk API", httpMethod = "GET")
	@GetMapping("/coindesk/v1")
	public ResponseEntity<CoindeskApiVo> findCoindeskApiV1() {
		
		LOG.info("Coindesk API V1");
		
		CoindeskApiVo  coindeskApiVo = coindeskService.findCoindeskApiV1();
		
		LOG.info("CoindeskApiVo" + coindeskApiVo.toString());
		
		return ResponseEntity.status(HttpStatus.OK).body(coindeskApiVo);
	}
	
	@ApiOperation(value = "呼叫 coindesk 資料轉換的 API", notes = "coindesk API（幣別，中文名稱，和匯率）", httpMethod = "GET")
	@GetMapping("/coindesk/v2")
	public ResponseEntity<List<CoindeskVo>> findCoindeskApiV2() {

		LOG.info("Coindesk API V2");
		
		List<CoindeskVo> coindeskVoList = coindeskService.findCoindeskApiV2();
		
		return ResponseEntity.status(HttpStatus.OK).body(coindeskVoList);
	}
	
}
