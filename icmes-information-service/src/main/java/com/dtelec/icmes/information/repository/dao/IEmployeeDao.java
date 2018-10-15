package com.dtelec.icmes.information.repository.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.dtelec.icmes.information.repository.entity.EmployeeEntity;
import com.dtelec.icmes.information.repository.entity.EmployeeFullNameEntity;
import com.dtelec.icmes.information.repository.param.EmployeePageableSearchParam;

@Mapper
public interface IEmployeeDao {
	/**
	 * 通过员工工号获取员工信息
	 * @param employeeId 员工工号
	 * @return 员工 实体类
	 */
	EmployeeEntity findByEmployeeId(@Param("employeeId") String employeeId);

	/**
	 * 修改员工信息
	 * @param entity 员工实体类
	 */
	void updateEmployee(@Param("entity") EmployeeEntity entity);
	
	/**
	 * 创建员工信息
	 * @param entity 员工实体类
	 */
	void createEmployee(@Param("entity") EmployeeEntity entity);
	
	/**
	 * 获取员工信息
	 * @param params 查询参数
	 * @return 员工实体类
	 */
	List<EmployeeFullNameEntity> getEmployees(@Param("param") EmployeePageableSearchParam params);

	/**
	 * 获取员工总记录数
	 * @param params 查询参数
	 * @return 总数
	 */
	int getEmployeesCount(@Param("param") EmployeePageableSearchParam params);
	
	/**
	 * 删除员工信息
	 * @param id 员工工号
	 */
	void deleteEmployee(@Param("id") String id);
	
	/**
	 * 创建账号
	 * @param id 工号
	 * @param name 姓名
	 * @param device 专用设备
	 */
	void persistentEmployeeBase(@Param("id") String id, @Param("name") String name, @Param("device") String device);
}
