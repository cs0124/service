package com.dtelec.icmes.information.repository.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 实体类基类
 *
 * @param <T> 泛型
 */
public class PageableSearchBaseEntity<T> {
	private long totalCount;
	private List<T> items;
	
	public long getTotalCount() {
		return totalCount;
	}
	
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	
	public List<T> getItems() {
		return items;
	}
	
	public void setItems(List<T> items) {
		this.items = items;
	}
	
	public void addItem(T item) {
		if (item == null) {return;}
		
		if (this.items == null) {
			this.items = new ArrayList<>();}
		
		this.items.add(item);
	}
}
