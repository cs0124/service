package com.dtelec.icmes.power.service.model;

import java.util.List;

import com.dtelec.icmes.power.repository.entity.PowerCutFormBaseEntity;
import com.dtelec.icmes.power.repository.entity.PageableQueryBaseEntity;

public class PowerCutFormCollection extends PageableSearchBaseModel<PowerCutFormBaseModel> {
    
	/**
	 * 填充模型
	 * @param entity
	 * @param eachPageCount
	 */
	public void fill(PageableQueryBaseEntity<PowerCutFormBaseEntity> entity, int eachPageCount) {
		if (eachPageCount < 1) {
			eachPageCount = 1;
		}
		
		long total = entity.getTotalCount();
		long pages = (long) Math.ceil((double)total / (double)eachPageCount);
		pages = (pages < 1) ? 1 : pages;
		
		this.setTotalCount(total);
		this.setTotalPages(pages);
		
		List<PowerCutFormBaseEntity> entities = entity.getItems();
		if (entities != null) {
			for(PowerCutFormBaseEntity child : entities) {
				if (child != null) {
					PowerCutFormBaseModel model = new PowerCutFormBaseModel();
					model.fill(child);
					this.addItem(model);
				}
			}
		}
	}
	
}
