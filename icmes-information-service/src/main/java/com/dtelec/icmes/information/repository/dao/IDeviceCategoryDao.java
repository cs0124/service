package com.dtelec.icmes.information.repository.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.dtelec.icmes.information.repository.entity.DeviceCategoryBaseEntity;
import com.dtelec.icmes.information.repository.entity.DeviceCategorySpecDataEntity;
import com.dtelec.icmes.information.repository.entity.SpecDataEntity;
import com.dtelec.icmes.information.repository.param.DeviceCategoryPageableSearchParam;

/**
 * 设备类型dao接口
 * @author schi
 *
 */
@Mapper
public interface IDeviceCategoryDao {
    
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
	void addSpecDataForDeviceCategory(@Param("deviceCategoryId") int deviceCategoryId, @Param("specDataIds") List<Integer> specDataIds);

	/**
	 * 通过标识符获取设备详细信息
	 * @param id 设备标识符
	 * @return 设备类型实体类
	 */
	DeviceCategoryBaseEntity getDeviceCategoryById(@Param("id") int id);

	/**
	 * 通过标识符获取规格数据
	 * @param id 设备标识符
	 * @return 规格数据实体类
	 */
	List<SpecDataEntity> getSpecData(@Param("id") int id);


	/**
	 * 编辑设备类型
	 * @param entity 设备类型实体类
	 */
	void updateDeviceCategory(@Param("entity") DeviceCategoryBaseEntity entity);

	/**
	 *通过设备类型标识符删除规格数据
	 * @param deviceCategoryId 设备类型标识符
	 */
	void deleteSpecDataForDeviceCategoryByDeviceCategoryId(@Param("deviceCategoryId") int deviceCategoryId);

	/**
	 * 删除设备类型
	 * @param id 设备类型标识符
	 */
	void deleteDeviceCategory(@Param("id") int id);
	
	/**
	 * 设备类型列表
	 * @param params 查询参数
	 * @return 设备类型集合
	 */
	List<DeviceCategoryBaseEntity> getDeviceCategorys(@Param("param") DeviceCategoryPageableSearchParam params);

	/**
	 * 设备类型列表总记录数
	 * @param params 查询参数
	 * @return 总数
	 */
	int getDeviceCategoryCount(@Param("param") DeviceCategoryPageableSearchParam params);

	/**
	 * 通过标识符数组获取规格数据
	 * @param deviceCategoryIds 标识符数组
	 * @return 
	 */
	List<DeviceCategorySpecDataEntity> getSpecDataListByDeviceCategroyIds(@Param("deviceCategoryIds") List<Integer> deviceCategoryIds);

	/**
	 * 获取所有规格类型和数据模版
	 * @return 规格类型和数据模版集合
	 */
	List<SpecDataEntity> getAllSpecData();
	
	
	/**
	 * 根据设备类型获取规格类型和数据模版
	 * @return 设备类型获取规格类型和数据模版集合
	 */
	List<SpecDataEntity> getDeviceCategorySpecData(@Param("deviceCategoryId") int deviceCategoryId);
}
