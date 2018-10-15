package com.dtelec.icmes.information.repository;

import com.dtelec.icmes.information.repository.entity.EmployeeEntity;
import com.dtelec.icmes.information.repository.entity.EmployeeFullNameEntity;
import com.dtelec.icmes.information.repository.entity.PageableSearchBaseEntity;
import com.dtelec.icmes.information.repository.param.EmployeePageableSearchParam;

public interface IEmployeeRepository {
	/**
	 * 通过员工工号获取员工信息
	 * @param id 员工工号
	 * @return 员工实体类
	 */
	public EmployeeEntity getEmployeeById(String id);
	
	/**
	 * 修改员工信息
	 * @param entity 员工实体类
	 */
	public void updateEmployee(EmployeeEntity entity);
	
	/**
	 * 创建员工信息
	 * @param entity 员工实体类
	 */
	public void createEmployee(EmployeeEntity entity);
	
	/**
	 * 删除员工信息
	 * @param id  员工工号
	 */
	public void deleteEmployee(String id);
	
	/**
	 * 创建或编辑账号
	 * @param id 工号
	 * @param name 名称
	 * @param device 专用设备
	 */
    public void persistentEmployeeBase(String id, String name, String device);
	
    /**
     * 获取员工信息列表
     * @param params 查询参数
     * @return 员工实体类
     */
	public PageableSearchBaseEntity<EmployeeFullNameEntity> getEmployeesByIdAndNameAndSpecialDevice(
			EmployeePageableSearchParam params);

	
}
