package com.dtelec.icmes.account.service.model;

import com.dtelec.icmes.account.repository.param.AccountOrgPageableReturnParam;

/**
 * 账户组织模型
 * @author zturnking
 *
 */
public class AccountOrgModel {
	/**
	 * id
	 */
	private String id;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 全称
	 */
	private String fullOrgName;
	
	
	/**
	 * 填充模型
	 * @param entity
	 */
	public void fill(AccountOrgPageableReturnParam entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.fullOrgName = entity.getFullOrgName();
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



	public String getFullOrgName() {
		return fullOrgName;
	}



	public void setFullOrgName(String fullOrgName) {
		this.fullOrgName = fullOrgName;
	}
}
