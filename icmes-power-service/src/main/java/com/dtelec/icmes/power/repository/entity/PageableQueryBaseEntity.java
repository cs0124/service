package com.dtelec.icmes.power.repository.entity;

import java.util.ArrayList;
import java.util.List;
/**
 * 分页查询实体基类
 * @author hlxu
 *
 * @param <T>
 */
public class PageableQueryBaseEntity<T> {
	/**
	 * 总数
	 */
	private long totalCount;
	/**
	 * 实体列表
	 */
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
