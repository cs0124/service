package com.dtelec.icmes.information.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dtelec.icmes.information.repository.IOrganizationRepository;
import com.dtelec.icmes.information.repository.dao.IOrganizationDao;
import com.dtelec.icmes.information.repository.entity.OrganizationAccountFlatEntity;
import com.dtelec.icmes.information.repository.entity.OrganizationAccountTreeEntity;
import com.dtelec.icmes.information.repository.entity.OrganizationEntity;
import com.dtelec.icmes.information.repository.entity.OrganizationFullNameEntity;
import com.dtelec.icmes.information.repository.entity.PageableSearchBaseEntity;
import com.dtelec.icmes.information.repository.param.OrganizationAccountFlatPageableSearchParam;
import com.dtelec.icmes.information.repository.param.OrganizationPageableSearchParam;
import com.dtelec.icmes.information.service.model.OrganizationModel;

@Repository
public class OrganizationRepositoryImpl implements IOrganizationRepository {

	@Autowired
	private IOrganizationDao organizationDao;
	
	
	/**
	 * 通过Id和Name获取组织机构
	 */
	@Override
	public PageableSearchBaseEntity<OrganizationFullNameEntity> getOrganizationsByIdAndName(
			OrganizationPageableSearchParam param) {
		PageableSearchBaseEntity<OrganizationFullNameEntity> entity = new PageableSearchBaseEntity<OrganizationFullNameEntity>();
		//查询集合
		List<OrganizationFullNameEntity> fullNameOrganizations = organizationDao.getFullNameOrganizations(param);
		//统计条数
		int totalCount = organizationDao.getFullNameOrganizationsCount(param);
		entity.setTotalCount(totalCount);
		entity.setItems(fullNameOrganizations);
		return entity;
	}
	
	
	/**
	 * 检查是否存在
	 */
	@Override
	public int checkOrganization(OrganizationEntity entity) {
		int count = organizationDao.checkOrganization(entity);
		return count;
	}
	
	/**
	 * 创建组织机构
	 */
	@Override
	public void createOrganization(OrganizationEntity entity) {
		organizationDao.createOrganization(entity);
	}
	
	
	/**
	 * 检查版本控制信息
	 */
	@Override
	public OrganizationModel fetchOrganizationVersionTag(OrganizationEntity entity) {
		OrganizationEntity returnEntity = organizationDao.fetchOrganizationVersionTag(entity);
		OrganizationModel model = new OrganizationModel();
		model.fillModel(returnEntity);

		return model;
	}
	
	
	/**
	 * 更新组织机构
	 */
	@Override
	public void updateOrganization(OrganizationEntity entity) {
		organizationDao.updateOrganization(entity);
	}
	
	
	/**
	 * 统计符合条件的组织机构数量
	 */
	@Override
	public int countOrganizationASS(OrganizationEntity entity) {
		//定义返回的returnCount
		int returnCount = 1;
		//获取是不是叶子，最后一级，为0是
		int countEnd = organizationDao.countOrganizationIfEnd(entity);
		//判断当前机构是否有关联用户，为0则没有用户
		int count = organizationDao.countOrganizationASS(entity);
		//判断员工表是否有关联
		int countEmployee = organizationDao.countOrganizationEmployeeASS(entity);
		//如果都是0则可以删除
		if (count == 0 && countEnd == 0 && countEmployee==0) {
			returnCount = 0;
		}
		return returnCount;
	}
	
	
	/**
	 * 删除组织机构
	 */
	@Override
	public void deleteOrganization(OrganizationEntity entity) {
		organizationDao.deleteOrganization(entity);
	}
	
	
	/**
	 * 查询机构和用户关联树形列表
	 */
	@Override
	public List<OrganizationAccountTreeEntity> getOrganizationAccountsTree(String name) {
		List<OrganizationAccountTreeEntity> list = organizationDao.getOrganizationAccountsTree(name);
		
		return list;
	}
	
	/**
	 * 查询机构和用户关联平行列表
	 */
	@Override
	public PageableSearchBaseEntity<OrganizationAccountFlatEntity> getOrganizationAccountsFlat(OrganizationAccountFlatPageableSearchParam params) {
		PageableSearchBaseEntity<OrganizationAccountFlatEntity> entity = new PageableSearchBaseEntity<OrganizationAccountFlatEntity>();
		List<OrganizationAccountFlatEntity> fullNameEmployees = organizationDao.getOrganizationAccountsFlat(params);
		long totalCount = organizationDao.countOrganizationAccountsFlatTotal(params);
		//set返回值
		entity.setTotalCount(totalCount);
		entity.setItems(fullNameEmployees);
		return entity;
	}

}
