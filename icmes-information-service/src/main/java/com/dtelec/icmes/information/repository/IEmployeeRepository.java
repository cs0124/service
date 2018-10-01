package com.dtelec.icmes.information.repository;

import com.dtelec.icmes.information.repository.entity.EmployeeEntity;
import com.dtelec.icmes.information.repository.entity.EmployeeFullNameEntity;
import com.dtelec.icmes.information.repository.entity.PageableSearchBaseEntity;
import com.dtelec.icmes.information.repository.param.EmployeePageableSearchParam;

public interface IEmployeeRepository {
	/**
	 * 通过员工工号获取员工信息
	 * @param id
	 * @return
	 */
	public EmployeeEntity getEmployeeById(String id);
	
	/**
	 * 修改员工信息
	 * @param entity
	 */
	public void updateEmployee(EmployeeEntity entity);
	
	/**
	 * 创建员工信息
	 * @param entity
	 */
	public void createEmployee(EmployeeEntity entity);
	
	/**
	 * 删除员工信息
	 * @param entity
	 */
	public void deleteEmployee(String id);
	
	/**
	 * 创建或编辑账号
	 * @param id
	 * @param name
	 * @param device
	 */
    public void persistentEmployeeBase(String id, String name, String device);
	
    /**
     * 获取员工信息列表
     * @param params
     * @return
     */
	public PageableSearchBaseEntity<EmployeeFullNameEntity> getEmployeesByIdAndNameAndSpecialDevice(
			EmployeePageableSearchParam params);

	
}
