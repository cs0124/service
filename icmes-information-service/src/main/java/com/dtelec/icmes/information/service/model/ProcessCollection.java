package com.dtelec.icmes.information.service.model;

import java.util.List;
import com.dtelec.icmes.information.repository.entity.PageableSearchBaseEntity;
import com.dtelec.icmes.information.repository.entity.ProcessEntity;

/**
 * 工艺集合
 *
 */
public class ProcessCollection extends PageableSearchBaseModel<ProcessModel> {

	/**
	 * 工艺信息分页集合元素赋值
	 * @param entity 持久层实体类
	 * @param eachPageCount 每页显示数据条数
	 */
	public void fill(PageableSearchBaseEntity<ProcessEntity> entity, int eachPageCount) {
		if (eachPageCount < 1) {eachPageCount = 1;}
		//返回总记录数
		long total = entity.getTotalCount();
		long pages = (long) Math.ceil((double)total / (double)eachPageCount);
		pages = (pages < 1) ? 1 : pages;
		
		this.setTotalCount(total);
		this.setTotalPages(pages);
		//从数据库里返回的记录
		List<ProcessEntity> entities = entity.getItems();
		if (entities != null) {
			for(ProcessEntity child : entities) {
				if (child != null) {
					ProcessModel model = new ProcessModel();
					//entity型转换成model型
					model.fill(child);
					this.addItem(model);
				}
			}
		}
	}
}
