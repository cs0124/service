package com.dtelec.icmes.information.service;

import java.util.Date;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.dtelec.icmes.common.error.IcmesBusinessException;
import com.dtelec.icmes.common.error.IcmesErrorTypeEnum;
import com.dtelec.icmes.information.repository.IDeviceValueRepository;
import com.dtelec.icmes.information.repository.entity.DeviceValueEntity;
import com.dtelec.icmes.information.service.annotation.CommandAction;
import com.dtelec.icmes.information.service.command.DeviceValueCreateCommand;
import com.dtelec.icmes.information.service.command.DeviceValueDeleteCommand;
import com.dtelec.icmes.information.service.command.DeviceValueUpdateCommand;
import com.dtelec.icmes.information.service.core.ICommandHandler;
import com.dtelec.icmes.information.service.model.DeviceValueModel;

/**
 * 设备净值 Command Handler
 */
@Service
public class DeviceValueCommandHandler implements ICommandHandler {

    @Autowired
    IDeviceValueRepository deviceValueRepo;


    /**
     * 设备净值新增
     * @param command 设备净值新增Command
     * @throws IcmesBusinessException 异常
     */
    @CommandAction
    public void createDeviceValueDetail(DeviceValueCreateCommand command) throws IcmesBusinessException {
        DeviceValueModel model = command.getModel();
        if(model != null) {
            //entity赋值
            DeviceValueEntity entity = new DeviceValueEntity();
            entity.setNetValuePeriod(model.getNetValuePeriod() > 0 ?(new Date(model.getNetValuePeriod())):null );
            entity.setGrossOrgValue(model.getGrossOrgValue());
            entity.setGrossNetValue(model.getGrossNetValue());
            //TODO 等待变更后将创建人ID获取并赋值

            try {
                //调用持久层
                deviceValueRepo.createDeviceValue(entity);
            }
            catch(DuplicateKeyException e) {
				throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_DEVICEVALUE_REINSERT_ERROR);
            }
        }
        else {
            throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_DEVICEVALUE_INSERTDEVICEVALUE_ERROR);
        }
    }


     /**
	 * 设备净值修改
	 * @param command 设备净值修改Command
	 * @throws IcmesBusinessException 异常
	 */
    @CommandAction
    public void updateDeviceValueDetail(DeviceValueUpdateCommand command) throws IcmesBusinessException {
        //给entity赋值
		DeviceValueModel model = command.getModel();
		if(model != null) {
			DeviceValueEntity entity = new DeviceValueEntity();
			entity.setId(model.getId());
            entity.setNetValuePeriod(model.getNetValuePeriod() > 0 ?(new Date(model.getNetValuePeriod())):null );
            entity.setGrossOrgValue(model.getGrossOrgValue());
            entity.setGrossNetValue(model.getGrossNetValue());
            entity.setVersionTag(model.getVersionTag());
            //TODO 等待变更后将修改人ID获取并赋值

			String versionTag = StringUtils.trimToNull(model.getVersionTag());
			//调用持久层
			String currentVersionTag = StringUtils.trimToNull(deviceValueRepo.fetchDeviceValueVersionTag(entity.getId()));
			
			//进行版本控制检测
			if(versionTag != null && versionTag.equals(currentVersionTag)) {
				entity.setVersionTag(UUID.randomUUID().toString());
				deviceValueRepo.updateDeviceValue(entity);
			}
			else {
				throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_DEVICEVALUE_UPDATEVERSION_ERROR);
			}
		}
		else {
			throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_DEVICEVALUE_UPDATEDEVICEVALUE_ERROR);
		}		
    }


    /**
	 * 设备净值删除
	 * @param command 设备净值删除Command
	 * @throws IcmesBusinessException 异常
	 */
	@CommandAction
	public void deleteDeviceValueDetail(DeviceValueDeleteCommand command) throws IcmesBusinessException {
        DeviceValueModel model = command.getModel();
		if(model != null) {
			int deviceValueId = model.getId();
            //TODO 目前设备净值没有业务逻辑需求，待确定后增加能否删除判断逻辑
            int count = 0;

			// 如果返回的是0则可以删除
			if (count == 0) {
				deviceValueRepo.deleteDeviceValue(deviceValueId);
			} 
			else {
				throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_DEVICEVALUE_DELETEDEVICVALUE_HASASSOCIATE);
			}
		}
		else {
			throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_DEVICEVALUE_DELETEDEVICVALUE_NOFOUND_ID);
		}
	}
	
}