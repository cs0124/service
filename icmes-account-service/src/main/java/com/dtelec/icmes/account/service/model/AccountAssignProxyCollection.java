package com.dtelec.icmes.account.service.model;

import java.util.List;

import com.dtelec.icmes.account.repository.entity.AccountAssignProxyEntity;
import com.dtelec.icmes.account.repository.entity.PageableQueryBaseEntity;
/**
 * 账户关系代理分页查询模型
 * @author zturnking
 *
 */
public class AccountAssignProxyCollection extends PageableSearchBaseModel<AccountAssignProxyModel> {
	/**
	 * 填充模型
	 * @param entity
	 * @param eachPageCount
	 */
	public void fill(PageableQueryBaseEntity<AccountAssignProxyEntity> entity, int eachPageCount) {
		if (eachPageCount < 1) { eachPageCount = 1;}
		
		long total = entity.getTotalCount();
		long pages = (long) Math.ceil((double)total / (double)eachPageCount);
		pages = (pages < 1) ? 1 : pages;
		
		this.setTotalCount(total);
		this.setTotalPages(pages);
		
		List<AccountAssignProxyEntity> entities = entity.getItems();
		if (entities != null) {
			for(AccountAssignProxyEntity child : entities) {
				if (child != null) {
					AccountAssignProxyModel model = new AccountAssignProxyModel();
					model.fill(child);
					this.addItem(model);
				}
			}
		}
	}
	
}
