package com.dtelec.icmes.information.service.query;

import com.dtelec.icmes.information.service.model.DeviceCategoryCollection;

public class DeviceCategorySearchQuery extends PageableSearchBaseQuery implements IQuery<DeviceCategoryCollection> {

	/**全局搜索*/
	private String globalName;
	/**设备类型是否是主设备大类  true - 是主设备大类  false - 是附属设备大类*/
	private Boolean isPrimary;
	
	public DeviceCategorySearchQuery(int page, int count) {
		super(page, count);
	}

	public String getGlobalName() {
		return globalName;
	}

	public void setGlobalName(String globalName) {
		this.globalName = globalName;
	}

	public Boolean getIsPrimary() {
		return isPrimary;
	}

	public void setIsPrimary(Boolean isPrimary) {
		this.isPrimary = isPrimary;
	}

	
}

