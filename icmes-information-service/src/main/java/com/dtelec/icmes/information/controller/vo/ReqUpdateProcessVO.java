package com.dtelec.icmes.information.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 新建工艺模型
 *
 */
@ApiModel
public class ReqUpdateProcessVO {
    
	@ApiModelProperty(value = "工艺名称")
	/**工艺名称*/
	public String name;
	@ApiModelProperty(value = "用于高并发的数据版本控制")
	/**用于高并发的数据版本控制*/
	public String versionTag;
	
}
