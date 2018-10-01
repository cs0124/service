package com.dtelec.icmes.account.service.model;

import java.util.List;

import com.dtelec.icmes.account.repository.entity.AccountConsignProxyEntity;
import com.dtelec.icmes.account.repository.entity.PageableQueryBaseEntity;

public class AccountConsignProxyCollection extends PageableSearchBaseModel<AccountConsignProxyModel> {

	public void fill(PageableQueryBaseEntity<AccountConsignProxyEntity> entity, int eachPageCount) {
		if (eachPageCount < 1) eachPageCount = 1;
		
		long total = entity.getTotalCount();
		long pages = (long) Math.ceil((double)total / (double)eachPageCount);
		pages = (pages < 1) ? 1 : pages;
		
		this.setTotalCount(total);
		this.setTotalPages(pages);
		
		List<AccountConsignProxyEntity> entities = entity.getItems();
		if (entities != null) {
			for(AccountConsignProxyEntity child : entities) {
				if (child != null) {
					AccountConsignProxyModel model = new AccountConsignProxyModel();
					model.fill(child);
					this.addItem(model);
				}
			}
		}
	}
	
}
