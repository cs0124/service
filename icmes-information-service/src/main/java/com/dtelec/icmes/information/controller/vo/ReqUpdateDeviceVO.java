package com.dtelec.icmes.information.controller.vo;

import java.util.List;

/**
 * 设备编辑VO
 * @author schi
 *
 */
public class ReqUpdateDeviceVO {

	public int parentId;
	public String processNo;
	public String name;
	public String model;
	public long purchaseDate;
	public double purchasePrice;
	public long manufacturingDate; 
	public String manufacturingPlace;
	public long setupDate;
	public String memo;
	public String status;	
	public List<PhotoVO> photoList;
	public List<SpecDataVO> specDataList;
	public int locationId;
	public String organizationId;
	public int processId;
	public int categoryId;
	public int vendorId;
	public int manufacturerId;
	public String versionTag;
	
	
	/**
	 * 设备照片
	 * @author schi
	 *
	 */
	public static class PhotoVO {
		public String photo;
		public int order;
	}
	
	/**
	 * 设备规格数据
	 * @author schi
	 *
	 */
	public static class SpecDataVO {
		public int specId;
		public String value;
	}
	
}
