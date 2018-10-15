package com.dtelec.icmes.information.service.model;

import java.util.List;

import com.dtelec.icmes.information.repository.entity.PageableSearchBaseEntity;
import com.dtelec.icmes.information.repository.entity.VendorEntity;

public class VendorCollection extends PageableSearchBaseModel<VendorModel> {

	/**
	 * 厂商信息分页集合元素赋值
	 * @param entity
	 * @param eachPageCount
	 */
	
	public void fill(PageableSearchBaseEntity<VendorEntity> entity, int eachPageCount) {
		if (eachPageCount < 1) {eachPageCount = 1;}
		//返回总记录数
		long total = entity.getTotalCount();
		long pages = (long) Math.ceil((double)total / (double)eachPageCount);
		pages = (pages < 1) ? 1 : pages;
		
		this.setTotalCount(total);
		this.setTotalPages(pages);
		
		//从数据库里返回的记录
		List<VendorEntity> entities = entity.getItems();
		if (entities != null) {
			for(VendorEntity child : entities) {
				if (child != null) {
					VendorModel model = new VendorModel();
					//entity型转换成model型
					model.fillModel(child);
					this.addItem(model);
				}
			}
		}
		
	}
}
