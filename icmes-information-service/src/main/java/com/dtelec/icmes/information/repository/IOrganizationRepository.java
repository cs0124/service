package com.dtelec.icmes.information.repository;


import java.util.List;

import com.dtelec.icmes.information.repository.entity.OrganizationAccountEntity;
import com.dtelec.icmes.information.repository.entity.OrganizationEntity;
import com.dtelec.icmes.information.repository.entity.OrganizationFullNameEntity;
import com.dtelec.icmes.information.repository.entity.PageableSearchBaseEntity;
import com.dtelec.icmes.information.repository.param.OrganizationPageableSearchParam;
import com.dtelec.icmes.information.service.model.OrganizationModel;

public interface IOrganizationRepository {
	/**
	 * 通过Id和Name获取组织机构
	 */
	public PageableSearchBaseEntity<OrganizationFullNameEntity> getOrganizationsByIdAndName(OrganizationPageableSearchParam param);
	
	/**
	 * 创建组织机构
	 */
	public void createOrganization(OrganizationEntity entity);
	
	/**
	 * 检查版本控制信息
	 */
	public OrganizationModel fetchOrganizationVersionTag(OrganizationEntity entity);
	
	/**
	 * 更新组织机构
	 */
	public void updateOrganization(OrganizationEntity entity);
	
	/**
	 * 统计符合条件的组织机构数量
	 */
	public int countOrganizationASS(OrganizationEntity entity);
	
	/**
	 * 删除组织机构
	 */
	public void deleteOrganization(OrganizationEntity entity);
	
	/**
	 * 查询机构和用户关联列表
	 */
	public List<OrganizationAccountEntity> getOrganizationAccounts(String name);
}
