package com.dtelec.icmes.information.service.model;

import java.util.Date;

import com.dtelec.icmes.information.repository.entity.VendorEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class VendorModel {

	@ApiModelProperty(value = "标识符" )
	private Integer id;
	@ApiModelProperty(value = "供应商编号" )
	private String code;
	@ApiModelProperty(value = "供应商名称" )
	private String name;
	@ApiModelProperty(value = "供应商地址" )
	private String address;
	@ApiModelProperty(value = "联系人姓名1" )
	private String contactName1;
	@ApiModelProperty(value = "联系人电话1" )
	private String contactPhone1;
	@ApiModelProperty(value = "联系人姓名2" )
	private String contactName2;
	@ApiModelProperty(value = "联系人电话2" )
	private String contactPhone2;
	@ApiModelProperty(value = "联系人姓名3" )
	private String contactName3;
	@ApiModelProperty(value = "联系人电话3" )
	private String contactPhone3;
	@ApiModelProperty(value = "用于高并发的数据版本控制" )
	private String versionTag;
	@ApiModelProperty(value = "创建时间" )
	private long createTime;
	@ApiModelProperty(value = "更新时间" )
	private long updateTime;
	private int createUserId;
	private int updateUserId;

	public int getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
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
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getContactName1() {
		return contactName1;
	}
	
	public void setContactName1(String contactName1) {
		this.contactName1 = contactName1;
	}
	
	public String getContactPhone1() {
		return contactPhone1;
	}
	
	public void setContactPhone1(String contactPhone1) {
		this.contactPhone1 = contactPhone1;
	}
	
	public String getContactName2() {
		return contactName2;
	}
	
	public void setContactName2(String contactName2) {
		this.contactName2 = contactName2;
	}
	
	public String getContactPhone2() {
		return contactPhone2;
	}
	
	public void setContactPhone2(String contactPhone2) {
		this.contactPhone2 = contactPhone2;
	}
	
	public String getContactName3() {
		return contactName3;
	}
	
	public void setContactName3(String contactName3) {
		this.contactName3 = contactName3;
	}
	
	public String getContactPhone3() {
		return contactPhone3;
	}
	
	public void setContactPhone3(String contactPhone3) {
		this.contactPhone3 = contactPhone3;
	}
	
	public String getVersionTag() {
		return versionTag;
	}
	
	public void setVersionTag(String versionTag) {
		this.versionTag = versionTag;
	}
	
	public long getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	
	public long getUpdateTime() {
		return updateTime;
	}
	
	public void setUpdateTime(long updateTime) {
		this.updateTime = updateTime;
	}
	
	public int getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(int createUserId) {
		this.createUserId = createUserId;
	}

	public int getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(int updateUserId) {
		this.updateUserId = updateUserId;
	}

	/**
	 * 给Model赋值
	 * @param entity
	 */
	public void fillModel(VendorEntity entity) {
		this.id = entity.getId();
		this.code = entity.getCode();
		this.name = entity.getName();
		this.address = entity.getAddress();
		this.contactName1 = entity.getContactName1();
		this.contactPhone1 = entity.getContactPhone1();
		this.contactName2 = entity.getContactName2();
		this.contactPhone2 = entity.getContactPhone2();
		this.contactName3 = entity.getContactName3();
		this.contactPhone3 = entity.getContactPhone3();
		this.versionTag = entity.getVersionTag();
		Date createTime = entity.getCreateTime();
		this.createTime = (createTime == null) ? 0 : createTime.getTime();
		this.createUserId = entity.getCreateUserId();
		Date updateTime = entity.getUpdateTime();
		this.updateTime = (updateTime == null) ? 0 : updateTime.getTime();
		this.updateUserId = entity.getUpdateUserId();
	}
	
	/**
	 * 给entity模型赋值
	 * @return
	 */
	public VendorEntity covert() {
		VendorEntity entity = new VendorEntity();
		entity.setId(this.id);
		entity.setCode(this.code);
		entity.setName(this.name);
		entity.setAddress(this.address);
		entity.setContactName1(this.contactName1);
		entity.setContactPhone1(this.contactPhone1);
		entity.setContactName2(this.contactName2);
		entity.setContactPhone2(this.contactPhone2);
		entity.setContactName3(this.contactName3);
		entity.setContactPhone3(this.contactPhone3);
		entity.setVersionTag(this.versionTag);

		return entity;	
	}
}
