package com.dtelec.icmes.information.service.model;

import java.util.List;

import com.dtelec.icmes.information.repository.entity.OrganizationFullNameEntity;
import com.dtelec.icmes.information.repository.entity.PageableSearchBaseEntity;



public class OrganizationsCollection extends PageableSearchBaseModel<OrganizationsFullNameModel> {
	/**
	 * 组织机构分页集合元素赋值
	 * @param entity
	 * @param eachPageCount
	 */
	public void fill(PageableSearchBaseEntity<OrganizationFullNameEntity> entity, int eachPageCount) {
		if (eachPageCount < 1) eachPageCount = 1;
		//分页属性
		long total = entity.getTotalCount();
		long pages = (long) Math.ceil((double)total / (double)eachPageCount);
		pages = (pages < 1) ? 1 : pages;
		
		this.setTotalCount(total);
		this.setTotalPages(pages);
		//成员填充
		List<OrganizationFullNameEntity> entities = entity.getItems();
		if (entities != null) {
			for(OrganizationFullNameEntity child : entities) {
				if (child != null) {
					OrganizationsFullNameModel model = new OrganizationsFullNameModel();
					model.fillModel(child);
					this.addItem(model);
				}
			}
		}
	}
}
