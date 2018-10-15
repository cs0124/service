package com.dtelec.icmes.account.service.model;

import com.dtelec.icmes.account.repository.entity.FeatureEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 权限模型
 * @author zturnking
 *
 */
@ApiModel
public class FeatureModel {
	@ApiModelProperty(value = "功能唯一标识符")
	private int id;
	@ApiModelProperty(value = "功能编码")
	private String code;
	@ApiModelProperty(value = "功能所属的菜单项")
	private int menuId;
	@ApiModelProperty(value = "功能名称")
	private String name;
	@ApiModelProperty(value = "功能的描述")
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
	
	/**
	 * 给FeatureModel赋值
	 * @param entity
	 */
	public void fill(FeatureEntity entity) {
		this.id = entity.getId();
		this.code = entity.getCode();
		this.menuId = entity.getMenuId();
		this.name = entity.getName();
		this.remark = entity.getRemark();
		
	}
	
}
