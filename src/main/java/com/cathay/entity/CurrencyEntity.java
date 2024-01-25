package com.cathay.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CURRENCY_TYPE")
public class CurrencyEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CURRENCY_ID")
	private Integer currencyID;
	
	
	@Column(name = "CURRENCY_CODE")
	private String currencyCode;

	@Column(name = "CURRENCY_NAME")
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
		return "CurrencyEntity [currencyID=" + currencyID + ", currencyCode=" + currencyCode + ", currencyName="
				+ currencyName + "]";
	}
	
}
