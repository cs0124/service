package com.dtelec.icmes.information.repository;

import java.util.List;

import com.dtelec.icmes.information.repository.entity.DeviceCategoryBaseEntity;
import com.dtelec.icmes.information.repository.entity.DeviceCategorySpecDataEntity;
import com.dtelec.icmes.information.repository.entity.PageableSearchBaseEntity;
import com.dtelec.icmes.information.repository.entity.SpecDataEntity;
import com.dtelec.icmes.information.repository.param.DeviceCategoryPageableSearchParam;

public interface IDeviceCategoryRepository {

	/**
	 * 新建设备类型
	 * @param entity 设备类型实体类
	 */
	void createDeviceCategory(DeviceCategoryBaseEntity entity);
	
	/**
	 * 为设备类型添加规格数据
	 * @param deviceCategoryId 设备类型标识符
	 * @param specDataIds 规格模版数据ids
	 */
	void addSpecDataForDeviceCategory(int deviceCategoryId, int[] specDataIds);

	/**
	 * 通过标识符获取设备详细信息
	 * @param id 标识符
	 * @return 设备类型实体类
	 */
	DeviceCategoryBaseEntity getDeviceCategoryById(int id);

	/**
	 * 通过标识符获取规格数据
	 * @param id 标识符
	 * @return 规格数据实体类
	 */
	List<SpecDataEntity> getSpecData(int id);

	/**
	 * 编辑设备类型
	 * @param entity 设备类型实体类
	 */
	void updateDeviceCategory(DeviceCategoryBaseEntity entity);

	/**
	 * 通过设备类型标识符删除规格数据
	 * @param DeviceCategoryId 设备类型标识符
	 */
	void deleteSpecDataForDeviceCategoryByDeviceCategoryId(int DeviceCategoryId);

	/**
	 * 删除设备信息
	 * @param id 设备类型标识符
	 */
	void deleteDeviceCategory(int id);

	/**
	 * 获取设备类型列表
	 * @param params 查询参数
	 * @return 设备类型实体类
	 */
	PageableSearchBaseEntity<DeviceCategoryBaseEntity> getDeviceCategorys(DeviceCategoryPageableSearchParam params);
	
	/**
	 * 通过标识符数组获取规格数据
	 * @param listIds 标识符数组
	 * @return 规格数据实体类
	 */
	List<DeviceCategorySpecDataEntity> getSpecDataListByDeviceCategroyIds(List<Integer> deviceCategoryIds);

	/**
	 * 获取所有规格类型和数据模版
	 * @return 规格类型和数据模版集合
	 */
	List<SpecDataEntity> getAllSpecData();
	
	
	/**
	 * 根据设备类型获取规格类型和数据模版
	 * @return 设备类型获取规格类型和数据模版集合
	 */
	List<SpecDataEntity> getDeviceCategorySpecData(int deviceCategoryId);

}
