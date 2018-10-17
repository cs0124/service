package com.dtelec.icmes.information.repository.param;

import java.util.Date;

/**
 * 获取设备净值分页查询参数
 */
public class DeviceValueDetailPageableSearchParam extends PageableSearchBaseParam {

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

    public Double getNewnessCoefficient() {
        return newnessCoefficient;
    }

    public void setNewnessCoefficient(Double newnessCoefficient) {
        this.newnessCoefficient = newnessCoefficient;
    }

    public String getVersionTag() {
        return versionTag;
    }
    
    public void setVersionTag(String versionTag) {
        this.versionTag = versionTag;
    }
    
}