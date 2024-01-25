package com.cathay.vo;

public class CoindeskDateVo {
	String updateduk;
	String updatedISO;
	String updated;
	public String getUpdateduk() {
		return updateduk;
	}
	public void setUpdateduk(String updateduk) {
		this.updateduk = updateduk;
	}
	public String getUpdatedISO() {
		return updatedISO;
	}
	public void setUpdatedISO(String updatedISO) {
		this.updatedISO = updatedISO;
	}
	public String getUpdated() {
		return updated;
	}
	public void setUpdated(String updated) {
		this.updated = updated;
	}
	
	@Override
	public String toString() {
		return "CoindeskDateVo [updateduk=" + updateduk + ", updatedISO=" + updatedISO + ", updated=" + updated + "]";
	}
	
	
}
