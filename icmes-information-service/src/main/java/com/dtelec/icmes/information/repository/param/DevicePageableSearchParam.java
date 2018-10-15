package com.dtelec.icmes.information.repository.param;

import java.util.List;
/**
 * 设备分页查询参数实体
 * @author 张瑞晗
 *
 */
public class DevicePageableSearchParam extends PageableSearchBaseParam {
	/**
	 * 父设备id
	 */
	private String parentId;
	/**
	 * 全局模糊查询参数
	 */
	private String globalName;
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

	


	public DevicePageableSearchParam(String parentId, String globalName, List<Integer> categoryList,
			List<Integer> locationList, List<String> statusList) {
		super();
		this.parentId = parentId;
		this.globalName = globalName;
		this.categoryList = categoryList;
		this.locationList = locationList;
		this.statusList = statusList;
	}
	
	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
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
}
