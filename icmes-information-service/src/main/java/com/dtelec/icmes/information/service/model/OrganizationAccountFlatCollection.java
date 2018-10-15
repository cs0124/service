package com.dtelec.icmes.information.service.model;

import java.util.List;

import com.dtelec.icmes.information.repository.entity.OrganizationAccountFlatEntity;
import com.dtelec.icmes.information.repository.entity.PageableSearchBaseEntity;

public class OrganizationAccountFlatCollection extends PageableSearchBaseModel<OrganizationAccountFlatModel> {
	/**
	 * 组织机构分页集合元素赋值
	 * @param entity 组织机构实体类
	 * @param eachPageCount 每页显示条数
	 */
	public void fill(PageableSearchBaseEntity<OrganizationAccountFlatEntity> entity, int eachPageCount) {
		if (eachPageCount < 1) {eachPageCount = 1;}
		//分页属性
		long total = entity.getTotalCount();
		long pages = (long) Math.ceil((double)total / (double)eachPageCount);
		pages = (pages < 1) ? 1 : pages;
		
		this.setTotalCount(total);
		this.setTotalPages(pages);
		//成员填充
		List<OrganizationAccountFlatEntity> entities = entity.getItems();
		if (entities != null) {
			for(OrganizationAccountFlatEntity child : entities) {
				if (child != null) {
					OrganizationAccountFlatModel model = new OrganizationAccountFlatModel();
					model.fill(child);
					this.addItem(model);
				}
			}
		}
	}
}
