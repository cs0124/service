package com.dtelec.icmes.information.service.query;


import com.dtelec.icmes.information.service.model.DictTypeCollection;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class DictDetailQuery extends PageableSearchBaseQuery implements IQuery<DictTypeCollection>{
	@ApiModelProperty(value = "字典类型code")
	private String code;
	@ApiModelProperty(value = "字典类型名称")
	private String name;	
	

	public DictDetailQuery(String code, String name, int page, int count) {	
		super(page, count);
		this.code = code;
		this.name = name;
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
