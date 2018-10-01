package com.dtelec.icmes.information.service.query;

public class PageableSearchBaseQuery {
    
	private String orderBy;
	private boolean ascending;
	private int page;
	private int count;
	
	
	public PageableSearchBaseQuery(int page, int count) {
		this.ascending = false;
		this.page = (page < 1) ? 1 : page;
		this.count = (count < 0) ? 0 : count;
	}


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


	public int getPage() {
		return page;
	}


	public void setPage(int page) {
		this.page = page;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}
	
}
