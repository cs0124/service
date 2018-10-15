package com.dtelec.icmes.information.service.model;

import java.util.List;

import com.dtelec.icmes.information.repository.entity.DictDataFullEntity;
import com.dtelec.icmes.information.repository.entity.PageableSearchBaseEntity;

import io.swagger.annotations.ApiModel;
@ApiModel
public class DictDataCollection extends PageableSearchBaseModel<DictDataModel> {

	public void fill(PageableSearchBaseEntity<DictDataFullEntity> entity, int eachPageCount) {
		if (eachPageCount < 1) { eachPageCount = 1;}
		
		long total = entity.getTotalCount();
		long pages = (long) Math.ceil((double)total / (double)eachPageCount);
		pages = (pages < 1) ? 1 : pages;
		
		this.setTotalCount(total);
		this.setTotalPages(pages);
		
		List<DictDataFullEntity> entities = entity.getItems();
		if (entities != null) {
			for(DictDataFullEntity child : entities) {
				if (child != null) {
					DictDataModel model = new DictDataModel();
					model.fill(child);
					this.addItem(model);
				}
			}
		}
	}



}
