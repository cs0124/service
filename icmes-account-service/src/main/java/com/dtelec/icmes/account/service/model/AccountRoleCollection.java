package com.dtelec.icmes.account.service.model;

import java.util.List;

import com.dtelec.icmes.account.repository.entity.AccountRoleEntity;
import com.dtelec.icmes.account.repository.entity.PageableQueryBaseEntity;

public class AccountRoleCollection extends PageableSearchBaseModel<AccountRoleModel>{
	/**
	 * 角色列表
	 * @param entity
	 * @param eachPageCount
	 */
	public void fill(PageableQueryBaseEntity<AccountRoleEntity> entity, int eachPageCount) {
		if (eachPageCount < 1) eachPageCount = 1;
		//分页初始化
		long total = entity.getTotalCount();
		long pages = (long) Math.ceil((double)total / (double)eachPageCount);
		pages = (pages < 1) ? 1 : pages;
		
		this.setTotalCount(total);
		this.setTotalPages(pages);
		//模型赋值
		List<AccountRoleEntity> entities = entity.getItems();
		if (entities != null) {
			for(AccountRoleEntity child : entities) {
				if (child != null) {
					AccountRoleModel model = new AccountRoleModel();
					model.fill(child);
					this.addItem(model);
				}
			}
		}
	}
}
