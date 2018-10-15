package com.dtelec.icmes.information.repository;

import java.util.List;

import com.dtelec.icmes.information.repository.entity.PageableSearchBaseEntity;
import com.dtelec.icmes.information.repository.param.DevicePageableSearchParam;
import com.dtelec.icmes.information.repository.param.DevicePageableSearchResultParam;
import com.dtelec.icmes.information.repository.param.DeviceSpecDataParam;

/**
 * 设备持久层接口
 * 
 * @author 张瑞晗
 *
 */
public interface IDeviceRepository {
    /**
     * 查询设备列表
     * @return 设备列表数据
     */
    public PageableSearchBaseEntity<DevicePageableSearchResultParam> searchDeviceColl(DevicePageableSearchParam param);
    /**
     * 查询设备规格列表
     * @return 设备规格列表
     */
    public List<DeviceSpecDataParam> searchDeviceSpecColl(List<Integer> ids);
}
