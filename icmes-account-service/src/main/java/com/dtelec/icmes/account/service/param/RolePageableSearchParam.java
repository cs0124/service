package com.dtelec.icmes.account.service.param;
/**
 * 角色分页查询参数
 * @author zturnking
 *
 */
public class RolePageableSearchParam extends PageableSearchBaseParam {

	/**
	 * 角色Id
	 */
	private String id;
	/**
	 * 角色名称
	 */
	private String name;	
	
	public RolePageableSearchParam(String id, String name, int page, int count) {
		super(page, count);
		
		this.id = id;
		this.name = name;
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
	
	
}
