package com.dtelec.icmes.information.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dtelec.icmes.information.repository.IDeviceRepository;
import com.dtelec.icmes.information.repository.dao.IDeviceDao;
import com.dtelec.icmes.information.repository.entity.DeviceBaseEntity;
import com.dtelec.icmes.information.repository.entity.DevicePhotoEntity;
import com.dtelec.icmes.information.repository.entity.DeviceSpecDataEntity;
import com.dtelec.icmes.information.repository.entity.PageableSearchBaseEntity;
import com.dtelec.icmes.information.repository.param.DevicePageableSearchParam;
import com.dtelec.icmes.information.repository.param.DevicePageableSearchResultParam;
import com.dtelec.icmes.information.repository.param.DeviceSpecDataParam;

/**
 * 设备持久层实现类
 * @author 张瑞晗 戴常怡
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

	/**
	 * 通过设备类型标识符查询设备
	 */
	@Override
	public List<DeviceBaseEntity> findDevicesByDeviceCategoryId(int deviceCategoryId) {
		return dao.findDevicesByDeviceCategoryId(deviceCategoryId);
	}

	/**
	 * 通过工艺系统标识符查询设备
	 */
	@Override
	public List<DeviceBaseEntity> findDevicesByProcessId(int processId) {
		return dao.findDevicesByProcessId(processId);
	}

	/**
	 * 通过位置标识符查询设备
	 */
	@Override
	public List<DeviceBaseEntity> findDevicesByLocationId(int locationId) {
		return dao.findDevicesByLocationId(locationId);
	}

	/**
	 * 通过厂商标识符查询设备
	 */
	@Override
	public List<DeviceBaseEntity> findDevicesByVendorId(int vendorId) {
		return dao.findDevicesByVendorId(vendorId);
	}

 	
	/**
	 * 根据设备id查看设备
	 */
	@Override
	public DeviceBaseEntity getDeviceById(int id) {
		return dao.getDeviceById(id);
	}
	
	/**
	 * 根据设备id查看设备照片列表
	 */
	@Override
	public List<DevicePhotoEntity> getDevicePhotosByDeviceId(int id) {
		return dao.getDevicePhotosByDeviceId(id);
	}
	
	/**
	 * 根据设备id查看相关设备规格ids
	 */
	@Override
	public List<Integer> getSpecModelDataIds(int id) {
		return dao.getSpecModelDataIds(id);
	}
	
	/**
	 * 新建设备
	 */
	@Override
	public void createDevice(DeviceBaseEntity entity) {
		dao.createDevice(entity);
	}

	/**
	 * 创建设备相关规格参数
	 */
	@Override
	public void addSpecaDataForDevice(int deviceId, List<DeviceSpecDataEntity> deviceSpecDataEntites) {
		dao.addSpecaDataForDevice(deviceId,deviceSpecDataEntites);
	}

	/**
	 * 添加照片
	 */
	@Override
	public void addPhotoForDevice(int deviceId, List<DevicePhotoEntity> devicePhotoLists) {
		dao.addPhotoForDevice(deviceId,devicePhotoLists);
	}
	
	/**
	 * 统计符合条件的设备数量
	 */
	@Override
	public int countDeviceASS(int id) {
		//定义返回的returnCount
		int returnCount = 1;
		//获取是不是叶子，最后一级，为0是
		int countEnd = dao.countDeviceIfEnd(id);
		//如果返回0则可以删除
		if(countEnd == 0) {
			returnCount = 0;
		}
		return returnCount;
	}
	
	/**
	 * 删除设备
	 */
	@Override
	public void deleteDevice(int id) {
		dao.deleteDeviceByDeviceId(id);
	}

	/**
	 * 编辑设备
	 */
	@Override
	public void updateDevice(DeviceBaseEntity entity) {
		dao.updateDevice(entity);
	}

	/**
	 * 通过设备标识符删除规格数据和照片
	 */
	@Override
	public void deleteSpecDataAndPhotoForDeviceByDeviceId(int id) {
		dao.deleteSpecDataAndPhotoForDeviceByDeviceId(id);
	}
}
