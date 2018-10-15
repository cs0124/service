package com.dtelec.icmes.information.repository;

import org.apache.ibatis.annotations.Param;

import com.dtelec.icmes.information.repository.entity.LocationEntity;
import com.dtelec.icmes.information.repository.entity.LocationFullNameEntity;
import com.dtelec.icmes.information.repository.entity.PageableSearchBaseEntity;
import com.dtelec.icmes.information.repository.param.LocationPageableSearchParam;

/**
 * Location Repository interface
 * 作者：孔轩
 */
public interface ILocationRepository {

    /**
     * 创建位置信息
     * @param entity
     */
    public void createLocation(LocationEntity entity);

    /**
	 * 更新组织机构
     * @param entity
	 */
    public void updateLocation(LocationEntity entity);
    
    /**
	 * 删除组织机构
     * @param entity
	 */
    public void deleteLocation(LocationEntity entity);
    
    /**
	 * 检查版本控制信息
	 */
    public String fetchLocationVersionTag(LocationEntity entity);
    
    /**
     * 统计符合条件的位置数量
     */
    public int countLocationDevice(LocationEntity entity);
    
    /**
	 * 通过Code和Name获取位置信息
	 * @param param 查询参数
	 * @return 位置信息实体类
	 */
    public PageableSearchBaseEntity<LocationFullNameEntity> getLocationsbyCodeAndName(@Param("param") LocationPageableSearchParam param);

    /**
     * 获取位置信息详情
     * @param id 查询id
     * @return 位置信息详情
     */
    public LocationEntity getLocationDetail(@Param("id") int id);
    
}
