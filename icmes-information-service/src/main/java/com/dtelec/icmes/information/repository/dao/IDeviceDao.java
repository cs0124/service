package com.dtelec.icmes.information.repository.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.dtelec.icmes.information.repository.entity.DeviceBaseEntity;
import com.dtelec.icmes.information.repository.entity.DevicePhotoEntity;
import com.dtelec.icmes.information.repository.entity.DeviceSpecDataEntity;
import com.dtelec.icmes.information.repository.param.DevicePageableSearchParam;
import com.dtelec.icmes.information.repository.param.DevicePageableSearchResultParam;
import com.dtelec.icmes.information.repository.param.DeviceSpecDataParam;

/**
 * 
 * @author 张瑞晗 戴常怡
 * 设备Dao层
 */
@Mapper
public interface IDeviceDao {
	/**
	 * 查询设备列表
	 * @param param
	 * @return 设备列表
	 */
	List<DevicePageableSearchResultParam> searchDeviceColl(@Param("param") DevicePageableSearchParam param);

	/**
	 * 查询设备列表统计总数
	 * @param param
	 * @return 统计数量
	 */
	int searchDeviceCollCount(@Param("param") DevicePageableSearchParam param);
	
	/**
	 * 查询规格列表
	 * @param ids
	 * @return 规格列表
	 */
	List<DeviceSpecDataParam> searchDeviceSpecDataColl(@Param("ids") List<Integer> ids);
 
	//根据设备id查看设备
	DeviceBaseEntity getDeviceById(@Param("id") int id);
	
	//根据设备id查看设备照片列表
	List<DevicePhotoEntity> getDevicePhotosByDeviceId(@Param("id") int id);
	
	//根据设备id查看相关SpecData的ids
	List<Integer> getSpecModelDataIds(@Param("id") int id);
		
	/**
     * 通过设备类型标识符查询设备
     * @param deviceCategoryId 设备类型标识符
     * @return 设备集合
     */
	List<DeviceBaseEntity> findDevicesByDeviceCategoryId(@Param("deviceCategoryId") int deviceCategoryId);	

	/**
     * 通过工艺系统标识符查询设备
     * @param processId 工艺标识符
     * @return 设备集合
     */
	List<DeviceBaseEntity> findDevicesByProcessId(@Param("processId") int processId);
	
	/**
     * 通过位置标识符查询设备
     * @param locationId 位置标识符
     * @return 设备集合
     */
	List<DeviceBaseEntity> findDevicesByLocationId(@Param("locationId") int locationId);
	
	/**
     * 通过厂商标识符查询设备
     * @param vendorId 厂商标识符
     * @return 设备集合
     */
	List<DeviceBaseEntity> findDevicesByVendorId(@Param("vendorId") int vendorId);
	
	/**
	 * 新建设备
	 * @param entity 设备实体类
	 */
	void createDevice(DeviceBaseEntity entity);
	
	/**
	 * 创建设备相关规格参数
	 * @param deviceId 设备标识符
	 * @param deviceSpecDataEntites 规格参数集合
	 */
	void addSpecaDataForDevice(@Param("deviceId") int deviceId, @Param("deviceSpecDataEntites") List<DeviceSpecDataEntity> deviceSpecDataEntites);
	
	/**
	 * 添加照片
	 * @param deviceId 设备标识符
	 * @param devicePhotoLists 照片集合
	 */ 
	void addPhotoForDevice(@Param("deviceId") int deviceId,  @Param("devicePhotoLists") List<DevicePhotoEntity> devicePhotoLists);
	
	/**
	 * 查询是否是叶子
	 * @param id
	 * @return 总数
	 */
	int countDeviceIfEnd(@Param("id") int id);
	
    /**
     * 删除设备
     * @param id
     */
	void deleteDeviceByDeviceId(@Param("id") Integer id);
	
	/**
	 * 编辑设备
	 * @param entity 设备实体类
	 */
	void updateDevice(@Param("entity") DeviceBaseEntity entity);
	
	/**
	 * 通过设备标识符删除规格数据和照片
	 * @param deviceId 设备标识符
	 */
	void deleteSpecDataAndPhotoForDeviceByDeviceId(@Param("deviceId") int deviceId);
}
