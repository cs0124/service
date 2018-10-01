package com.dtelec.icmes.information.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtelec.icmes.information.repository.IEmployeeRepository;
import com.dtelec.icmes.information.repository.entity.EmployeeEntity;
import com.dtelec.icmes.information.repository.entity.EmployeeFullNameEntity;
import com.dtelec.icmes.information.repository.entity.PageableSearchBaseEntity;
import com.dtelec.icmes.information.repository.param.EmployeePageableSearchParam;
import com.dtelec.icmes.information.service.annotation.QueryAction;
import com.dtelec.icmes.information.service.core.IQueryHandler;
import com.dtelec.icmes.information.service.model.EmployeeModel;
import com.dtelec.icmes.information.service.model.EmployeesCollection;
import com.dtelec.icmes.information.service.query.EmployeeDetailQuery;
import com.dtelec.icmes.information.service.query.EmployeeSearchQuery;

@Service
public class EmployeeQueryHandler implements IQueryHandler {
	
	@Autowired
	IEmployeeRepository employeeRepo;
	
	/**
	 * 获取员工详细信息
	 * @param query
	 * @return EmployeeModel
	 */
	@QueryAction
	public EmployeeModel getEmployeeDetail(EmployeeDetailQuery query) {
		EmployeeModel model = null;
		//通过员工工号查询数据库里是否存在此员工
		EmployeeEntity entity = employeeRepo.getEmployeeById(query.getId());
		if (entity != null) {
		    model = new EmployeeModel();	
			model.fill(entity);
		}

		return model;
	}
	
	/**
	 * 获取员工信息列表
	 * @param query
	 * @return
	 */
	@QueryAction
	public EmployeesCollection getEmployees(EmployeeSearchQuery query) {
		//分页初始化
		int pageNo = query.getPage();
		pageNo = (pageNo < 1) ? 1 : pageNo;
		int pageSize = query.getCount();
		pageSize = (pageSize < 0) ? 0 : pageSize;
		int startIndex = (pageNo - 1) * pageSize;
		
		//给查询参数赋值
		EmployeePageableSearchParam params = new EmployeePageableSearchParam();
		params.setId(query.getId());
		params.setName(query.getName());
		params.setSpecialDevice(query.getSpecialDevice());
		params.setOrganizationId(query.getOrganizationId());
		params.setCategory(query.getCategory());
		params.setWorkType(query.getWorkType());
		Long joinDateStart = query.getJoinDateStart();
		//判断是否填写入职开始时间
		if (joinDateStart == null || joinDateStart < 1) {
			params.setJoinDateStart(null);
		}
		else {
			params.setJoinDateStart(new Date(joinDateStart));
		}
		Long joinDateEnd = query.getJoinDateEnd();
		if (joinDateEnd == null || joinDateEnd < 1) {
			params.setJoinDateEnd(null);
		}
		else {
			params.setJoinDateEnd(new Date(joinDateEnd));
		}
		params.setPageSize(pageSize);
		params.setStartIndex(startIndex);
		params.setOrderBy(query.getOrderBy());
		params.setAscending(query.isAscending());
		
		//查询数据库
		PageableSearchBaseEntity<EmployeeFullNameEntity> entities = employeeRepo
				.getEmployeesByIdAndNameAndSpecialDevice(params);
		//填充返回值
		EmployeesCollection coll = new EmployeesCollection();
		coll.fill(entities, query.getCount());

		return coll;
	}
}
