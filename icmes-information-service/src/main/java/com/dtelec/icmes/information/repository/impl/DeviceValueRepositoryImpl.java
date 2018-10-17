package com.dtelec.icmes.information.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.dtelec.icmes.information.repository.IDeviceValueRepository;
import com.dtelec.icmes.information.repository.dao.IDeviceValueDao;
import com.dtelec.icmes.information.repository.entity.DeviceValueEntity;
import com.dtelec.icmes.information.repository.entity.PageableSearchBaseEntity;
import com.dtelec.icmes.information.repository.param.DeviceValueDetailPageableSearchParam;

/**
 * 设备净值 Repository Impl
 */
@Repository
public class DeviceValueRepositoryImpl implements IDeviceValueRepository {

    @Autowired
    private IDeviceValueDao deviceValueDao;

    /**
     * 创建设备净值信息
     * @param entity 创建实体
     */
    @Override
    public void createDeviceValue(DeviceValueEntity entity) {
        deviceValueDao.createDeviceValue(entity);
    }


    /**
     * 修改设备净值信息
     * @param entity 修改实体
     */
    @Override
    public void updateDeviceValue(DeviceValueEntity entity) {
        deviceValueDao.updateDeviceValue(entity);
    }


    /**
     * 删除设备净值信息
     * @param id 净值信息序号
     */
    @Override
    public void deleteDeviceValue(int id) {
        deviceValueDao.deleteDeviceValue(id);
    }


    /**
     * 查询传入的位置信息版本号
     * @param int 查询净值信息序号
     * @return 净值信息版本号
     */
    @Override
    public String fetchDeviceValueVersionTag(int id) {
        String versionTag = deviceValueDao.fetchDeviceValueVersionTag(id);

        return versionTag;
    }


    /**
     * 计算设备台账已录入的设备总原值的总和
     * @return 设备总原值总和
     */
    @Override
    public Double computeAllGrossOrgValueTotal() {
        Double allGrossOrgValueTotal = deviceValueDao.computeAllGrossOrgValueTotal();
        return allGrossOrgValueTotal;
    }


    /**
     * 获取设备净值详情
     * @param id 查询id
     * @return 设备净值详情
     */
    @Override
    public DeviceValueEntity getDeviceValueDetail(int id) {
        //获取设备净值详情
        return deviceValueDao.getDeviceValueDetail(id);
    }


   /**
    * 通过条件获取设备净值详情
    * @param param 查询参数
    * @return 设备净值详情集合
    */
    @Override
   public PageableSearchBaseEntity<DeviceValueEntity> getDeviceValues(DeviceValueDetailPageableSearchParam param) {
       PageableSearchBaseEntity<DeviceValueEntity> entity = new  PageableSearchBaseEntity<DeviceValueEntity>();
       //查询集合
       List<DeviceValueEntity> deviceValues = deviceValueDao.getDeviceValues(param);
       //统计条目
       int totalCount = deviceValueDao.getDeviceValuesCount();  
       entity.setTotalCount(totalCount);
       entity.setItems(deviceValues);   

       return entity;
   }




    /**
     * 获取设备净值数量统计
     */
    @Override
    public int getDeviceValuesCount() {
        return deviceValueDao.getDeviceValuesCount();
    }
}