package com.dtelec.icmes.account.controller.vo;

import java.util.List;

import com.dtelec.icmes.account.repository.entity.PageableQueryBaseEntity;
import com.dtelec.icmes.account.repository.param.AccountOrgPageableReturnParam;
import com.dtelec.icmes.account.service.model.AccountOrgModel;
import com.dtelec.icmes.account.service.model.PageableSearchBaseModel;

/**
 * 获取账户组织关系列表
 * @author zturnking
 *
 */
public class AccountOrgCollection extends PageableSearchBaseModel<AccountOrgModel>{
	/**
	 * 填充列表
	 * @param entity
	 * @param eachPageCount
	 */
	public void fill(PageableQueryBaseEntity<AccountOrgPageableReturnParam> entity, int eachPageCount) {
		if (eachPageCount < 1) { eachPageCount = 1;}
		
		long total = entity.getTotalCount();
		long pages = (long) Math.ceil((double)total / (double)eachPageCount);
		pages = (pages < 1) ? 1 : pages;
		
		this.setTotalCount(total);
		this.setTotalPages(pages);
		//给列表赋值
		List<AccountOrgPageableReturnParam> entities = entity.getItems();
		if (entities != null) {
			for(AccountOrgPageableReturnParam child : entities) {
				if (child != null) {
					AccountOrgModel model = new AccountOrgModel();
					model.fill(child);
					this.addItem(model);
				}
			}
		}
	}
		
}
