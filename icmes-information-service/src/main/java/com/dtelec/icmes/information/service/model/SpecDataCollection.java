package com.dtelec.icmes.information.service.model;

import java.util.ArrayList;
import java.util.List;
import com.dtelec.icmes.information.repository.entity.SpecDataEntity;

/**
 * 获取所有规格类型和数据模版
 * @author schi
 *
 */
public class SpecDataCollection {
	
	private List<SpecDataModel> innerList;
	
	public SpecDataCollection() {
		innerList = new ArrayList<>();
	}
	
	/**
	 * 填充返回数据
	 * @param entity 所有规格类型和数据模版集合
	 */
	public void fill(List<SpecDataEntity> entity) {
		if (entity != null) {
			for(SpecDataEntity child : entity) {
				if (child != null) {
					SpecDataModel model = new SpecDataModel();
					//entity型转换成model型
					model.fill(child);
					
					this.innerList.add(model);
				}
			}
		}
	}
	
	public List<SpecDataModel> getItems() {
		return this.innerList;
	}
		
}
