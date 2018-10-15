package com.dtelec.icmes.information.service.query;

import java.util.ArrayList;
import java.util.List;

import com.dtelec.icmes.information.service.model.DeviceCollection;

public class DeviceSearchQuery extends PageableSearchBaseQuery implements IQuery<DeviceCollection> {
	public DeviceSearchQuery(int page, int count) {
		super(page, count);
		this.categoryList = new ArrayList<>();
		this.locationList = new ArrayList<>();
		this.statusList = new ArrayList<>();
	}

	private List<Integer> categoryList;
	private List<Integer> locationList;
	private List<String> statusList;

	private String parentId;
	private String globalName;

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
