package com.dtelec.icmes.information.service;

import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtelec.icmes.common.error.IcmesBusinessException;
import com.dtelec.icmes.common.error.IcmesErrorTypeEnum;
import com.dtelec.icmes.information.repository.IProcessRepository;
import com.dtelec.icmes.information.repository.entity.ProcessEntity;
import com.dtelec.icmes.information.service.annotation.CommandAction;
import com.dtelec.icmes.information.service.command.ProcessCreateCommand;
import com.dtelec.icmes.information.service.command.ProcessDeleteCommand;
import com.dtelec.icmes.information.service.command.ProcessUpdateCommand;
import com.dtelec.icmes.information.service.command.ProcessValidateCommand;
import com.dtelec.icmes.information.service.core.ICommandHandler;
import com.dtelec.icmes.information.service.model.ProcessModel;

/**
 * 工艺业务层
 */
@Service
public class ProcessCommandHandler implements ICommandHandler {

	/**
	 * 工艺持久层接口
	 */
	@Autowired
	IProcessRepository processRepo;
	
	/**
	 * 新建工艺信息
	 * @param command 新建command
	 * @throws IcmesBusinessException  抛出的异常
	 */
	@CommandAction
	public void createProcess(ProcessCreateCommand command ) throws IcmesBusinessException{
		ProcessModel model = command.getModel();
		
	    if (model != null) {
//	    	//通过工艺编号查询数据库里是否存在工艺
//			ProcessEntity entity = processRepo.getProcessByCode(model.getCode());
//			if (entity != null) {
//				throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_PROCESS_CREATEPROCESS_ISNOTNULL, "工艺编号已存在");
//			}
	    	try {
	    		processRepo.createProcess(model.covert());	
	    		
	    	}catch(Exception e){
	    		throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_PROCESS_CREATEPROCESS_ISNOTNULL, "工艺编号已存在");
	    	}
	    }
	}
	
	
	/**
	 * 编辑工艺信息
	 * @param command 编辑command
	 * @throws IcmesBusinessException 抛出的异常
	 */
	@CommandAction
	public void updateProcess(ProcessUpdateCommand command ) throws IcmesBusinessException {
		ProcessModel model = command.getModel();
		
		if (model != null) {
			//通过标识符查询数据库里是否存在工艺
			ProcessEntity entity = processRepo.getProcessById(model.getId());
			if (entity == null) {
				throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_PROCESS_UPDATEPROCESS_ISNULL, "该工艺不存在或已删除");
			}
			String modelVersion = StringUtils.trimToNull(model.getVersionTag());
			String entityVersion = StringUtils.trimToNull(entity.getVersionTag());
			//Version判断传入VersionTag与数据库里的版本是否一致
			if (modelVersion != null && modelVersion.equalsIgnoreCase(entityVersion)) {
				model.setVersionTag(UUID.randomUUID().toString());
				processRepo.updateProcess(model.covert());	
			}
			else {
				throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_PROCESS_VERSIONTAGERROR, "vertionTag错误");
			}
		}
	}
	
	
	/**
	 * 删除工艺信息
	 * @param command 删除command
	 * @throws IcmesBusinessException 抛出的异常
	 */
	@CommandAction
	public void deleteProcess(ProcessDeleteCommand command ) throws IcmesBusinessException {
		int id = command.getId();
		
		//通过标识符查询数据库里是否存在工艺
		ProcessEntity entity = processRepo.getProcessById(id);
		if (entity == null) {
			throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_PROCESS_UPDATEPROCESS_ISNULL, "该工艺不存在或已删除");
		}
		processRepo.deleteProcess(id);
	}
	
	
	/**
	 * 验证工艺编号是否存在
	 * @param command 验证command
	 * @throws IcmesBusinessException 抛出的异常
	 */
	@CommandAction
	public void validateCode(ProcessValidateCommand command) throws IcmesBusinessException {
		ProcessModel model = command.getModel();
		
		if(model != null) {
			//通过工艺编号查询数据库是否存在
			ProcessEntity entity = processRepo.getProcessByCode(model.getCode());
			if (entity != null) {
				throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_PROCESS_CREATEPROCESS_ISNOTNULL, "工艺编号已存在");
			}
		}
	}
	
}

