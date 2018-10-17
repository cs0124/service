package com.dtelec.icmes.information.repository;

import com.dtelec.icmes.information.repository.entity.DeviceValueEntity;
import com.dtelec.icmes.information.repository.entity.PageableSearchBaseEntity;
import com.dtelec.icmes.information.repository.param.DeviceValueDetailPageableSearchParam;


/**
 * 设备净值 Repository interface
 * 作者：孔轩
 */
public interface IDeviceValueRepository {
     /**
     * 创建设备净值信息
     * @param entity 创建实体
     */
    public void createDeviceValue(DeviceValueEntity entity);

     /**
     * 修改设备净值信息
     * @param entity 修改实体
     */
    public void updateDeviceValue(DeviceValueEntity entity);

    /**
     * 删除设备净值信息
     * @param id 净值信息序号
     */
    public void deleteDeviceValue(int id);

    /**
     * 查询传入的位置信息版本号
     * @param int 查询净值信息序号
     * @return 净值信息版本号
     */
    public String fetchDeviceValueVersionTag(int id);

    /**
     * 计算设备台账已录入的设备总原值的总和
     * @return 设备总原值总和
     */
    public Double computeAllGrossOrgValueTotal();

    /**
     * 获取设备净值详情
     * @param id 查询id
     * @return 设备净值详情
     */
    public DeviceValueEntity getDeviceValueDetail(int id);

    /**
     * 通过条件获取设备净值详情
     * @param param 查询参数     
     * @return 设备净值详情集合
     */
    public PageableSearchBaseEntity<DeviceValueEntity> getDeviceValues(DeviceValueDetailPageableSearchParam param);

    /**
     * 获取设备净值数量统计
     * @return 设备净值数量
     */
    public int getDeviceValuesCount();
}