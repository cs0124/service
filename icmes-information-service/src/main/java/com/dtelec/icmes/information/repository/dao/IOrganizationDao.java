package com.dtelec.icmes.information.repository.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.dtelec.icmes.information.repository.entity.OrganizationAccountFlatEntity;
import com.dtelec.icmes.information.repository.entity.OrganizationAccountTreeEntity;
import com.dtelec.icmes.information.repository.entity.OrganizationEntity;
import com.dtelec.icmes.information.repository.entity.OrganizationFullNameEntity;
import com.dtelec.icmes.information.repository.param.OrganizationAccountFlatPageableSearchParam;
import com.dtelec.icmes.information.repository.param.OrganizationPageableSearchParam;


@Mapper
public interface IOrganizationDao {
	/**
	 * 获取组织机构全称
	 * @param param 查询参数
	 * @return 组织机构全称
	 */
   List<OrganizationFullNameEntity> getFullNameOrganizations(@Param("param") OrganizationPageableSearchParam param);
   
   /**
	 * 获取组织机构全称数量统计
	 * @param param 查询参数
	 * @return 总数
	 */
   int getFullNameOrganizationsCount(@Param("param") OrganizationPageableSearchParam param);
   
   
   /**
    * 检查组织机构
    * @param entity 组织机构实体类
    * @return 总数
    */
   int checkOrganization(@Param("entity") OrganizationEntity entity);
   
   /**
    * 创建组织机构
    * @param entity 组织机构实体类
    */
   void createOrganization(@Param("entity") OrganizationEntity entity);
   
   /**
    * 编辑组织机构
    * @param entity 组织机构实体类
    */
   void updateOrganization(@Param("entity") OrganizationEntity entity);
   
   /**
    * 查询传入的组织机构版本号
    * @param entity 组织机构实体类
    * @return 组织机构实体类
    */
   OrganizationEntity fetchOrganizationVersionTag(@Param("entity") OrganizationEntity entity);
   
   /**
    * 查询是否和角色以及用户表关联
    * @param entity 组织机构实体类
    * @return 总数
    */
   int countOrganizationASS(@Param("entity") OrganizationEntity entity);
   
   /**
    * 查询是否是叶子
    * @param entity 组织机构实体类
    * @return 总数
    */
   int countOrganizationIfEnd(@Param("entity") OrganizationEntity entity);
   
   /**
    * 查询是否和员工表关联
    * @param entity 组织机构实体类
    * @return 总数
    */
   int countOrganizationEmployeeASS(@Param("entity") OrganizationEntity entity);
   
   /**
    * 删除组织机构
    * @param entity 组织机构实体类
    */
   void deleteOrganization(@Param("entity") OrganizationEntity entity);
   
   /**
    * 查询组织机构和账户关系树
    * @param name 名称
    * @return 组织账号数实体类
    */
   List<OrganizationAccountTreeEntity> getOrganizationAccountsTree(@Param("name") String name);
   
   /**
    * 查询组织机构和账户关系行
    * @param params 查询参数
    * @return 组织机构账号实体类
    */
   List<OrganizationAccountFlatEntity> getOrganizationAccountsFlat(@Param("params") OrganizationAccountFlatPageableSearchParam params);
   
   long countOrganizationAccountsFlatTotal(@Param("params") OrganizationAccountFlatPageableSearchParam params);
   
}
