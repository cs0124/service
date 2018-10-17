package com.dtelec.icmes.information.repository;

import java.util.List;

import com.dtelec.icmes.information.repository.entity.DeviceBaseEntity;
import com.dtelec.icmes.information.repository.entity.DevicePhotoEntity;
import com.dtelec.icmes.information.repository.entity.DeviceSpecDataEntity;
import com.dtelec.icmes.information.repository.entity.PageableSearchBaseEntity;
import com.dtelec.icmes.information.repository.param.DevicePageableSearchParam;
import com.dtelec.icmes.information.repository.param.DevicePageableSearchResultParam;
import com.dtelec.icmes.information.repository.param.DeviceSpecDataParam;

/**
 * 设备持久层接口
 * 
 * @author 张瑞晗 戴常怡
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
    
    /**
     * 通过设备类型标识符查询设备
     * @param deviceCategoryId 设备类型标识符
     * @return 设备集合
     */
    public List<DeviceBaseEntity> findDevicesByDeviceCategoryId(int deviceCategoryId);
    
    /**
     * 通过工艺系统标识符查询设备
     * @param processId 工艺标识符
     * @return 设备集合
     */
    public List<DeviceBaseEntity> findDevicesByProcessId(int processId);
    
    /**
     * 通过位置标识符查询设备
     * @param locationId 位置标识符
     * @return 设备集合
     */
	public List<DeviceBaseEntity> findDevicesByLocationId(int locationId);

    /**
     * 通过厂商标识符查询设备
     * @param vendorId 厂商标识符
     * @return 设备集合
     */
    public List<DeviceBaseEntity> findDevicesByVendorId(int vendorId);

	/**
	 * 根据设备id查看设备
	 * @param id
	 * @return
	 * @throws Exception
	 */
    DeviceBaseEntity getDeviceById(int id);
	
	/**
	 * 根据设备id查看设备照片列表
	 * @param id
	 * @return
	 * @throws Exception
	 */
	List<DevicePhotoEntity> getDevicePhotosByDeviceId(int id);
	
	/**
	 * 根据设备id查看相关设备规格ids
	 * @param id
	 * @return
	 * @throws Exception
	 */
	List<Integer> getSpecModelDataIds(int id);
    
    /**
     * 新建设备
     * @param entity 设备实体类
     */
	public void createDevice(DeviceBaseEntity entity);
	
	
	/**
	 * 创建设备相关规格参数
	 * @param deviceId 设备标识符
	 * @param deviceSpecDataEntites 规格参数集合
	 */
	public void addSpecaDataForDevice(int deviceId, List<DeviceSpecDataEntity> deviceSpecDataEntites);
	
	/**
	 * 添加照片
	 * @param deviceId 设备标识符
	 * @param devicePhotoLists 照片集合
	 */ 
	public void addPhotoForDevice(int deviceId, List<DevicePhotoEntity> devicePhotoLists);
	
	/**
	 * 统计符合条件的设备数量
	 * @param id 设备标识符
	 * @return 数量
	 */
	public int countDeviceASS(int id);
	
	/**
	 * 删除设备
	 * @param id 设备标识符
	 */
	public void deleteDevice(int id);
	
	/**
	 * 编辑设备
	 * @param entity 设备实体类
	 */
	public void updateDevice(DeviceBaseEntity entity);
	
	
	/**
	 * 通过设备标识符删除规格数据和照片
	 * @param id 设备标识符
	 */
	public void deleteSpecDataAndPhotoForDeviceByDeviceId(int id);
}
