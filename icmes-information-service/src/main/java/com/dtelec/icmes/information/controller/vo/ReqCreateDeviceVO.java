package com.dtelec.icmes.information.controller.vo;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 设备新建VO
 * @author schi
 *
 */
@ApiModel
public class ReqCreateDeviceVO {

	@ApiModelProperty(value="父设备标识符")
	/**父设备标识符*/
	public int parentId;
	@ApiModelProperty(value="设备类型是否是主设备大类 true - 是主设备大类  false - 是附属设备大类")
	/**设备类型是否是主设备大类 true - 是主设备大类  false - 是附属设备大类*/
	public boolean isPrimary;
	@ApiModelProperty(value="设备工艺号")
	/**设备工艺号*/
	public String processNo;
	@ApiModelProperty(value="设备编号")
	/**设备编号*/
	public String code;
	@ApiModelProperty(value="设备名称")
	/**设备名称*/
	public String name;
	@ApiModelProperty(value="型号")
	/**型号*/
	public String model;
	@ApiModelProperty(value="购买日期")
	/**购买日期*/
	public long purchaseDate;
	@ApiModelProperty(value="购买价格")
	/**购买价格*/
	public double purchasePrice;
	@ApiModelProperty(value="出厂时间")
	/**出厂时间*/
	public long manufacturingDate;
	@ApiModelProperty(value="制造产地")
	/**制造产地*/
	public String manufacturingPlace;
	@ApiModelProperty(value="安装时间")
	/**安装时间*/
	public long setupDate;
	@ApiModelProperty(value="备注")
	/**备注*/
	public String memo;
	@ApiModelProperty(value="设备状态")
	/**设备状态*/
	public String status;	
	@ApiModelProperty(value="上传图片")
	/**上传图片*/
	public List<PhotoVO> photoList;
	@ApiModelProperty(value="规格数据")
	/**规格数据*/
	public List<SpecDataVO> specDataList;
	@ApiModelProperty(value="位置标识符")
	/**位置标识符*/
	public int locationId;
	@ApiModelProperty(value="机构标识符")
	/**机构标识符*/
	public String organizationId;
	@ApiModelProperty(value="工艺系统标识符")
	/**工艺系统标识符*/
	public int processId;
	@ApiModelProperty(value="设备类型标识符")
	/**设备类型标识符*/
	public int categoryId;
	@ApiModelProperty(value="采购商用厂商标识符")
	/**采购商用厂商标识符*/
	public int vendorId;
	@ApiModelProperty(value="制造商用厂商标识符")
	/**制造商用厂商标识符*/
	public int manufacturerId;
	
	public class PhotoVO {
		public String photo;
		public int order;
	}
	
	public class SpecDataVO {
		public int specId;
		public String value;
	}
	
}
