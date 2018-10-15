package com.dtelec.icmes.information.service.model;


public class DeviceValueModel {
		
	private int id;
	private long netValuePeriod;
	private double grossOrgValue;
	private double grossNetValue;
	private double newnessCoefficient;
	private String versionTag;
	private long createTime;
	private long updateTime;
		
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public long getNetValuePeriod() {
		return netValuePeriod;
	}
	
	public void setNetValuePeriod(long netValuePeriod) {
		this.netValuePeriod = netValuePeriod;
	}
	
	public double getGrossOrgValue() {
		return grossOrgValue;
	}
	
	public void setGrossOrgValue(double grossOrgValue) {
		this.grossOrgValue = grossOrgValue;
	}
	
	public double getGrossNetValue() {
		return grossNetValue;
	}
	
	public void setGrossNetValue(double grossNetValue) {
		this.grossNetValue = grossNetValue;
	}
	
	public double getNewnessCoefficient() {
		return newnessCoefficient;
	}

	public void setNewnessCoefficient(double newnessCoefficient) {
		this.newnessCoefficient = newnessCoefficient;
	}

	public String getVersionTag() {
		return versionTag;
	}
	
	public void setVersionTag(String versionTag) {
		this.versionTag = versionTag;
	}
	
	public long getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	
	public long getUpdateTime() {
		return updateTime;
	}
	
	public void setUpdateTime(long updateTime) {
		this.updateTime = updateTime;
	}
}
