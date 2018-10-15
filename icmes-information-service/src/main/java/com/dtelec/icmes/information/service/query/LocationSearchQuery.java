package com.dtelec.icmes.information.service.query;

import com.dtelec.icmes.information.service.model.LocationCollection;

/**
 * 位置信息查询
 * 作者：孔轩
 */
public class LocationSearchQuery extends PageableSearchBaseQuery implements IQuery<LocationCollection> {

    private int id;
    private String code;
    private String name;
    private int parentId;
    private String parentCode;
    private String hierarchy;
	private int pageNo;
	private int pageSize;
	private String orderBy;
	private Boolean ascending;

    /**
     * 构造函数
     * @param page 页数
     * @param count 数量
     */
    public LocationSearchQuery(int page, int count) {
        super(page, count);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
		this.code = code;
    }
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
    }
    
    public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
    }
    
     public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
    }
    
    public String getHierarchy() {
		return hierarchy;
	}

	public void setHierarchy(String hierarchy) {
		this.hierarchy = hierarchy;
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