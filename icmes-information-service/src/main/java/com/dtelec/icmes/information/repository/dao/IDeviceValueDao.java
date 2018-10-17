package com.dtelec.icmes.information.repository.dao;

import java.util.List;

import com.dtelec.icmes.information.repository.entity.DeviceValueEntity;
import com.dtelec.icmes.information.repository.param.DeviceValueDetailPageableSearchParam;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 设备净值 Dao
 * 作者：孔轩
 */
@Mapper
public interface IDeviceValueDao {

    /**
     * 创建设备净值信息
     * @param entity 创建实体
     */
    void createDeviceValue(@Param("entity") DeviceValueEntity entity);

    /**
     * 修改设备净值信息
     * @param entity 修改实体
     */
    void updateDeviceValue(@Param("entity") DeviceValueEntity entity);

    /**
     * 删除设备净值信息
     * @param id 净值信息序号
     */
    void deleteDeviceValue(@Param("id") int id);

    /**
     * 查询传入的位置信息版本号
     * @param int 查询净值信息序号
     * @return 净值信息版本号
     */
    String fetchDeviceValueVersionTag(@Param("id") int id);

    /**
     * 获取设备净值详情
     * @param id 查询Id
     * @return 设备净值详情
     */
    DeviceValueEntity getDeviceValueDetail(@Param("id") int id);

     /**
     * 获取设备净值
     * @param param 查询参数
     * @return 设备净值集合
     */
    List<DeviceValueEntity> getDeviceValues(@Param("param") DeviceValueDetailPageableSearchParam param);

    /**
     * 计算设备台账已录入的设备总原值的总和
     * @return 设备总原值总和
     */
    Double computeAllGrossOrgValueTotal();

    /**
     * 获取设备净值数量统计
     * @return 总数
     */
    int getDeviceValuesCount();

}