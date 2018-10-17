package com.dtelec.icmes.information.service;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import com.dtelec.icmes.common.error.IcmesBusinessException;
import com.dtelec.icmes.common.error.IcmesErrorTypeEnum;
import com.dtelec.icmes.information.repository.IDeviceCategoryRepository;
import com.dtelec.icmes.information.repository.IDeviceRepository;
import com.dtelec.icmes.information.repository.entity.DeviceBaseEntity;
import com.dtelec.icmes.information.repository.entity.DeviceCategoryBaseEntity;
import com.dtelec.icmes.information.service.annotation.CommandAction;
import com.dtelec.icmes.information.service.command.DeviceCategoryCreateCommand;
import com.dtelec.icmes.information.service.command.DeviceCategoryDeleteCommand;
import com.dtelec.icmes.information.service.command.DeviceCategoryUpdateCommand;
import com.dtelec.icmes.information.service.core.ICommandHandler;
import com.dtelec.icmes.information.service.model.DeviceCategoryModel;

/**
 * 设备类型业务层
 * @author schi
 *
 */
@Service
public class DeviceCategoryCommandHandler implements ICommandHandler {

	@Autowired
	private IDeviceCategoryRepository deviceCategoryRepo;
	
	@Autowired
	private IDeviceRepository deviceRepo;
	/**
	 * 设备类型新建
	 * @param command
	 * @throws IcmesBusinessException 
	 */
	@CommandAction
	public void createDeviceCategory(DeviceCategoryCreateCommand command) throws IcmesBusinessException {
		DeviceCategoryModel model = command.getModel();
		
		if (model != null) {
			DeviceCategoryBaseEntity entity = model.convert();
			try {
	    		
				deviceCategoryRepo.createDeviceCategory(entity);
				
	    	}catch(DuplicateKeyException e){
	    		throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_DEVICECATEGORY_CREATEDEVICEVATEGORY_ISNOTNULL, "设备类型编号已存在");
	    	}
			
			deviceCategoryRepo.addSpecDataForDeviceCategory(entity.getId(), command.getRelatedSpceDataIds());
		}
		
	}
	
	
	/**
	 * 设备类型编辑
	 * @param command
	 * @throws IcmesBusinessException 
	 */
	@CommandAction
	public void updateDeviceCategory(DeviceCategoryUpdateCommand command) throws IcmesBusinessException {
		DeviceCategoryModel model = command.getModel();
		
		if (model != null) {
			DeviceCategoryBaseEntity entity = deviceCategoryRepo.getDeviceCategoryById(model.getId());
			if (entity == null) {
				throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_DEVICECATEGORY_CREATEDEVICEVATEGORY_ISNULL, "该设备类型不存在或已删除");
			}
			
			String modelVersion = StringUtils.trimToNull(model.getVersionTag());
			String entityVersion = StringUtils.trimToNull(entity.getVersionTag());
			//Version判断传入VersionTag与数据库里的版本是否一致
			if (modelVersion != null && modelVersion.equalsIgnoreCase(entityVersion)) {
				model.setVersionTag(UUID.randomUUID().toString());
				
				deviceCategoryRepo.updateDeviceCategory(model.convert());
			}
			else {
				throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_PROCESS_VERSIONTAGERROR, "vertionTag错误");
			}

			deviceCategoryRepo.deleteSpecDataForDeviceCategoryByDeviceCategoryId(model.getId());
			
			deviceCategoryRepo.addSpecDataForDeviceCategory(entity.getId(), command.getRelatedSpceDataIds());
		}
		
	}
	
	
	/**
	 * 设备类型删除
	 * @param command
	 * @throws IcmesBusinessException
	 */
	@CommandAction
	public void deleteDeviceCategory(DeviceCategoryDeleteCommand command ) throws IcmesBusinessException {
		int id = command.getId();
		
		DeviceCategoryBaseEntity entity = deviceCategoryRepo.getDeviceCategoryById(id);
		if (entity == null) {
			throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_DEVICECATEGORY_CREATEDEVICEVATEGORY_ISNULL, "该设备类型不存在或已删除");
		}
		
		List<DeviceBaseEntity> devices = deviceRepo.findDevicesByDeviceCategoryId(id);
		if (devices != null && !devices.isEmpty()) {
			throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_DEVICECATEGORY_DELETEDEVICEVATEGORY_ISFAIL, "设备类型与设备有关联，不能删除");
		}
		
		deviceCategoryRepo.deleteDeviceCategory(id);
		
	}
	
	
}
