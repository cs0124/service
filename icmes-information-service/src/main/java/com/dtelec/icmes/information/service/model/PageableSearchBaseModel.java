package com.dtelec.icmes.information.service.model;

import java.util.ArrayList;
import java.util.List;

public class PageableSearchBaseModel<T> {

	private long totalCount;
	private long totalPages;
	private List<T> items;
	
	
	public long getTotalCount() {
		return totalCount;
	}
	
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	
	public long getTotalPages() {
		return totalPages;
	}
	
	public void setTotalPages(long totalPages) {
		this.totalPages = totalPages;
	}
	
	public List<T> getItems() {
		return items;
	}
	
	public void setItems(List<T> items) {
		this.items = items;
	}
	
	public void addItem(T item) {
		if (item == null) return;
		
		if (this.items == null)
			this.items = new ArrayList<>();
		
		this.items.add(item);
	}
	
}
