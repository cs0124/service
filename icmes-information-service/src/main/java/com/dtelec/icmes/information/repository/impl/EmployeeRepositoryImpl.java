package com.dtelec.icmes.information.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dtelec.icmes.information.repository.IEmployeeRepository;
import com.dtelec.icmes.information.repository.dao.IEmployeeDao;
import com.dtelec.icmes.information.repository.entity.EmployeeEntity;
import com.dtelec.icmes.information.repository.entity.EmployeeFullNameEntity;
import com.dtelec.icmes.information.repository.entity.PageableSearchBaseEntity;
import com.dtelec.icmes.information.repository.param.EmployeePageableSearchParam;

@Repository
public class EmployeeRepositoryImpl implements IEmployeeRepository {

	@Autowired
	IEmployeeDao employeeDao;

	/**
	 * 通过id获取员工信息
	 */
	@Override
	public EmployeeEntity getEmployeeById(String id) {
		return employeeDao.findByEmployeeId(id);
	}

	/**
	 * 修改员工信息
	 */
	@Override
	public void updateEmployee(EmployeeEntity entity) {
		employeeDao.updateEmployee(entity);
	}

	/**
	 * 创建员工信息
	 */
	@Override
	public void createEmployee(EmployeeEntity entity) {
		employeeDao.createEmployee(entity);
	}
	
	/**
	 *删除员工信息
	 */
	@Override
	public void deleteEmployee(String id) {
		employeeDao.deleteEmployee(id);
	}
	
	/**
	 *创建账号
	 */
	@Override
	public void persistentEmployeeBase(String id, String name, String device) {
		employeeDao.persistentEmployeeBase(id, name, device);
	}
	
	/**
	 * 获取员工list
	 */
	@Override
	public PageableSearchBaseEntity<EmployeeFullNameEntity> getEmployeesByIdAndNameAndSpecialDevice(
			EmployeePageableSearchParam params) {
		PageableSearchBaseEntity<EmployeeFullNameEntity> entity = new PageableSearchBaseEntity<EmployeeFullNameEntity>();
		List<EmployeeFullNameEntity> fullNameEmployees = employeeDao.getEmployees(params);
		int totalCount = employeeDao.getEmployeesCount(params);
		//set返回值
		entity.setTotalCount(totalCount);
		entity.setItems(fullNameEmployees);
		return entity;
	}


}
