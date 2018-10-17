package com.dtelec.icmes.information.repository.entity;

import java.util.Date;

/**
 * 设备净值Entity
 * 作者：孔轩
 */
public class DeviceValueEntity {

    /**
     * 设备净值序号
     */
    private int id;

    /**
     * 净值周期
     */
    private Date netValuePeriod;

    /**
     * 设备总原值（单位：元）
     */
    private Double grossOrgValue;

    /**
     * 设备总净值（单位：元）
     */
    private Double grossNetValue;

    /**
	 * 新度系数
	 */
	private Double newnessCoefficient;

     /**
     * 用于高并发的数据版本控制
     */
    private String versionTag;

    /**
     * 设备净值信息创建时间
     */
    private Date createTime;

    /**
     * 创建的账户标识
     */
    private int createUserId;
    
    /**
     * 设备净值信息更新时间
     */
    private Date updateTime;

    /**
     * 更新的账户标识
     */
    private int updateUserId;

    public int getId() {
        return id;
    }
  
    public void setId(int id) {
        this.id = id;
    }

    public Date getNetValuePeriod() {
		return netValuePeriod;
	}

	public void setNetValuePeriod(Date netValuePeriod) {
		this.netValuePeriod = netValuePeriod;
	}

	public Double getGrossOrgValue() {
        return grossOrgValue;
    }
  
    public void setGrossOrgValue(Double grossOrgValue) {
        this.grossOrgValue = grossOrgValue;
    }

    public Double getGrossNetValue() {
        return grossNetValue;
    }
  
    public void setGrossNetValue(Double grossNetValue) {
        this.grossNetValue = grossNetValue;
    }

    public String getVersionTag() {
        return versionTag;
      }
    
      public void setVersionTag(String versionTag) {
        this.versionTag = versionTag;
      }
      public Date getCreateTime() {
        return createTime;
      }
    
      public void setCreateTime(Date createTime) {
        this.createTime = createTime;
      }
    
      public Date getUpdateTime() {
        return updateTime;
      }
    
      public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
      }

      public int getCreateUserId() {
        return createUserId;
      }

      public void setCreateUserId(int createUserId) {
          this.createUserId = createUserId;
      }

      public int getUpdateUserId() {
        return updateUserId;
      }

      public void setUpdateUserId(int updateUserId) {
          this.updateUserId = updateUserId;
      }

      public Double getNewnessCoefficient() {
          return newnessCoefficient;
      }

      public void setNewnessCoefficient(Double newnessCoefficient) {
          this.newnessCoefficient = newnessCoefficient;
      }
 

}