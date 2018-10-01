package com.dtelec.icmes.information.service.model;

import java.util.ArrayList;
import java.util.List;

public class OrganizationAccountCollection {
	/**
	 * 模型集合
	 */
	private List<OrganizationAccountModel> items;
	/**
	 * 模型初始化
	 */
	public OrganizationAccountCollection() {
		this.items = new ArrayList<>();
	}
	
	public void addItem(OrganizationAccountModel model) {
		if (model != null) {
			this.items.add(model);
		}
	}
	
	
	public List<OrganizationAccountModel> getList() {
		return this.items;
	}
}
