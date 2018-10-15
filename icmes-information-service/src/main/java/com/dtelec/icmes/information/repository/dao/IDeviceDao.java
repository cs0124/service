package com.dtelec.icmes.information.repository.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.dtelec.icmes.information.repository.param.DevicePageableSearchParam;
import com.dtelec.icmes.information.repository.param.DevicePageableSearchResultParam;
import com.dtelec.icmes.information.repository.param.DeviceSpecDataParam;
/**
 * 
 * @author 张瑞晗
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
	
}
