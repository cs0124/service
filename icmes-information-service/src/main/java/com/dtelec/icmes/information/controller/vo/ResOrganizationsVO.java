package com.dtelec.icmes.information.controller.vo;

import java.util.List;

import com.dtelec.icmes.information.service.model.OrganizationsCollection;
import com.dtelec.icmes.information.service.model.OrganizationsFullNameModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ResOrganizationsVO<T> {
	@ApiModelProperty(value = "表示数据总数")
	public long totalCount;
	@ApiModelProperty(value = "表示数据的总页数")
	public long totalPages;
	@ApiModelProperty(value = "返回数据数组")
	public List<OrganizationsFullNameModel> items;
	/**
	 * 模型赋值
	 * @param coll
	 */
	public ResOrganizationsVO(OrganizationsCollection coll) {
		this.totalCount = coll.getTotalCount();
		this.totalPages = coll.getTotalPages();
		this.items = (List<OrganizationsFullNameModel>) coll.getItems();

	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public long getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(long totalPages) {
		this.totalPages = totalPages;
	}

	public List<OrganizationsFullNameModel> getItems() {
		return items;
	}

	public void setItems(List<OrganizationsFullNameModel> items) {
		this.items = items;
	}

}
