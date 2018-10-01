package com.dtelec.icmes.information.repository.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

/**
 * 系统字典基础entity
 * @author dell
 *
 */
public class DictDataBaseEntity {
	@NotNull
	@Length( max = 30)	
	private String code;
	@NotNull
	@Length( max = 30)
	private String typeCode;
	@NotNull
	@Length( max = 200)
	private String name;
	@NotNull
	@Length( max = 3)
	private Integer order;	
	@NotNull
	@Length( max = 36)
	private String versionTag;
	@NotNull	
	private Date lastUpdateTime;
	@NotNull
	@Length( max = 20)
	private Integer lastUpdateUserId;
	@NotNull	
	private Date createTime;	
	@NotNull
	@Length( max = 20)
	private Integer createUserId;	
	@NotNull
	@Length( max = 36)
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
