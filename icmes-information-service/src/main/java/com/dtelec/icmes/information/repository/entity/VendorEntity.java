package com.dtelec.icmes.information.repository.entity;

import java.util.Date;


public class VendorEntity {
	/**
	 * 标识符
	 */
	private Integer id;
	/**
	 * 厂商编号
	 */
	private String code;
	/**
	 * 厂商名称
	 */
	private String name;
	/**
	 * 厂商地址
	 */
	private String address;
	/**
	 * 厂商联系人姓名1
	 */
	private String contactName1;
	/**
	 * 厂商联系人电话1
	 */
	private String contactPhone1;
	/**
	 * 厂商联系人姓名2
	 */
	private String contactName2;
	/**
	 * 厂商联系人电话2
	 */
	private String contactPhone2;
	/**
	 * 厂商联系人姓名3
	 */
	private String contactName3;
	/**
	 * 厂商联系人电话3
	 */
	private String contactPhone3;
	/**
	 * 用于高并发的数据版本控制
	 */
	private String versionTag;
	/**
	 * 厂商创建时间
	 */
	private Date createTime;
	/**
	 * 厂商创建者编号
	 */
	private Integer createUserId;
	/**
	 * 厂商更新时间
	 */
	private Date updateTime;
	/**
	 * 厂商更新者编号
	 */
	private Integer updateUserId;
	
	public Integer getId() {
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
	
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getCreateUserId() {
		return createUserId;
	}
	
	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}
	
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public int getUpdateUserId() {
		return updateUserId;
	}
	
	public void setUpdateUserId(Integer updateUserId) {
		this.updateUserId = updateUserId;
	}
}
