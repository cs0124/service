package com.dtelec.icmes.information.repository.param;

/**
 * 设备类型查询参数
 *
 */
public class DeviceCategoryPageableSearchParam extends PageableSearchBaseParam{

	/**设备类型是否是主设备大类  true - 是主设备大类  false - 是附属设备大类*/
	private Boolean isPrimary;
	/**全局搜索*/
	private String globalName;
	
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
