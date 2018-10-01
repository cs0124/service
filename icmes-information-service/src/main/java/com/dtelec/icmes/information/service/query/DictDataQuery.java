package com.dtelec.icmes.information.service.query;

import com.dtelec.icmes.information.service.model.DictDataBaseModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class DictDataQuery implements IQuery<DictDataBaseModel>{
	@ApiModelProperty(value = "字典编码")
	private String code;
	
	
	public DictDataQuery (){
		
	}
	

	public DictDataQuery(String code) {
		super();
		this.code = code;
	}

	
	public String getCode() {
		return code;
	}
	

	public void setCode(String code) {
		this.code = code;
	}

	

}
