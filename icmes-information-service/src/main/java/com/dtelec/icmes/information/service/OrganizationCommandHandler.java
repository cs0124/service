package com.dtelec.icmes.information.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtelec.icmes.common.error.IcmesBusinessException;
import com.dtelec.icmes.common.error.IcmesErrorTypeEnum;
import com.dtelec.icmes.information.repository.IOrganizationRepository;
import com.dtelec.icmes.information.repository.entity.OrganizationEntity;
import com.dtelec.icmes.information.service.annotation.CommandAction;
import com.dtelec.icmes.information.service.command.OrganizationCreatetCommand;
import com.dtelec.icmes.information.service.command.OrganizationDeleteCommand;
import com.dtelec.icmes.information.service.command.OrganizationUpdateCommand;
import com.dtelec.icmes.information.service.core.ICommandHandler;
import com.dtelec.icmes.information.service.model.OrganizationModel;

@Service
public class OrganizationCommandHandler implements ICommandHandler {

	@Autowired
	IOrganizationRepository orgaRepo;
	
	
	/**
	 * 组织结构新增
	 * @param command 新建组织机构
	 * @throws IcmesBusinessException 抛出的异常
	 */
	@CommandAction
	public void createOrganizationDetail(OrganizationCreatetCommand command) throws IcmesBusinessException {
		//给entity赋值
		OrganizationEntity entity = new OrganizationEntity();
		entity.setId(command.getId());
		entity.setName(command.getName());
		entity.setParentId(command.getParentId());
		entity.setVersionTag(UUID.randomUUID().toString());
		
		int count = orgaRepo.checkOrganization(entity);
		if(count > 0) {
			throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_ORGANIZATION_REINSERT_ERROR, "不能重复新增！");
		}else {
			//调用持久层
			orgaRepo.createOrganization(entity);
		}
	}
	
	
	/**
	 * 组织机构修改
	 * @param command 组织机构修改
	 * @throws IcmesBusinessException 抛出的异常
	 */
	@CommandAction
	public void updateOrganizationDetail(OrganizationUpdateCommand command) throws IcmesBusinessException {
		OrganizationEntity entity = new OrganizationEntity();
		String versionTag = command.getVersionTag();
		entity.setId(command.getId());
		entity.setName(command.getName());
		entity.setParentId(command.getParentId());
		entity.setVersionTag(command.getVersionTag());
		//调用持久层
		OrganizationModel model = orgaRepo.fetchOrganizationVersionTag(entity);
		String currentVersionTag = model.getVersionTag();
		//进行版本控制检测
		if (currentVersionTag == null) {
			currentVersionTag = "";
		}
		if (versionTag.equals(currentVersionTag)) {
			entity.setVersionTag(UUID.randomUUID().toString());
			orgaRepo.updateOrganization(entity);
		} else {
			throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_ORGANIZATION_UPDATEVERSION_ERROR,
					"当前数据不是最新版本，请刷新后再操作！");

		}

	}
	
	
	/**
	 * 组织结构删除
	 * @param command 删除command
	 * @throws IcmesBusinessException 抛出的异常
	 */
	@CommandAction
	public void deleteOrganizationDetail(OrganizationDeleteCommand command) throws IcmesBusinessException {
		OrganizationEntity entity = new OrganizationEntity();
		entity.setId(command.getId());
		int count = orgaRepo.countOrganizationASS(entity);
		// 如果返回的是0则可以删除，即为叶子而且无用户关联
		if (count == 0) {
			orgaRepo.deleteOrganization(entity);
		} else {
			throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_ORGANIZATION_DELETEORGANIZATION_HASCHILD,
					"当前机构存在子机构或关联其他用户，不能删除");
		}

	}
}
