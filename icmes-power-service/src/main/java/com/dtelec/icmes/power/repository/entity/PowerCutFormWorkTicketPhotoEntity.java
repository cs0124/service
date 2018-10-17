package com.dtelec.icmes.power.repository.entity;
/**
 * 申请单工作票实体类
 * @author dell
 *
 */
public class PowerCutFormWorkTicketPhotoEntity {
	private String powerCutFormId;
	private String photo;
	private int order;	
	
	
	public PowerCutFormWorkTicketPhotoEntity(String powerCutFormId, String photo, int order) {
		super();
		this.powerCutFormId = powerCutFormId;
		this.photo = photo;
		this.order = order;
	}

	
	public String getPowerCutFormId() {
		return powerCutFormId;
	}

	
	public void setPowerCutFormId(String powerCutFormId) {
		this.powerCutFormId = powerCutFormId;
	}

	
	public String getPhoto() {
		return photo;
	}

	
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	
	public int getOrder() {
		return order;
	}

	
	public void setOrder(int order) {
		this.order = order;
	}
	
	
	
	
	
}
