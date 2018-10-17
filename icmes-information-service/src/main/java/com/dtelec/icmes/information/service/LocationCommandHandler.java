package com.dtelec.icmes.information.service;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.dtelec.icmes.common.error.IcmesBusinessException;
import com.dtelec.icmes.common.error.IcmesErrorTypeEnum;
import com.dtelec.icmes.information.repository.IDeviceRepository;
import com.dtelec.icmes.information.repository.ILocationRepository;
import com.dtelec.icmes.information.repository.entity.DeviceBaseEntity;
import com.dtelec.icmes.information.repository.entity.LocationEntity;
import com.dtelec.icmes.information.service.annotation.CommandAction;
import com.dtelec.icmes.information.service.command.LocationCreateCommand;
import com.dtelec.icmes.information.service.command.LocationDeleteCommand;
import com.dtelec.icmes.information.service.command.LocationUpdateCommand;
import com.dtelec.icmes.information.service.core.ICommandHandler;
import com.dtelec.icmes.information.service.model.LocationModel;
import com.netflix.discovery.converters.Auto;

/**
 * Location Command Handler
 * 作者：孔轩
 */
@Service
public class LocationCommandHandler implements ICommandHandler {
    @Autowired
	ILocationRepository locationRepo;

	@Autowired
	IDeviceRepository deviceRepo;
	

    /**
	 * 位置信息新增
	 * @param command 位置新增Command
	 * @throws IcmesBusinessException 异常
	 */
	@CommandAction
	public void createLocationDetail(LocationCreateCommand command) throws IcmesBusinessException {
		//给entity赋值
		LocationModel model = command.getModel();
		if(model != null) {
			LocationEntity entity = new LocationEntity();
			entity.setId(model.getId());
			entity.setCode(model.getCode());
			entity.setName(model.getName());
			entity.setParentId(model.getParentId());
			
			try {
				//调用持久层
				locationRepo.createLocation(entity);
			}
			catch(DuplicateKeyException e) {
				throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_LOCATION_REINSERT_ERROR, "不能重复新增！");
			}
		}
		else {
			throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_LOCATION_INSERTLOCATION_ERROR, "新增位置信息错误，请刷新后再操作！");
		}		
	}
	
    
    /**
	 * 位置信息修改
	 * @param command 位置信息修改Command
	 * @throws IcmesBusinessException 异常
	 */
    @CommandAction
    public void updateLocationDetail(LocationUpdateCommand command) throws IcmesBusinessException {
		//给entity赋值
		LocationModel model = command.getModel();
		if(model != null) {
			LocationEntity entity = new LocationEntity();
			entity.setId(model.getId());
			entity.setCode(model.getCode());
			entity.setName(model.getName());
			entity.setParentId(model.getParentId());
			entity.setVersionTag(model.getVersionTag());

			String versionTag = StringUtils.trimToNull(model.getVersionTag());
			//调用持久层
			String currentVersionTag = StringUtils.trimToNull(locationRepo.fetchLocationVersionTag(entity));
			
			//进行版本控制检测
			if(versionTag != null && versionTag.equals(currentVersionTag)) {
				entity.setVersionTag(UUID.randomUUID().toString());
				locationRepo.updateLocation(entity);
			}
			else {
				throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_LOCATION_UPDATEVERSION_ERROR,
						"当前数据不是最新版本，请刷新后再操作！");
			}
		}
		else {
			throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_LOCATION_UPDATELOCATION_ERROR,
						"修改位置新失败，请刷新后再操作！");
		}		
	}

	
	/**
	 * 位置信息删除
	 * @param command 位置信息删除Command
	 * @throws IcmesBusinessException 异常
	 */
	@CommandAction
	public void deleteLocationDetail(LocationDeleteCommand command) throws IcmesBusinessException {
		LocationModel model = command.getModel();
		if(model != null) {
			LocationEntity entity = new LocationEntity();
			entity.setId(model.getId());
			//查询是否为子叶，如果为子叶返回数值为0
			int count = locationRepo.countLocationDevice(entity);
			//查询是否与之关联的设备数量
			List<DeviceBaseEntity>  devices = deviceRepo.findDevicesByLocationId(entity.getId());

			// 如果返回的是0则可以删除，即为叶子而且无用户关联
			if (count == 0 && devices.isEmpty()) {
				locationRepo.deleteLocation(entity);
			} 
			else {
				throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_LOCATION_DELETELOCATION_HASCHILD);
			}
		}
		else {
			throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_LOCATION_DELETELOCATION_NOFOUND_ID);
		}
		

	}
	
}
