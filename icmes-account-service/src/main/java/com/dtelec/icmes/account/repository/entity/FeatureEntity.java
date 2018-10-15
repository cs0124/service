package com.dtelec.icmes.account.repository.entity;
/**
 * 权限实体类
 * @author zturnking
 *
 */
public class FeatureEntity {
	/**
	 * 权限id
	 */
	private int id;
	/**
	 * 权限编码
	 */
	private String code;
	/**
	 * 菜单id
	 */
	private int menuId;
	/**
	 * 名字
	 */
	private String name;
	/**
	 * 描述
	 */
	private String remark;
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public int getMenuId() {
		return menuId;
	}
	
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getRemark() {
		return remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
