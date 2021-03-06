package com.dtelec.icmes.information.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtelec.icmes.information.repository.IOrganizationRepository;
import com.dtelec.icmes.information.repository.entity.OrganizationAccountFlatEntity;
import com.dtelec.icmes.information.repository.entity.OrganizationAccountTreeEntity;
import com.dtelec.icmes.information.repository.entity.OrganizationFullNameEntity;
import com.dtelec.icmes.information.repository.entity.PageableSearchBaseEntity;
import com.dtelec.icmes.information.repository.param.OrganizationAccountFlatPageableSearchParam;
import com.dtelec.icmes.information.repository.param.OrganizationPageableSearchParam;
import com.dtelec.icmes.information.service.annotation.QueryAction;
import com.dtelec.icmes.information.service.core.IQueryHandler;
import com.dtelec.icmes.information.service.model.OrganizationAccountFlatCollection;
import com.dtelec.icmes.information.service.model.OrganizationAccountTreeCollection;
import com.dtelec.icmes.information.service.model.OrganizationAccountTreeModel;
import com.dtelec.icmes.information.service.model.OrganizationsCollection;
import com.dtelec.icmes.information.service.query.OrganizationAccountsFlatQuery;
import com.dtelec.icmes.information.service.query.OrganizationAccountsTreeQuery;
import com.dtelec.icmes.information.service.query.OrganizationSearchQuery;

@Service
public class OrganizationQueryHandler implements IQueryHandler {
	
	@Autowired
	private IOrganizationRepository organizationRepo;
	
	
	/**
	 * 获取组织机构
	 * @param query 组织机构查询
	 * @return 组织机构集合
	 */
	@QueryAction
	public OrganizationsCollection getOrganizations(OrganizationSearchQuery query) {
		//分页初始化
		int pageNo = query.getPage();
		pageNo = (pageNo < 1) ? 1 : pageNo;
		int pageSize = query.getCount();
		pageSize = (pageSize < 0) ? 1 : pageSize;
		int startIndex = (pageNo - 1) * pageSize;
		//非空判定
		String parentId = query.getParentId();
		Boolean ascending = query.getAscending();
		if (ascending == null) {
			ascending = false;
		}
		int hierarchy;
		String hierarchyStr = query.getHierarchy();
		if (hierarchyStr == null || hierarchyStr.equals("")) {
			// 根节点，不能变
			hierarchy = 0;
		} else {
			hierarchy = Integer.parseInt(hierarchyStr);
		}
		if (parentId == null || parentId.equals("")) {
			// 根节点，不能变
			parentId = "0";
		}
		//实体类参数赋值
		OrganizationPageableSearchParam params = new OrganizationPageableSearchParam();
		params.setId(query.getId());
		params.setName(query.getName());
		params.setParentId(parentId);
		params.setHierarchy(hierarchy);
		params.setPageSize(pageSize);
		params.setStartIndex(startIndex);
		params.setOrderBy(query.getOrderBy());
		params.setAscending(ascending);

		//调用持久层
		PageableSearchBaseEntity<OrganizationFullNameEntity> entities = organizationRepo
				.getOrganizationsByIdAndName(params);
		//填充返回集合
		OrganizationsCollection coll = new OrganizationsCollection();
		coll.fill(entities, query.getCount());

		return coll;
	}
	
	
	/**
	 * 组织机构挂接人员查询
	 * @param query 组织机构挂接人员查询
	 * @return 集合
	 */
	@QueryAction
	public OrganizationAccountTreeCollection getOrganizationAccountsTree(OrganizationAccountsTreeQuery  query) {
		List<OrganizationAccountTreeEntity> organizationAccounts = organizationRepo.getOrganizationAccountsTree(query.getName());
		//初始化集合
		OrganizationAccountTreeCollection coll = new OrganizationAccountTreeCollection();
		//循环赋值
		for(OrganizationAccountTreeEntity entity :organizationAccounts) {
			OrganizationAccountTreeModel model = new OrganizationAccountTreeModel();
			model.setId(entity.getId());
			model.setName(entity.getName());
			model.setParentId(entity.getParentId());
			model.setParentName(entity.getParentName());
			model.setUserId(entity.getUserId());
			model.setHasChild(entity.isHasChild());
			coll.addItem(model);
		}
		return coll;
	}
	
	
	/**
	 * 组织结构挂接人员平行查询
	 * @param query 组织结构挂接人员平行查询
	 * @return 返回记录集合
	 */
	@QueryAction
	public OrganizationAccountFlatCollection getOrganizationAccountsFlat(OrganizationAccountsFlatQuery query) {
		//分页初始化
		int pageNo = query.getPage();
		pageNo = (pageNo < 1) ? 1 : pageNo;
		int pageSize = query.getCount();
		pageSize = (pageSize < 0) ? 0 : pageSize;
		int startIndex = (pageNo - 1) * pageSize;
		
		//给查询参数赋值
		OrganizationAccountFlatPageableSearchParam params = new OrganizationAccountFlatPageableSearchParam();
		params.setSearch(query.getSearch());
		params.setPageSize(pageSize);
		params.setStartIndex(startIndex);
		params.setOrderBy(query.getOrderBy());
		params.setAscending(query.isAscending());
		
		//查询数据库
		PageableSearchBaseEntity<OrganizationAccountFlatEntity> entities = organizationRepo.getOrganizationAccountsFlat(params);
		//填充返回值
		OrganizationAccountFlatCollection coll = new OrganizationAccountFlatCollection();
		coll.fill(entities, query.getCount());

		return coll;
	}

}
