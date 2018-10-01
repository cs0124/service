package com.dtelec.icmes.information.service.query;

import com.dtelec.icmes.information.service.model.DictDataCollection;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class DictDataDetailQuery extends PageableSearchBaseQuery implements IQuery<DictDataCollection>{
	@ApiModelProperty(value = "字典编码")
	private String code;	


	public DictDataDetailQuery(String code, int page, int count) {
		super(page, count);
		this.code = code;
		
	}	
	

	public String getCode() {
		return code;
	}
	
	
	public void setCode(String code) {
		this.code = code;
	}	



}
