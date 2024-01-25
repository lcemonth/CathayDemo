package com.cathay.vo;

import java.util.Map;

public class CoindeskApiVo {
	String chartName;
	CoindeskDateVo time;
	String disclaimer;
	Map<String,CoindeskBpiVo> bpi;
	
	public String getChartName() {
		return chartName;
	}
	public void setChartName(String chartName) {
		this.chartName = chartName;
	}
	public CoindeskDateVo getTime() {
		return time;
	}
	public void setTime(CoindeskDateVo time) {
		this.time = time;
	}
	public String getDisclaimer() {
		return disclaimer;
	}
	public void setDisclaimer(String disclaimer) {
		this.disclaimer = disclaimer;
	}
	public Map<String, CoindeskBpiVo> getBpi() {
		return bpi;
	}
	public void setBpi(Map<String, CoindeskBpiVo> bpi) {
		this.bpi = bpi;
	}
	
	@Override
	public String toString() {
		return "CoindeskApiVo [chartName=" + chartName + ", time=" + time + ", disclaimer=" + disclaimer + ", bpi="
				+ bpi + "]";
	}
	
}
