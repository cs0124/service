package com.dtelec.icmes.information.service.model;

import java.util.List;

import com.dtelec.icmes.information.repository.entity.LocationFullNameEntity;
import com.dtelec.icmes.information.repository.entity.PageableSearchBaseEntity;


/**
 * 位置信息分页集合
 * 作者：孔轩
 */
public class LocationCollection extends PageableSearchBaseModel<LocationFullNameModel> {

    /**
	 * 位置信息分页集合元素赋值
	 * @param entity 位置全名实体类
	 * @param eachPageCount 每页显示条数
	 */
	public void fill(PageableSearchBaseEntity<LocationFullNameEntity> entity, int eachPageCount) {
		if (eachPageCount < 1) {eachPageCount = 1;}
		//分页属性
		long total = entity.getTotalCount();
		long pages = (long) Math.ceil((double)total / (double)eachPageCount);
		pages = (pages < 1) ? 1 : pages;
		
		this.setTotalCount(total);
		this.setTotalPages(pages);
		//成员填充
		List<LocationFullNameEntity> entities = entity.getItems();
		if (entities != null) {
			for(LocationFullNameEntity child : entities) {
				if (child != null) {
					LocationFullNameModel model = new LocationFullNameModel();
					model.fillModel(child);
					this.addItem(model);
				}
			}
		}
    }
}
