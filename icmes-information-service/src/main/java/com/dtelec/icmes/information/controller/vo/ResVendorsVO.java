package com.dtelec.icmes.information.controller.vo;

import java.util.List;

import com.dtelec.icmes.information.service.model.VendorCollection;
import com.dtelec.icmes.information.service.model.VendorModel;
import io.swagger.annotations.ApiModelProperty;

public class ResVendorsVO<T> {
	@ApiModelProperty(value = "表示数据总数")
	public long totalCount;
	@ApiModelProperty(value = "表示数据的总页数")
	public long totalPages;
	@ApiModelProperty(value = "返回数据数组")
	public List<VendorModel> items;
	
	/**
	 * 模型赋值
	 * @param collection
	 */
	public ResVendorsVO(VendorCollection collection) {
		this.totalCount = collection.getTotalCount();
		this.totalPages = collection.getTotalPages();
		this.items = collection.getItems();
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
	
	public List<VendorModel> getItems() {
		return items;
	}
	
	public void setItems(List<VendorModel> items) {
		this.items = items;
	}
	
}
