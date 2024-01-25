package com.cathay.vo;

import javax.validation.constraints.NotBlank;

public class CurrencyVo {
	
	private Integer currencyID;
	
	@NotBlank
	private String currencyCode;

	@NotBlank
	private String currencyName;

	public Integer getCurrencyID() {
		return currencyID;
	}

	public void setCurrencyID(Integer currencyID) {
		this.currencyID = currencyID;
	}

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

	@Override
	public String toString() {
		return "CurrencyVo [currencyID=" + currencyID + ", currencyCode=" + currencyCode + ", currencyName="
				+ currencyName + "]";
	}
	
}
