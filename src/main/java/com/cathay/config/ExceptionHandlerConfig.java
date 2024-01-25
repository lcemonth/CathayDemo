package com.cathay.config;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerConfig {
	

	static final Logger LOG =  LoggerFactory.getLogger(ExceptionHandlerConfig.class);

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, String>> handle(Exception exception){
		
		LOG.error("Exception: " + exception.getLocalizedMessage());
		
		Map<String, String> resMap = new HashMap<String, String>();
		resMap.put("ResponseCode", "400");
		resMap.put("ResponseMessage", "Exception: " + exception.getLocalizedMessage());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(resMap);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Map<String, String>> handle(RuntimeException exception){
		

		LOG.error("RuntimeException: " + exception.getLocalizedMessage());
		
		Map<String, String> resMap = new HashMap<String, String>();
		resMap.put("ResponseCode", "503");
		resMap.put("ResponseMessage", "RuntimeException: " + exception.getLocalizedMessage());
		
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
				.body(resMap);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Map<String, String>> handle(IllegalArgumentException exception){
		

		LOG.error("IllegalArgumentException: " + exception.getLocalizedMessage());
		
		Map<String, String> resMap = new HashMap<String, String>();
		resMap.put("ResponseCode", "400");
		resMap.put("ResponseMessage", "IllegalArgumentException: " + exception.getLocalizedMessage());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(resMap);
	}
}
