package com.dtelec.icmes.information.repository.param;

/**
 * 工艺查询参数
 *
 */
public class ProcessPageableSearchParam extends PageableSearchBaseParam{

	/**工艺编码*/
	private String code; 
	/**工艺名称*/
	private String name; 
	/**全局搜索*/
	private String globalName;
	
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
	public String getGlobalName() {
		return globalName;
	}
	public void setGlobalName(String globalName) {
		this.globalName = globalName;
	}
	
	
}
