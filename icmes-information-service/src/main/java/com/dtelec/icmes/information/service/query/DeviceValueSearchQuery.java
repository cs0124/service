package com.dtelec.icmes.information.service.query;

import java.util.Date;

import com.dtelec.icmes.information.service.model.DeviceValueCollection;

/**
 * 设备净值信息查询
 * 作者：孔轩
 */
public class DeviceValueSearchQuery extends PageableSearchBaseQuery implements IQuery<DeviceValueCollection> {

    private int id;
    private Date netValuePeriod;
	private Double grossOrgValue;
    private Double grossNetValue;
    private Double newnessCoefficient;
	private int pageNo;
	private int pageSize;
	private String orderBy;
	private Boolean ascending;

    /**
     * 构造函数
     * @param page 页数
     * @param count 数量
     */
    public DeviceValueSearchQuery(int page, int count) {
        super(page, count);
    }

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
    
	@Override
	public String getOrderBy() {
		return orderBy;
	}
	@Override
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public Boolean getAscending() {
		return ascending;
	}

	public void setAscending(Boolean ascending) {
		this.ascending = ascending;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}