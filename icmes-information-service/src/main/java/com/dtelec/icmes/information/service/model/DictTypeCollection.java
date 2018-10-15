package com.dtelec.icmes.information.service.model;

import java.util.List;

import com.dtelec.icmes.information.repository.entity.DictTypeEntity;
import com.dtelec.icmes.information.repository.entity.PageableSearchBaseEntity;

import io.swagger.annotations.ApiModel;
@ApiModel
public class DictTypeCollection extends PageableSearchBaseModel<DictTypeModel> {

	public void fill(PageableSearchBaseEntity<DictTypeEntity> entity, int eachPageCount) {
		if (eachPageCount < 1) { eachPageCount = 1;}
		
		long total = entity.getTotalCount();
		long pages = (long) Math.ceil((double)total / (double)eachPageCount);
		pages = (pages < 1) ? 1 : pages;
		
		this.setTotalCount(total);
		this.setTotalPages(pages);
		
		List<DictTypeEntity> entities = entity.getItems();
		if (entities != null) {
			for(DictTypeEntity child : entities) {
				if (child != null) {
					DictTypeModel model = new DictTypeModel();
					model.fill(child);
					this.addItem(model);
				}
			}
		}
	}

}
