package com.cathay.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cathay.service.CurrencyService;
import com.cathay.vo.CurrencyVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Currency")
@Validated
@RestController
public class CurrencyController {
	
	static final Logger LOG = LoggerFactory.getLogger(CurrencyController.class);
	
	@Autowired
	private CurrencyService currencyService;
	
	@ApiOperation(value = "新增幣別", notes = "增加幣別", httpMethod = "POST")
	@PostMapping("/currencys")
	public ResponseEntity<Map<String, Object>> addCurrency(@RequestBody CurrencyVo currencyVo) {
		
		CurrencyVo addCurrencyVo =currencyService.addCurrency(currencyVo);
		
		Map<String, String> resMap = new HashMap<String, String>();
		resMap.put("ResponseCode", "200");
		resMap.put("ResponseMessage", "新增成功");
		
		return ResponseEntity.status(HttpStatus.OK).body(getResMap(resMap,addCurrencyVo));
	}
	
	@ApiOperation(value = "修改指定幣別", notes = "更換指定幣別", httpMethod = "PUT")
	@PutMapping("/currencys/{currencyID}")
	public ResponseEntity<Map<String, Object>> updCurrency(	@PathVariable Integer currencyID,
										@RequestBody @Valid CurrencyVo currencyVo) {
	
		CurrencyVo updCurrencyVo = currencyService.updCurrency(currencyID, currencyVo);

		Map<String, String> resMap = new HashMap<String, String>();


		resMap.put("ResponseCode", "200");
		if(updCurrencyVo!=null) {
			resMap.put("ResponseMessage", "修改資料成功!!");
		}else {
			resMap.put("ResponseMessage", "查無修改資料!!");
		}		

		return  ResponseEntity.status(HttpStatus.OK).body(getResMap(resMap,updCurrencyVo));
	}
	
	@ApiOperation(value = "刪除指定幣別", notes = "移除指定幣別", httpMethod = "DELETE")
	@DeleteMapping("/currencys/{currencyID}")
	public ResponseEntity<Map<String, Object>> delCurrency(	@PathVariable @NotNull Integer currencyID) {
		
		CurrencyVo currencyVo = currencyService.delCurrency(currencyID);
		String message = currencyVo!=null ? "刪除資料成功" : "查無刪除資料!!" ;
		
		Map<String, String> resMap = new HashMap<String, String>();
		resMap.put("ResponseCode", "200");
		resMap.put("ResponseMessage", message);
		
		return ResponseEntity.status(HttpStatus.OK).body(getResMap(resMap,currencyVo));
	}

	@ApiOperation(value = "取得指定幣別", notes = "列出指定幣別資訊", httpMethod = "GET")
	@GetMapping("/currencys/{currencyID}")
	public ResponseEntity<Map<String, Object>> findByCurrency(@PathVariable @NotNull Integer currencyID) {

		CurrencyVo currencyVo = currencyService.findByid(currencyID);
		

		Map<String, String> resMap = new HashMap<String, String>();

		resMap.put("ResponseCode", "200");
		if(currencyVo!=null) {
			resMap.put("ResponseMessage", "查詢成功!!");
		}else {
			resMap.put("ResponseMessage", "查無此資料!!");
		}
		return ResponseEntity.status(HttpStatus.OK).body(getResMap(resMap,currencyVo));
	}
	
	@ApiOperation(value = "取得所有幣別", notes = "Test", httpMethod = "GET")
	@GetMapping("/currencys/all")
	public ResponseEntity<Map<String, Object>> findAllCurrency() {

		List<CurrencyVo> currencyVoList = currencyService.findAllCurrency();

		Map<String, String> resMap = new HashMap<String, String>();
		resMap.put("ResponseCode", "200");
		resMap.put("ResponseMessage", "查詢成功!!");
		
		return ResponseEntity.status(HttpStatus.OK).body(getResMap(resMap,currencyVoList));
	}
	
	/**
	 * 回覆格式
	 * 
	 * */
	private Map<String,Object> getResMap(Map<String, String> resMap,Object objVo){
		Map<String, Object> messageMap = new HashMap<String, Object>();
		messageMap.put("message", resMap);
		
		if(objVo != null)
			messageMap.put(objVo.getClass().getSimpleName(), objVo);
		
		return messageMap;
	}
}
