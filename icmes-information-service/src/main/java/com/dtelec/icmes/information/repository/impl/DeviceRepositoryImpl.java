package com.dtelec.icmes.information.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dtelec.icmes.information.repository.IDeviceRepository;
import com.dtelec.icmes.information.repository.dao.IDeviceDao;
import com.dtelec.icmes.information.repository.entity.PageableSearchBaseEntity;
import com.dtelec.icmes.information.repository.param.DevicePageableSearchParam;
import com.dtelec.icmes.information.repository.param.DevicePageableSearchResultParam;
import com.dtelec.icmes.information.repository.param.DeviceSpecDataParam;

/**
 * 设备持久层实现类
 * 
 * @author 张瑞晗
 *
 */
@Repository
public class DeviceRepositoryImpl implements IDeviceRepository {
	/**
	 * 设备dao注入
	 */
	@Autowired
	private IDeviceDao dao;

	/**
	 * 设备查询列表
	 * @author 张瑞晗
	 * @param DevicePageableSearchParam 设备分页查询参数实体
	 * @return PageableSearchBaseEntity<DevicePageableSearchResultParam> 分页返回设备实体参数
	 */
	@Override
	public PageableSearchBaseEntity<DevicePageableSearchResultParam> searchDeviceColl(DevicePageableSearchParam param) {
		List<DevicePageableSearchResultParam> deviceList = dao.searchDeviceColl(param);
		int deviceListCount = dao.searchDeviceCollCount(param);
		// 分页初始化
		PageableSearchBaseEntity<DevicePageableSearchResultParam> entity = new PageableSearchBaseEntity<>();
		entity.setItems(deviceList);
		entity.setTotalCount(deviceListCount);

		return entity;
	}

	/**
	 * 设备规格查询列表
	 * @author 张瑞晗
	 * @param List<Integer> 设备id列表
	 * @return List<DeviceSpecDataParam> 设备列表
	 */
	@Override
	public List<DeviceSpecDataParam> searchDeviceSpecColl(List<Integer> ids) {
		List<DeviceSpecDataParam> list = dao.searchDeviceSpecDataColl(ids);
		return list;
	}

}
