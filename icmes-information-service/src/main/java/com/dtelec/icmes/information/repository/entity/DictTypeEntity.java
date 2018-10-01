package com.dtelec.icmes.information.repository.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

/**
 * 系统字典 类型entity
 * @author dell
 *
 */
public class DictTypeEntity {

	@NotNull
	@Length( max = 30)
	private String code;

	@NotNull
	@Length( max = 200)
	private String name;
	
	@NotNull
	@Length( max = 1)
	private String isBuiltIn;
	
	@NotNull
	@Length( max = 36)
	private String versionTag;
	
	@NotNull
	private Date createTime;
	
	@NotNull
	@Length( max = 15)
	private Integer createUserId;
	
	@NotNull
	private Date LastUpdateTime;
	
	@NotNull
	@Length( max = 15)
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
