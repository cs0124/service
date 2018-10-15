package com.dtelec.icmes.information.repository.entity;

import java.util.Date;

/**
 * 设备基础实体entity
 * 
 * @author RHZhang 张瑞晗
 *
 */
public class DeviceBaseEntity {
	/**
	 * 标识符
	 */
	private int id;
	/**
	 * 父设备标识符
	 */
	private int parentId;
	/**
	 * 设备类型
	 */
	private boolean isPrimary;
	/**
	 * 设备工艺号
	 */
	private String processNo;
	/**
	 * 设备编号
	 */
	private String code;
	/**
	 * 设备名称
	 */
	private String name;
	/**
	 * 位置标识符
	 */
	private int locationId;
	/**
	 * 机构编码
	 */
	private String organizationId;
	/**
	 * 工艺系统标识符
	 */
	private int processId;
	/**
	 * 型号
	 */
	private String model;
	/**
	 * 设备类型标识符
	 */
	private int deviceCategoryId;
	/**
	 * 采购商用厂商标识符
	 */
	private int vendorId;
	/**
	 * 购买日期
	 */
	private Date purchaseDate;
	/**
	 * 购买价格
	 */
	private double purchasePrice;
	/**
	 * 制造商用厂商标识符
	 */
	private int manufacturerId;
	/**
	 * 出场时间
	 */
	private Date manufacturingDate;
	/**
	 * 制造产地
	 */
	private String manufacturingPlace;
	/**
	 * 安装时间
	 */
	private Date setupDate;
	/**
	 * 设备状态
	 */
	private String status;
	/**
	 * 备注
	 */
	private String memo;
	/**
	 * 用于高并发的数据版本控制
	 */
	private String versionTag;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 创建的账户标识
	 */
	private int createUserId;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	/**
	 * 更新的账号标识
	 */
	private int updateUserId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public boolean getIsPrimary() {
		return isPrimary;
	}

	public void setIsPrimary(boolean isPrimary) {
		this.isPrimary = isPrimary;
	}

	public String getProcessNo() {
		return processNo;
	}

	public void setProcessNo(String processNo) {
		this.processNo = processNo;
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

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	public int getProcessId() {
		return processId;
	}

	public void setProcessId(int processId) {
		this.processId = processId;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getDeviceCategoryId() {
		return deviceCategoryId;
	}

	public void setDeviceCategoryId(int deviceCategoryId) {
		this.deviceCategoryId = deviceCategoryId;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public int getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(int manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	public Date getManufacturingDate() {
		return manufacturingDate;
	}

	public void setManufacturingDate(Date manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}

	public String getManufacturingPlace() {
		return manufacturingPlace;
	}

	public void setManufacturingPlace(String manufacturingPlace) {
		this.manufacturingPlace = manufacturingPlace;
	}

	public Date getSetupDate() {
		return setupDate;
	}

	public void setSetupDate(Date setupDate) {
		this.setupDate = setupDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
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

	public void setCreateUserId(int createUserId) {
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

	public void setUpdateUserId(int updateUserId) {
		this.updateUserId = updateUserId;
	}

}
