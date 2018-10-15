package com.dtelec.icmes.information.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 规格数据VO
 * @author schi
 *
 */
@ApiModel
public class ResSpecDataVO {

	@ApiModelProperty(value = "规格标识符")
	/**规格标识符*/
	public int id;
	@ApiModelProperty(value = "规格名称")
	/**规格名称*/
	public String name;
	@ApiModelProperty(value = "规格单位")
	/**规格单位*/
	public String unit;
	@ApiModelProperty(value = "规格模版数据呈现方式 false - 标签属性，true - 输入框属性")
	/**规格模版数据呈现方式 0 - 标签属性，1 - 输入框属性*/
	public boolean isExtraDisplayMode;    
}
