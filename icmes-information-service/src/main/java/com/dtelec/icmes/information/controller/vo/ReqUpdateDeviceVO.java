package com.dtelec.icmes.information.controller.vo;

import java.util.List;


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
	
	
	public class PhotoVO {
		public String photo;
		public int order;
	}
	
	public class SpecDataVO {
		public int specId;
		public String value;
	}
	
}
