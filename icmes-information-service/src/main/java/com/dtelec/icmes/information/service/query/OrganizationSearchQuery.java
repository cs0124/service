package com.dtelec.icmes.information.service.query;

import com.dtelec.icmes.information.service.model.OrganizationsCollection;

public class OrganizationSearchQuery extends PageableSearchBaseQuery implements IQuery<OrganizationsCollection> {

	private String id;
	private String name;
	private String parentId;
	private String hierarchy;
	private int pageNo;
	private int pageSize;
	private String orderBy;
	private Boolean ascending;

	public OrganizationSearchQuery(int page, int count) {
		super(page, count);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
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
