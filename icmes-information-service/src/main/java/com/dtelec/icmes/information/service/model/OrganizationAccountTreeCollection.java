package com.dtelec.icmes.information.service.model;

import java.util.ArrayList;
import java.util.List;

public class OrganizationAccountTreeCollection {
	/**
	 * 模型集合
	 */
	private List<OrganizationAccountTreeModel> items;
	/**
	 * 模型初始化
	 */
	public OrganizationAccountTreeCollection() {
		this.items = new ArrayList<>();
	}
	
	public void addItem(OrganizationAccountTreeModel model) {
		if (model != null) {
			this.items.add(model);
		}
	}
	
	
	public List<OrganizationAccountTreeModel> getList() {
		return this.items;
	}
}
