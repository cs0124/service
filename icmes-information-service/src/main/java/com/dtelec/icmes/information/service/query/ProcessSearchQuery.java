package com.dtelec.icmes.information.service.query;

import com.dtelec.icmes.information.service.model.ProcessCollection;

/**
 * 工艺查询参数
 *
 */
public class ProcessSearchQuery extends PageableSearchBaseQuery implements IQuery<ProcessCollection> {

	/**工艺编号*/
	private String code; 
	/**工艺姓名*/
	private String name; 
	/**全局搜索*/
	private String globalName;
	
	public ProcessSearchQuery(int page, int count) {
		super(page, count);
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

	public String getGlobalName() {
		return globalName;
	}

	public void setGlobalName(String globalName) {
		this.globalName = globalName;
	}
	
	

}
