package com.dtelec.icmes.information.service;

import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtelec.icmes.common.error.IcmesBusinessException;
import com.dtelec.icmes.common.error.IcmesErrorTypeEnum;
import com.dtelec.icmes.information.repository.IEmployeeRepository;
import com.dtelec.icmes.information.repository.entity.EmployeeEntity;
import com.dtelec.icmes.information.service.annotation.CommandAction;
import com.dtelec.icmes.information.service.client.AccountServiceClient;
import com.dtelec.icmes.information.service.command.EmployeeCreatetCommand;
import com.dtelec.icmes.information.service.command.EmployeeDeleteCommand;
import com.dtelec.icmes.information.service.command.EmployeePersistentCommand;
import com.dtelec.icmes.information.service.command.EmployeeUpdateCommand;
import com.dtelec.icmes.information.service.core.ICommandHandler;
import com.dtelec.icmes.information.service.model.AccountBaseModel;
import com.dtelec.icmes.information.service.model.EmployeeModel;

@Service
public class EmployeeCommandHandler implements ICommandHandler {

	@Autowired
	IEmployeeRepository employeeRepo;
	
	@Autowired
	AccountServiceClient accountClient;
	
	/**
	 * 修改员工信息
	 * @param command
	 * @throws IcmesBusinessException
	 */
	@CommandAction
	public void updateEmployeeDetail(EmployeeUpdateCommand command ) throws IcmesBusinessException {
		EmployeeModel model = command.getModel();
		
		if (model != null) {
			//通过员工工号查询数据库里是否存在此员工
			EmployeeEntity entity = employeeRepo.getEmployeeById(model.getId());
			if (entity == null) {
				throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_EMPLOYEE_UPDATEEMPLOYEE_ISNULL, "该员工不存在");
			}
			String modelVersion = StringUtils.trimToNull(model.getVersionTag());
			String entityVersion = StringUtils.trimToNull(entity.getVersionTag());
			//Version判断传入VersionTag与数据库里的版本是否一致
			if (modelVersion != null && modelVersion.equalsIgnoreCase(entityVersion)) {
				model.setVersionTag(UUID.randomUUID().toString());
				employeeRepo.updateEmployee(model.covert());	
			}
			else {
				throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_EMPLOYEE_VERSIONTAGERROR, "vertionTag 错误");
			}
		}
	}
	
	/**
	 * 创建员工信息
	 * @param command
	 * @throws IcmesBusinessException
	 */
	@CommandAction
	public void createEmployee(EmployeeCreatetCommand command ) throws IcmesBusinessException {
		EmployeeModel model = command.getModel();
	    if (model != null) {
	    	//通过员工工号查询数据库里是否存在此员工
	    	EmployeeEntity entity = employeeRepo.getEmployeeById(model.getId());
			if (entity != null) {
				throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_EMPLOYEE_CREATEEMPLOYEE_ISNOTNULL, "该员工已存在");
			}
			
			employeeRepo.createEmployee(model.covert());	
	    }
	}
	
	/**
	 * 删除员工信息
	 * @param command
	 * @throws IcmesBusinessException
	 */
	@CommandAction
	public void deleteEmployee(EmployeeDeleteCommand command ) throws IcmesBusinessException {
		String id = command.getEmployeeId();
		if (id == null) {
			throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_EMPLOYEE_DELETE_ID_ISNULL, "员工工号不能为空");
		}
		//通过员工工号查询数据库里是否存在此员工
		AccountBaseModel account = accountClient.getAccountInfo(id);
		if (account != null) {
			String employeeId = account.getEmployeeId();
			if (id.equalsIgnoreCase(employeeId)) {
				throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_EMPLOYEE_DONT_DELETE_WITH_ACCOUNT, "不能删除带账号的员工");	
			}
		}
		EmployeeEntity entity = employeeRepo.getEmployeeById(id);
		if (entity == null) {
			throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_EMPLOYEE_UPDATEEMPLOYEE_ISNULL, "该员工不存在");
		}
		employeeRepo.deleteEmployee(id);
	}
	
	/**
	 * 创建账号
	 * @param command
	 * @throws IcmesBusinessException
	 */
	@CommandAction
	public void persistentEmployee(EmployeePersistentCommand command) {
		String id = command.getEmployeeId();
		String name = command.getEmployeeName();
		//专用设备号
		String device = command.getSpecialDevice();
		
		employeeRepo.persistentEmployeeBase(id, name, device);
	}
	
}
