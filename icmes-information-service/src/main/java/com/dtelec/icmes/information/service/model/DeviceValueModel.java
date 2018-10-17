package com.dtelec.icmes.information.service.model;

import java.util.Date;

import com.dtelec.icmes.information.repository.entity.DeviceValueEntity;

/**
 * 设备净值 Model
 */
public class DeviceValueModel {
		
	/**
	 * 设备净值序号
	 */
	private int id;

	/**
	 * 净值周期
	 */
	private long netValuePeriod;

	/**
	 * 设备总原值
	 */
	private double grossOrgValue;

	/**
	 * 设备总净值
	 */
	private double grossNetValue;

	/**
	 * 新度系数
	 */
	private double newnessCoefficient;

	/**
	 * 版本控制
	 */
	private String versionTag;

	/**
	 * 创建时间
	 */
	private long createTime;

	/**
	 * 修改时间
	 */
	private long updateTime;

	/**
	 * 设备净值副职
	 * @param entity 实体
	 */
	public void fillModel(DeviceValueEntity entity) {
		this.id = entity.getId();
		Date netValuePeriod = entity.getNetValuePeriod();
		this.netValuePeriod = (netValuePeriod == null) ? 0: netValuePeriod.getTime();
		this.grossOrgValue = entity.getGrossOrgValue();
		this.grossNetValue = entity.getGrossNetValue();
		this.versionTag = entity.getVersionTag();
		this.newnessCoefficient = entity.getNewnessCoefficient();
	}
		
	
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
