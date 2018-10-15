package com.dtelec.icmes.account.repository.param;

/**
 * 角色分页查询参数
 * @author zturnking
 *
 */
public class RolePageableQueryParam extends PageableQueryBaseParam {
	/**
	 * 角色id
	 */
	public String id;
	/**
	 * 角色名称
	 */
	public String name;
	
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
	
}
