package com.dtelec.icmes.information.service.command;

import com.dtelec.icmes.information.service.model.DictTypeModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class DictTypeDeleteCommand implements ICommand<DictTypeModel>{
	@ApiModelProperty(value = "字典类型code")
	private String code;
	
	public DictTypeDeleteCommand (){
		
	}
	
	
	/**
	 * model to command
	 * @param model
	 */
	public void fill(DictTypeModel model) {
		this.code = model.getCode();
		
	}

	public DictTypeDeleteCommand(String code) {
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
