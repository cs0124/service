package com.dtelec.icmes.account.service.model;

import java.util.List;

import com.dtelec.icmes.account.repository.entity.PageableQueryBaseEntity;
import com.dtelec.icmes.account.repository.entity.RoleEntity;

public class RoleCollection extends PageableSearchBaseModel<RoleModel>{
	/**
	 * 模型填充
	 * @param entity
	 * @param eachPageCount
	 */
	public void fill(PageableQueryBaseEntity<RoleEntity> entity, int eachPageCount) {
		if (eachPageCount < 1) eachPageCount = 1;
		//分页初始化
		long total = entity.getTotalCount();
		long pages = (long) Math.ceil((double)total / (double)eachPageCount);
		pages = (pages < 1) ? 1 : pages;
		
		this.setTotalCount(total);
		this.setTotalPages(pages);
		//集合填充
		List<RoleEntity> entities = entity.getItems();
		if (entities != null) {
			for(RoleEntity child : entities) {
				if (child != null) {
					RoleModel model = new RoleModel();
					model.fill(child);
					this.addItem(model);
				}
			}
		}
	}
}
