package com.dtelec.icmes.information.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.dtelec.icmes.common.error.IcmesBusinessException;
import com.dtelec.icmes.common.error.IcmesErrorTypeEnum;
import com.dtelec.icmes.information.repository.IDeviceRepository;
import com.dtelec.icmes.information.repository.entity.DeviceBaseEntity;
import com.dtelec.icmes.information.repository.entity.DevicePhotoEntity;
import com.dtelec.icmes.information.repository.entity.DeviceSpecDataEntity;
import com.dtelec.icmes.information.service.annotation.CommandAction;
import com.dtelec.icmes.information.service.command.DeviceCreateCommand;
import com.dtelec.icmes.information.service.command.DeviceDeleteCommand;
import com.dtelec.icmes.information.service.command.DeviceUpdateCommand;
import com.dtelec.icmes.information.service.core.ICommandHandler;
import com.dtelec.icmes.information.service.model.DeviceModel;
import com.dtelec.icmes.information.service.model.DevicePhotoModel;
import com.dtelec.icmes.information.service.model.DeviceSpecDataModel;

/**
 * 设备业务层
 * @author schi
 *
 */
@Service
public class DeviceCommandHandler implements ICommandHandler{

	@Autowired
	private IDeviceRepository deviceRepo;
	
	/**
	 * 新建设备
	 * @param command 新建设备command
	 * @throws IcmesBusinessException 抛出的异常
	 */
	@CommandAction
	public void createDevice(DeviceCreateCommand command) throws IcmesBusinessException {
		DeviceModel model = command.getModel();
		//规格entity转成model
		List<DeviceSpecDataEntity> deviceSpecDataEntites = new ArrayList<>();
		List<DeviceSpecDataModel> deviceSpecDataList = model.getSpecDataList();
		if (deviceSpecDataList != null) {
			for (DeviceSpecDataModel specDataModel : deviceSpecDataList) {
				DeviceSpecDataEntity deviceSpecDataEntity = specDataModel.convert();
				deviceSpecDataEntites.add(deviceSpecDataEntity);
			}
		}
		
		//照片entity转成model
		List<DevicePhotoEntity> devicePhotoLists = new ArrayList<>();
		List<DevicePhotoModel> devicePhotoList = model.getPhotoList();
		if (devicePhotoList != null) {
			for (DevicePhotoModel devicePhoto:devicePhotoList) {
				DevicePhotoEntity devicePhotoEntity = devicePhoto.convert();
				devicePhotoLists.add(devicePhotoEntity);
			}
		}
		
		if (model != null) {
			DeviceBaseEntity entity = model.convert();
	    		
			try {
				
				deviceRepo.createDevice(entity);
				
	    	}catch(DuplicateKeyException e){
	    		throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_DEVICECATEGORY_CREATEDEVICE_ISNOTNULL, "设备编号已存在");
	    	}
		
			deviceRepo.addSpecaDataForDevice(entity.getId(), deviceSpecDataEntites);
			
			deviceRepo.addPhotoForDevice(entity.getId(),devicePhotoLists);
			}
		}
	
	
	/**
	 * 编辑设备
	 * @param command 编辑command
	 * @throws IcmesBusinessException 抛出的异常
	 */ 
	@CommandAction
	public void updateDevice(DeviceUpdateCommand command) throws IcmesBusinessException {
		DeviceModel model = command.getModel();
		//规格entity转成model
		List<DeviceSpecDataEntity> deviceSpecDataEntites = new ArrayList<>();
		List<DeviceSpecDataModel> deviceSpecDataList = model.getSpecDataList();
		if (deviceSpecDataList != null) {
			for (DeviceSpecDataModel specDataModel : deviceSpecDataList) {
				DeviceSpecDataEntity deviceSpecDataEntity = specDataModel.convert();
				deviceSpecDataEntites.add(deviceSpecDataEntity);
			}
		}
		
		//照片entity转成model
		List<DevicePhotoEntity> devicePhotoLists = new ArrayList<>();
		List<DevicePhotoModel> devicePhotoList = model.getPhotoList();
		if (devicePhotoList != null) {
			for (DevicePhotoModel devicePhoto:devicePhotoList) {
				DevicePhotoEntity devicePhotoEntity = devicePhoto.convert();
				devicePhotoLists.add(devicePhotoEntity);
			}
		}
		
		if (model != null) {
			DeviceBaseEntity entity = deviceRepo.getDeviceById(model.getId());
			if (entity == null) {
				throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_DEVICE_UPDATEDEVICE_ISNULL, "该设备不存在或已删除");
			}
		
			String modelVersion = StringUtils.trimToNull(model.getVersionTag());
			String entityVersion = StringUtils.trimToNull(entity.getVersionTag());
			//Version判断传入VersionTag与数据库里的版本是否一致
			if (modelVersion != null && modelVersion.equalsIgnoreCase(entityVersion)) {
				model.setVersionTag(UUID.randomUUID().toString());
				
				deviceRepo.updateDevice(model.convert());
			}
			else {
				throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_PROCESS_VERSIONTAGERROR, "vertionTag错误");
			}
			
			deviceRepo.deleteSpecDataAndPhotoForDeviceByDeviceId(model.getId());
			
			deviceRepo.addSpecaDataForDevice(entity.getId(), deviceSpecDataEntites);
			
			deviceRepo.addPhotoForDevice(entity.getId(),devicePhotoLists);
			}
		}
		
	/**
	 * 设备删除
	 * @param command 删除command
	 * @throws IcmesBusinessException 抛出的异常
	 */
	@CommandAction
	public void deleteDevice(DeviceDeleteCommand command)throws IcmesBusinessException {
		int id = command.getId();
		int count = deviceRepo.countDeviceASS(id);
		//如果返回的是0则可以删除，即为叶子而且无设备关联
		if (count == 0) {
			deviceRepo.deleteDevice(id);
		} else {
			throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_DEVICE_DELETEDEVICE_HASCHILD,
					"当前设备存在子设备或关联设备，不能删除");
		}
	}
}
