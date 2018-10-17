package com.dtelec.icmes.information.repository.entity;

import java.util.Date;


/**
 * 系统字典 类型entity
 * @author dell
 *
 */
public class DictTypeEntity {

	private String code;

	private String name;
	
	private String isBuiltIn;
	
	private String versionTag;
	
	private Date createTime;
	
	private Integer createUserId;
	
	private Date LastUpdateTime;
	
	private Integer LastUpdateUserId;
	
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getIsBuiltIn() {
		return isBuiltIn;
	}
	
	public void setIsBuiltIn(String isBuiltIn) {
		this.isBuiltIn = isBuiltIn;
	}
	
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
	
	public Date getLastUpdateTime() {
		return LastUpdateTime;
	}
	
	public void setLastUpdateTime(Date lastUpdateTime) {
		LastUpdateTime = lastUpdateTime;
	}
	
	public Integer getLastUpdateUserId() {
		return LastUpdateUserId;
	}
	
	public void setLastUpdateUserId(Integer lastUpdateUserId) {
		LastUpdateUserId = lastUpdateUserId;
	}

}
