package com.dtelec.icmes.information.repository.param;

public class PageableSearchBaseParam {

	private String orderBy;
	private boolean ascending;
	private int startIndex;
	private int pageSize;
	
	public String getOrderBy() {
		return orderBy;
	}
	
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
	public boolean isAscending() {
		return ascending;
	}
	
	public void setAscending(boolean ascending) {
		this.ascending = ascending;
	}
	
	public int getStartIndex() {
		return startIndex;
	}
	
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}
