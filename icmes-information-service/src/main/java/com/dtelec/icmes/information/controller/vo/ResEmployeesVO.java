package com.dtelec.icmes.information.controller.vo;

import java.util.List;
import com.dtelec.icmes.information.service.model.EmployeesCollection;
import com.dtelec.icmes.information.service.model.EmployeesFullNameModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ResEmployeesVO<T> {
	@ApiModelProperty(value = "表示数据总数")
	public long totalCount;
	@ApiModelProperty(value = "表示数据的总页数")
	public long totalPages;
	@ApiModelProperty(value = "返回数据数组")
	public List<EmployeesFullNameModel> items;

	
	/**
	 * 模型赋值
	 * @param coll 员工集合
	 */
	public ResEmployeesVO(EmployeesCollection coll) {
		this.totalCount = coll.getTotalCount();
		this.totalPages = coll.getTotalPages();
		this.items =coll.getItems();

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

	public List<EmployeesFullNameModel> getItems() {
		return items;
	}

	public void setItems(List<EmployeesFullNameModel> items) {
		this.items = items;
	}

}
