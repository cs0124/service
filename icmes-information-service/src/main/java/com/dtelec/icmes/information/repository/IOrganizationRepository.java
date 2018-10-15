package com.dtelec.icmes.information.repository;

import java.util.List;
import com.dtelec.icmes.information.repository.entity.OrganizationAccountFlatEntity;
import com.dtelec.icmes.information.repository.entity.OrganizationAccountTreeEntity;
import com.dtelec.icmes.information.repository.entity.OrganizationEntity;
import com.dtelec.icmes.information.repository.entity.OrganizationFullNameEntity;
import com.dtelec.icmes.information.repository.entity.PageableSearchBaseEntity;
import com.dtelec.icmes.information.repository.param.OrganizationAccountFlatPageableSearchParam;
import com.dtelec.icmes.information.repository.param.OrganizationPageableSearchParam;
import com.dtelec.icmes.information.service.model.OrganizationModel;

public interface IOrganizationRepository {
	/**
	 * 通过Id和Name获取组织机构
	 * @param param 查询参数
	 * @return 组织机构实体类
	 */
	public PageableSearchBaseEntity<OrganizationFullNameEntity> getOrganizationsByIdAndName(OrganizationPageableSearchParam param);
	
	/**
	 * 检查组织机构
	 * @param entity 组织机构实体类
	 * @return 数量
	 */
	public int checkOrganization(OrganizationEntity entity);
	
	/**
	 * 创建组织机构
	 * @param entity 组织机构实体类
	 */
	public void createOrganization(OrganizationEntity entity);
	
	/**
	 * 检查版本控制信息
	 * @param entity 组织机构实体类
	 * @return 组织机构模型
	 */
	public OrganizationModel fetchOrganizationVersionTag(OrganizationEntity entity);
	
	/**
	 * 更新组织机构
	 * @param entity 组织机构实体类
	 */
	public void updateOrganization(OrganizationEntity entity);
	
	/**
	 * 统计符合条件的组织机构数量
	 * @param entity 组织机构实体类
	 * @return 数量
	 */
	public int countOrganizationASS(OrganizationEntity entity);
	
	/**
	 * 删除组织机构
	 * @param entity 组织机构实体类
	 */
	public void deleteOrganization(OrganizationEntity entity);
	
	/**
	 * 查询机构和用户关联树形列表
	 * @return 组织机构账号实体类
	 * @param name 名称
	 */                                                              
	public List<OrganizationAccountTreeEntity> getOrganizationAccountsTree(String name);
	
	/**
	 * 查询机构和用户关联平行列表
	 * @return 组织机构账号实体类
	 * @param params 查询参数
	 */
	public PageableSearchBaseEntity<OrganizationAccountFlatEntity> getOrganizationAccountsFlat(OrganizationAccountFlatPageableSearchParam params);
}
