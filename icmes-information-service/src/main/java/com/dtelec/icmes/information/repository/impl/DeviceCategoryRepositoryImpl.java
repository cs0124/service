package com.dtelec.icmes.information.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dtelec.icmes.information.repository.IDeviceCategoryRepository;
import com.dtelec.icmes.information.repository.dao.IDeviceCategoryDao;
import com.dtelec.icmes.information.repository.entity.DeviceCategoryBaseEntity;
import com.dtelec.icmes.information.repository.entity.DeviceCategorySpecDataEntity;
import com.dtelec.icmes.information.repository.entity.PageableSearchBaseEntity;
import com.dtelec.icmes.information.repository.entity.SpecDataEntity;
import com.dtelec.icmes.information.repository.param.DeviceCategoryPageableSearchParam;

/**
 * 设备类型持久层
 * @author schi
 *
 */
@Repository
public class DeviceCategoryRepositoryImpl implements IDeviceCategoryRepository {

	@Autowired
	private IDeviceCategoryDao deviceCategoryDao;
	
	/**
	 * 规格模版数据标识符
	 */
	@Override
	public void createDeviceCategory(DeviceCategoryBaseEntity entity) {
		deviceCategoryDao.createDeviceCategory(entity);
	}

	
	/**
	 *  为设备类型添加规格数据
	 */
	@Override
	public void addSpecDataForDeviceCategory(int deviceCategoryId, int[] specDataIds) {
		if (specDataIds != null) {
			List<Integer> specDataIdList = new ArrayList<>();
			for (int specDataId : specDataIds) {
				specDataIdList.add(specDataId);
			}
			
			deviceCategoryDao.addSpecDataForDeviceCategory(deviceCategoryId, specDataIdList);			
		}
		
	}

	
	/**
	 * 通过标识符获取设备详细信息
	 */
	@Override
	public DeviceCategoryBaseEntity getDeviceCategoryById(int id) {
		return deviceCategoryDao.getDeviceCategoryById(id);
	}

	
	/**
	 * 通过标识符获取规格数据
	 */
	@Override
	public List<SpecDataEntity> getSpecData(int id) {
		return deviceCategoryDao.getSpecData(id);
	}


	@Override
	public void updateDeviceCategory(DeviceCategoryBaseEntity entity) {
		deviceCategoryDao.updateDeviceCategory(entity);
	}

	
	/**
	 * 通过设备类型标识符删除规格数据
	 */
	@Override
	public void deleteSpecDataForDeviceCategoryByDeviceCategoryId(int DeviceCategoryId) {
		deviceCategoryDao.deleteSpecDataForDeviceCategoryByDeviceCategoryId(DeviceCategoryId);
	}


	/**
	 * 删除设备类型
	 */
	@Override
	public void deleteDeviceCategory(int id) {
		deviceCategoryDao.deleteDeviceCategory(id);
	}


	/**
	 * 设备类型列表
	 */
	@Override
	public PageableSearchBaseEntity<DeviceCategoryBaseEntity> getDeviceCategorys(
			DeviceCategoryPageableSearchParam params) {
		PageableSearchBaseEntity<DeviceCategoryBaseEntity> entity = new PageableSearchBaseEntity<DeviceCategoryBaseEntity>();
		List<DeviceCategoryBaseEntity> lists = deviceCategoryDao.getDeviceCategorys(params);
		int totalCount = deviceCategoryDao.getDeviceCategoryCount(params);
		//set返回值
		entity.setTotalCount(totalCount);
		entity.setItems(lists);
		return entity;
	}
	
	/**
	 * 通过标识符数组获取规格数据
	 * @return 
	 */
	@Override
	public List<DeviceCategorySpecDataEntity> getSpecDataListByDeviceCategroyIds(List<Integer> deviceCategoryIds) {
	    return deviceCategoryDao.getSpecDataListByDeviceCategroyIds(deviceCategoryIds);	
	}


	/**
	 * 获取所有规格类型和数据模版
	 */
	@Override
	public List<SpecDataEntity> getAllSpecData() {
		return deviceCategoryDao.getAllSpecData();
	}


}
