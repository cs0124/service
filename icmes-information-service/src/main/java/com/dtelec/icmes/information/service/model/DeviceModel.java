package com.dtelec.icmes.information.service.model;

import java.util.List;

import com.dtelec.icmes.information.repository.param.DevicePageableSearchResultParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 设备模型
 * 
 * @author RHZhang 张瑞晗
 *
 */
@ApiModel
public class DeviceModel {
	/**
	 * 设备id
	 */
	@ApiModelProperty(value = "设备id")
	private int id;
	/**
	 * 设备类型
	 */
	@ApiModelProperty(value = "设备类型")
	private boolean isPrimary;
	/**
	 * 设备工艺号
	 */
	@ApiModelProperty(value = "设备工艺号")
	private String processNo;
	/**
	 * 设备编号
	 */
	@ApiModelProperty(value = "设备编号")
	private String code;
	/**
	 * 设备名称
	 */
	@ApiModelProperty(value = "设备名称")
	private String name;
	/**
	 * 型号
	 */
	@ApiModelProperty(value = "型号")
	private String model;
	/**
	 * 购买日期
	 */
	@ApiModelProperty(value = "购买日期")
	private long purchaseDate;
	/**
	 * 购买价格
	 */
	@ApiModelProperty(value = "购买价格")
	private double purchasePrice;
	/**
	 * 出厂时间
	 */
	@ApiModelProperty(value = "出厂时间")
	private long manufacturingDate;
	/**
	 * 制造产地
	 */
	@ApiModelProperty(value = "制造产地")
	private String manufacturingPlace;
	/**
	 * 安装日期
	 */
	@ApiModelProperty(value = "安装日期")
	private long setupDate;
	/**
	 * 备注
	 */
	@ApiModelProperty(value = "备注")
	private String memo;
	/**
	 * 设备状态
	 */
	@ApiModelProperty(value = "设备状态")
	private String status;
	/**
	 * 照片列表
	 */
	@ApiModelProperty(value = "照片列表")
	private List<DevicePhotoModel> photoList;
	/**
	 * 规格列表
	 */
	@ApiModelProperty(value = "规格列表")
	private List<DeviceSpecDataModel> specDataList;
	/**
	 * 规格全称（平铺）
	 */
	@ApiModelProperty(value = "规格全称（平铺）")
	private String specDataFullName;
	/**
	 * 位置id
	 */
	@ApiModelProperty(value = "位置id")
	private int locationId;
	/**
	 * 位置编码
	 */
	@ApiModelProperty(value = "位置编码")
	private String locationCode;
	/**
	 * 当前位置名称
	 */
	@ApiModelProperty(value = "当前位置名称")
	private String locationName;
	/**
	 * 位置全名
	 */
	@ApiModelProperty(value = "位置全名")
	private String locationFullName;
	/**
	 * 组织id
	 */
	@ApiModelProperty(value = "组织id")
	private String organizationId;
	/**
	 * 组织全名
	 */
	@ApiModelProperty(value = "组织全名")
	private String organizationFullName;
	/**
	 * 设备工艺id
	 */
	@ApiModelProperty(value = "设备工艺id")
	private int processId;
	/**
	 * 设备工艺名称
	 */
	@ApiModelProperty(value = "设备工艺名称")
	private String processName;
	/**
	 * 设备标识符
	 */
	@ApiModelProperty(value = "设备标识符")
	private int categoryId;
	/**
	 * 设备编码
	 */
	@ApiModelProperty(value = "设备编码")
	private String categoryCode;
	/**
	 * 设备类型名称
	 */
	@ApiModelProperty(value = "设备类型名称")
	private String categoryName;
	/**
	 * 供应商id
	 */
	@ApiModelProperty(value = "供应商id")
	private int vendorId;
	/**
	 * 供应商名称
	 */
	@ApiModelProperty(value = "供应商名称")
	private String vendorName;
	/**
	 * 制造商id
	 */
	@ApiModelProperty(value = "制造商id")
	private int manufacturerId;
	/**
	 * 制造商名称
	 */
	@ApiModelProperty(value = "制造商名称")
	private String manufacturerName;
	/**
	 * 版本控制
	 */
	@ApiModelProperty(value = "版本控制")
	private String versionTag;
	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间")
	private long createTime;
	/**
	 * 更新时间
	 */
	@ApiModelProperty(value = "更新时间")
	private long updateTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isPrimary() {
		return isPrimary;
	}

	public void setPrimary(boolean isPrimary) {
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

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public long getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(long purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public long getManufacturingDate() {
		return manufacturingDate;
	}

	public void setManufacturingDate(long manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}

	public String getManufacturingPlace() {
		return manufacturingPlace;
	}

	public void setManufacturingPlace(String manufacturingPlace) {
		this.manufacturingPlace = manufacturingPlace;
	}

	public long getSetupDate() {
		return setupDate;
	}

	public void setSetupDate(long setupDate) {
		this.setupDate = setupDate;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<DevicePhotoModel> getPhotoList() {
		return photoList;
	}

	public void setPhotoList(List<DevicePhotoModel> photoList) {
		this.photoList = photoList;
	}

	public List<DeviceSpecDataModel> getSpecDataList() {
		return specDataList;
	}

	public void setSpecDataList(List<DeviceSpecDataModel> specDataList) {
		this.specDataList = specDataList;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getLocationFullName() {
		return locationFullName;
	}

	public void setLocationFullName(String locationFullName) {
		this.locationFullName = locationFullName;
	}

	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	public String getOrganizationFullName() {
		return organizationFullName;
	}

	public void setOrganizationFullName(String organizationFullName) {
		this.organizationFullName = organizationFullName;
	}

	public int getProcessId() {
		return processId;
	}

	public void setProcessId(int processId) {
		this.processId = processId;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public int getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(int manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
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

	/**
	 * 填充模型
	 * 
	 * @param entity
	 */
	public void fill(DevicePageableSearchResultParam entity) {
		this.id = entity.getId();
		this.processNo = entity.getProcessNo();
		this.code = entity.getCode();
		this.name = entity.getName();
		this.categoryId = entity.getDeviceCategoryId();
		this.categoryCode = entity.getDeviceCategoryCode();
		this.categoryName = entity.getDeviceCategoryName();
		this.model = entity.getModel();
		this.locationId = entity.getLocationId();
		this.locationName = entity.getLocationName();
		this.locationCode = entity.getLocationCode();
		this.status = entity.getStatus();
		if(entity.getCreateTime()!=null) {
			this.createTime = entity.getCreateTime().getTime();
		}
		this.isPrimary = entity.getIsPrimary();
		this.locationId = entity.getLocationId();
		this.manufacturerId = entity.getManufacturerId();
		
	}

	public String getSpecDataFullName() {
		return specDataFullName;
	}

	public void setSpecDataFullName(String specDataFullName) {
		this.specDataFullName = specDataFullName;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

}
