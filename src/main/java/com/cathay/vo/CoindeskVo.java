package com.cathay.vo;

public class CoindeskVo {
	private String currencyCode;
	private String currencyName;
	private String exchangeRate;
	private String updateDate;
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public String getCurrencyName() {
		return currencyName;
	}
	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}
	public String getExchangeRate() {
		return exchangeRate;
	}
	public void setExchangeRate(String exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	
	@Override
	public String toString() {
		return "CoindeskVo [currencyCode=" + currencyCode + ", currencyName=" + currencyName + ", exchangeRate="
				+ exchangeRate + ", updateDate=" + updateDate + "]";
	}
	
	
}
