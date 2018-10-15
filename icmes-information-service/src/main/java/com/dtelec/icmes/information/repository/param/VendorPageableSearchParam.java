package com.dtelec.icmes.information.repository.param;
/**
 * 厂商查询类
 * @author dell
 *
 */
public class VendorPageableSearchParam extends PageableSearchBaseParam {
	
	private String globalName;
	private String code;
	private String name;
	
	public String getGlobalName() {
		return globalName;
	}

	public void setGlobalName(String globalName) {
		this.globalName = globalName;
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
}
