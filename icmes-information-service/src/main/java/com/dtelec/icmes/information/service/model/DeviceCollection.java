package com.dtelec.icmes.information.service.model;

import java.util.List;

import com.dtelec.icmes.information.repository.entity.PageableSearchBaseEntity;
import com.dtelec.icmes.information.repository.param.DevicePageableSearchResultParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 设备列表查询返回两个list，一个是设备列表，一个是每个设备对应的规格列表
 * @author 张瑞晗
 *
 */
@ApiModel
public class DeviceCollection extends PageableSearchBaseModel<DeviceModel> {
	/**
	 * 设备规格返回列表
	 */
	@ApiModelProperty(value = "设备规格列表")
	private List<DeviceSpecDataModel> specModList;

	public List<DeviceSpecDataModel> getSpecModList() {
		return specModList;
	}

	public void setSpecModList(List<DeviceSpecDataModel> specModList) {
		this.specModList = specModList;
	}
	/**
	 * 设备列表模型填充
	 * @param entity
	 * @param eachPageCount
	 */
	public void fill(PageableSearchBaseEntity<DevicePageableSearchResultParam> entity, int eachPageCount) {
		// 分页属性
		if (eachPageCount < 1) {
			eachPageCount = 1;
		}
		long total = entity.getTotalCount();
		long pages = (long) Math.ceil((double) total / (double) eachPageCount);
		pages = (pages < 1) ? 1 : pages;

		this.setTotalCount(total);
		this.setTotalPages(pages);

		// 成员填充
		List<DevicePageableSearchResultParam> entities = entity.getItems();
		if (entities != null) {
			for (DevicePageableSearchResultParam child : entities) {
				if (child != null) {
					DeviceModel model = new DeviceModel();
					model.fill(child);
					this.addItem(model);
				}
			}
		}

	}
}
