package com.dtelec.icmes.information.controller.vo;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 规格类型VO
 * @author schi
 *
 */
@ApiModel
public class ResSpecTypeVO {

	@ApiModelProperty(value="规格类型标识符")
	/**规格类型标识符*/
	public int id;
	@ApiModelProperty(value="规格类型名称")
	/**规格类型名称*/
	public String name;
	@ApiModelProperty(value="规格数据集合")
	/**规格数据集合*/
	public List<ResSpecDataVO> specDataList;
	
}
