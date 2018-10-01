package com.dtelec.icmes.information.service.command;

import com.dtelec.icmes.information.service.model.DictDataBaseModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class DictDataDeleteCommand implements ICommand<DictDataBaseModel>{
	@ApiModelProperty(value = "字典编码")
	private String code;
	
	public DictDataDeleteCommand (){
		
	}
	
	public void fill(DictDataBaseModel model) {
		this.code = model.getCode();
		
	}

	public DictDataDeleteCommand(String code) {
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
