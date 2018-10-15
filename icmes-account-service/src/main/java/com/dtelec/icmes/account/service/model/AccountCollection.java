package com.dtelec.icmes.account.service.model;

import java.util.List;

import com.dtelec.icmes.account.repository.entity.AccountEntity;
import com.dtelec.icmes.account.repository.entity.PageableQueryBaseEntity;
/**
 * 账户分页查询模型
 * @author zturnking
 *
 */
public class AccountCollection extends PageableSearchBaseModel<AccountModel> {
	/**
	 * 填充模型
	 * @param entity
	 * @param eachPageCount
	 */
	public void fill(PageableQueryBaseEntity<AccountEntity> entity, int eachPageCount) {
		if (eachPageCount < 1) {eachPageCount = 1;}
		
		long total = entity.getTotalCount();
		long pages = (long) Math.ceil((double)total / (double)eachPageCount);
		pages = (pages < 1) ? 1 : pages;
		
		this.setTotalCount(total);
		this.setTotalPages(pages);
		
		List<AccountEntity> entities = entity.getItems();
		if (entities != null) {
			for(AccountEntity child : entities) {
				if (child != null) {
					AccountModel model = new AccountModel();
					model.fill(child);
					this.addItem(model);
				}
			}
		}
	}
	
}
