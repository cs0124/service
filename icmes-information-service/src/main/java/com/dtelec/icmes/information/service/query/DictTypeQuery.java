package com.dtelec.icmes.information.service.query;

import com.dtelec.icmes.information.service.model.DictTypeModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class DictTypeQuery implements IQuery<DictTypeModel>{
	@ApiModelProperty(value = "字典类型code")	
	private String code;
	
	public DictTypeQuery (){
		
	}

	public DictTypeQuery(String code) {
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
