package com.dtelec.icmes.information.service.model;

import java.util.List;

import com.dtelec.icmes.information.repository.entity.EmployeeFullNameEntity;
import com.dtelec.icmes.information.repository.entity.PageableSearchBaseEntity;

public class EmployeesCollection extends PageableSearchBaseModel<EmployeesFullNameModel> {
	
	/**
	 * 员工信息分页集合元素赋值
	 * @param entity
	 * @param eachPageCount
	 */
	public void fill(PageableSearchBaseEntity<EmployeeFullNameEntity> entity, int eachPageCount) {
		if (eachPageCount < 1) eachPageCount = 1;
		//返回总记录数
		long total = entity.getTotalCount();
		long pages = (long) Math.ceil((double)total / (double)eachPageCount);
		pages = (pages < 1) ? 1 : pages;
		
		this.setTotalCount(total);
		this.setTotalPages(pages);
		//从数据库里返回的记录
		List<EmployeeFullNameEntity> entities = entity.getItems();
		if (entities != null) {
			for(EmployeeFullNameEntity child : entities) {
				if (child != null) {
					EmployeesFullNameModel model = new EmployeesFullNameModel();
					//entity型转换成model型
					model.fillModel(child);
					this.addItem(model);
				}
			}
		}
	}
	
}
