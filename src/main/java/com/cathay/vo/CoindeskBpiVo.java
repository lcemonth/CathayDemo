package com.cathay.vo;

public class CoindeskBpiVo {
	String symbol;
	double rate_float;
	String code;
	String description;
	
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public double getRate_float() {
		return rate_float;
	}
	public void setRate_float(double rate_float) {
		this.rate_float = rate_float;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "CoindeskBpiVo [symbol=" + symbol + ", rate_float=" + rate_float + ", code=" + code + ", description="
				+ description + "]";
	}
}
