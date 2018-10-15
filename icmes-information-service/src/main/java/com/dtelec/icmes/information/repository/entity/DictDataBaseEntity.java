package com.dtelec.icmes.information.repository.entity;

import java.util.Date;

/**
 * 系统字典基础entity
 * @author dell
 *
 */
public class DictDataBaseEntity {

	private String code;

	private String typeCode;

	private String name;

	private Integer order;	

	private String versionTag;

	private Date lastUpdateTime;

	private Integer lastUpdateUserId;
	
	private Date createTime;	

	private Integer createUserId;	

	private boolean disabled;
	
	
	public String getVersionTag() {
		return versionTag;
	}
	
	
	public void setVersionTag(String versionTag) {
		this.versionTag = versionTag;
	}
	
	
	public Date getCreateTime() {
		return createTime;
	}
	
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
	public Integer getCreateUserId() {
		return createUserId;
	}
	
	
	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}
	
	
	public boolean getDisabled() {
		return disabled;
	}
	
	
	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}
	
	
	public String getCode() {
		return code;
	}
	
	
	public void setCode(String code) {
		this.code = code;
	}
	
	
	public String getTypeCode() {
		return typeCode;
	}
	
	
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	
	
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public Integer getOrder() {
		return order;
	}
	
	
	public void setOrder(Integer order) {
		this.order = order;
	}
	
	
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	
	
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	
	
	public Integer getLastUpdateUserId() {
		return lastUpdateUserId;
	}
	
	
	public void setLastUpdateUserId(Integer lastUpdateUserId) {
		this.lastUpdateUserId = lastUpdateUserId;
	}
	
	
	

}
