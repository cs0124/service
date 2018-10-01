package com.dtelec.icmes.information.repository.param;

/**
 * 字典类型查询条件类
 * @author dell
 *
 */
public class DictDetailPageableSearchParam extends PageableSearchBaseParam {
	
	private String code;
	private String name;
	
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
