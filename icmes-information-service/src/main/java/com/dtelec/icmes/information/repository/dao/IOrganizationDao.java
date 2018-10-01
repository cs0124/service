package com.dtelec.icmes.information.repository.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.dtelec.icmes.information.repository.entity.OrganizationAccountEntity;
import com.dtelec.icmes.information.repository.entity.OrganizationEntity;
import com.dtelec.icmes.information.repository.entity.OrganizationFullNameEntity;
import com.dtelec.icmes.information.repository.param.OrganizationPageableSearchParam;


@Mapper
public interface IOrganizationDao {
	/**
	 * 获取组织机构全称
	 * @param param
	 * @return
	 */
   List<OrganizationFullNameEntity> getFullNameOrganizations(@Param("param") OrganizationPageableSearchParam param);
   
   /**
	 * 获取组织机构全称数量统计
	 * @param param
	 * @return
	 */
   int getFullNameOrganizationsCount(@Param("param") OrganizationPageableSearchParam param);
   
   /**
    * 创建组织机构
    * @param entity
    */
   void createOrganization(@Param("entity") OrganizationEntity entity);
   
   /**
    * 编辑组织机构
    * @param entity
    */
   void updateOrganization(@Param("entity") OrganizationEntity entity);
   
   /**
    * 查询传入的组织机构版本号
    * @param entity
    * @return
    */
   OrganizationEntity fetchOrganizationVersionTag(@Param("entity") OrganizationEntity entity);
   
   /**
    * 查询是否和角色以及用户表关联
    * @param entity
    * @return
    */
   int countOrganizationASS(@Param("entity") OrganizationEntity entity);
   
   /**
    * 查询是否是叶子
    * @param entity
    * @return
    */
   int countOrganizationIfEnd(@Param("entity") OrganizationEntity entity);
   
   /**
    * 查询是否和员工表关联
    * @param entity
    * @return
    */
   int countOrganizationEmployeeASS(@Param("entity") OrganizationEntity entity);
   
   /**
    * 删除组织机构
    * @param entity
    */
   void deleteOrganization(@Param("entity") OrganizationEntity entity);
   
   /**
    * 查询组织机构和账户关系树
    * @param name
    * @return
    */
   List<OrganizationAccountEntity> getOrganizationAccounts(@Param("name") String name);
}
