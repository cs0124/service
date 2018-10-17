package com.dtelec.icmes.information.repository.param;

import java.util.List;

/**
 * 设备分页查询参数实体
 * 
 * @author 张瑞晗
 *
 */
public class DevicePageableSearchParam extends PageableSearchBaseParam {
	/**
	 * 父设备id
	 */
	private int parentId;
	/**
	 * 迭代层级
	 */
	private int hierarchy;
	/**
	 * 全局模糊查询参数
	 */
	private String globalName;
	private Boolean isPrimary;
	/**
	 * 设备类型列表
	 */
	private List<Integer> categoryList;
	/**
	 * 位置列表
	 */
	private List<Integer> locationList;
	/**
	 * 状态列表
	 */
	private List<String> statusList;

	public DevicePageableSearchParam(Boolean isPrimary, int parentId, int hierarchy, String globalName,
			List<Integer> categoryList, List<Integer> locationList, List<String> statusList) {
		super();
		this.parentId = parentId;
		this.hierarchy = hierarchy;
		this.globalName = globalName;
		if (categoryList != null && categoryList.size() > 0) {
			this.categoryList = categoryList;
		}
		if (locationList !=null && locationList.size() > 0) {
			this.locationList = locationList;
		}
		if (statusList !=null && statusList.size() > 0) {
			this.statusList = statusList;
		}
		this.isPrimary = isPrimary;
	}

	public String getGlobalName() {
		return globalName;
	}

	public void setGlobalName(String globalName) {
		this.globalName = globalName;
	}

	public List<Integer> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Integer> categoryList) {
		this.categoryList = categoryList;
	}

	public List<Integer> getLocationList() {
		return locationList;
	}

	public void setLocationList(List<Integer> locationList) {
		this.locationList = locationList;
	}

	public List<String> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<String> statusList) {
		this.statusList = statusList;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getHierarchy() {
		return hierarchy;
	}

	public void setHierarchy(int hierarchy) {
		this.hierarchy = hierarchy;
	}

	public Boolean getIsPrimary() {
		return isPrimary;
	}

	public void setIsPrimary(Boolean isPrimary) {
		this.isPrimary = isPrimary;
	}
}
