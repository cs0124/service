package com.dtelec.icmes.information.service;

import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtelec.icmes.common.error.IcmesBusinessException;
import com.dtelec.icmes.common.error.IcmesErrorTypeEnum;
import com.dtelec.icmes.information.repository.IVendorRepository;
import com.dtelec.icmes.information.repository.entity.VendorEntity;
import com.dtelec.icmes.information.service.annotation.CommandAction;
import com.dtelec.icmes.information.service.command.VendorCreateCommand;
import com.dtelec.icmes.information.service.command.VendorDeleteCommand;
import com.dtelec.icmes.information.service.command.VendorUpdateCommand;
import com.dtelec.icmes.information.service.core.ICommandHandler;
import com.dtelec.icmes.information.service.model.VendorModel;

@Service
public class VendorCommandHandler implements ICommandHandler{
	@Autowired
	IVendorRepository vendorRepo;
	
	/**
	 * 新增厂商信息
	 * @param command
	 * @throws IcmesBusinessException 
	 */
	@CommandAction
	public void createVendor(VendorCreateCommand command) throws IcmesBusinessException{
		VendorModel model = command.getModel();
		if(model != null) {
			try {
				vendorRepo.addVendor(model.covert());
			} catch (Exception e) {

				throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_VENDOR_REINSERT_ERROR,"Repeat Addition");
			}

		}
	}
	
	/**
	 * 修改厂商信息
	 * @param command
	 * @throws IcmesBusinessException 
	 */
	@CommandAction
	public void updateVendorDetail(VendorUpdateCommand command) throws IcmesBusinessException{
		VendorModel model = command.getModel();
		if(model != null) {
			//通过自增Id查询是否存在此厂商(供应商)
			VendorEntity entity = vendorRepo.geVendorById(model.getId());
			if (entity == null) {
				throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_VENDOR_ISNULL, "This vendor does not exist." );
			}
			String modelVersion = StringUtils.trimToNull(model.getVersionTag());
			String entityVersion = StringUtils.trimToNull(entity.getVersionTag());
			//Version判断传入VersionTag与数据库里的版本是否一致
			if (modelVersion != null && modelVersion.equalsIgnoreCase(entityVersion)) {
				model.setVersionTag(UUID.randomUUID().toString());
				vendorRepo.updateVendor(model.covert());
			}
			else {
				throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_VENDOR_VERSIONTAGERRORL, "vertionTag Error");
			}
		}
	}
	/**
	 * 删除厂商信息
	 * @param command
	 * @throws IcmesBusinessException 
	 */
	@CommandAction
	public void deleteVendorDetail(VendorDeleteCommand command) throws IcmesBusinessException {
		Integer id = command.getVendorId();
		//通过厂商自增id查询关联台账表中是否存在此厂商，如果存在需要先删除关联表数据
		
		
		//通过厂商自增Id查询数据库里是否存在此厂商
		VendorEntity entity = vendorRepo.geVendorById(id);
		if (entity == null) {
			throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_VENDOR_ISNULL, "This vendor does not exist.");
		}
		vendorRepo.delVendor(id);
	}
}
