package com.dtelec.icmes.information.service.model;

import java.util.List;

import com.dtelec.icmes.information.repository.entity.DeviceValueEntity;
import com.dtelec.icmes.information.repository.entity.PageableSearchBaseEntity;

/**
 * 设备净值分页集合 作者：孔轩
 */
public class DeviceValueCollection extends PageableSearchBaseModel<DeviceValueModel> {
    /**
	 * 位置信息分页集合元素赋值
	 * @param entity 位置全名实体类
	 * @param eachPageCount 每页显示条数
	 */
	public void fill(PageableSearchBaseEntity<DeviceValueEntity> entity, int eachPageCount) {
		if (eachPageCount < 1) {eachPageCount = 1;}
		//分页属性
		long total = entity.getTotalCount();
		long pages = (long) Math.ceil((double)total / (double)eachPageCount);
		pages = (pages < 1) ? 1 : pages;
		
		this.setTotalCount(total);
		this.setTotalPages(pages);
		//成员填充
		List<DeviceValueEntity> entities = entity.getItems();
		if (entities != null) {
			for(DeviceValueEntity child : entities) {
				if (child != null) {
                    
					DeviceValueModel model = new DeviceValueModel();
					model.fillModel(child);
					this.addItem(model);
				}
			}
		}
    }
}
