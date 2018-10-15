package com.dtelec.icmes.information.service.model;

import java.util.List;
import java.util.Map;

import com.dtelec.icmes.information.repository.entity.DeviceCategoryBaseEntity;
import com.dtelec.icmes.information.repository.entity.PageableSearchBaseEntity;

/**
 * 设备类型集合
 * @author schi
 *
 */
public class DeviceCategoryCollection extends PageableSearchBaseModel<DeviceCategoryModel> {

	/**
	 * 设备类型信息分页集合元素赋值
	 * @param entity 持久层实体类
	 * @param eachPageCount 每页显示数据条数
	 * @param list 
	 */
	public void fill(PageableSearchBaseEntity<DeviceCategoryBaseEntity> entity, int eachPageCount, Map<Integer, List<SpecDataModel>> specDataMapping) {
		if (eachPageCount < 1) {eachPageCount = 1;}
		//返回总记录数
		long total = entity.getTotalCount();
		long pages = (long) Math.ceil((double)total / (double)eachPageCount);
		pages = (pages < 1) ? 1 : pages;
		
		this.setTotalCount(total);
		this.setTotalPages(pages);
		//从数据库里返回的记录
		List<DeviceCategoryBaseEntity> entities = entity.getItems();
		if (entities != null) {
			for(DeviceCategoryBaseEntity child : entities) {
				if (child != null) {
					DeviceCategoryModel model = new DeviceCategoryModel();
					//entity型转换成model型
					model.fill(child);
					model.setSpecDataList(specDataMapping.get(model.getId()));
					this.addItem(model);
				}
			}
		}
	}
}
