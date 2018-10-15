package com.dtelec.icmes.information.repository.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.dtelec.icmes.information.repository.entity.LocationEntity;
import com.dtelec.icmes.information.repository.entity.LocationFullNameEntity;
import com.dtelec.icmes.information.repository.param.LocationPageableSearchParam;

/**
 * Location Dao
 * 作者：孔轩
 */
@Mapper
public interface ILocationDao {

    /**
     * 创建位置信息
     * @param entity 创建实体
     */
    void createLocation(@Param("entity") LocationEntity entity);

    /**
     * 编辑位置信息
     * @param entity 修改实体
     */
    void updateLocation(@Param("entity") LocationEntity entity);

    /**
     * 删除位置信息
     * @param entity 删除实体
     */
    void deleteLocation(@Param("entity") LocationEntity entity);

    /**
     * 查询传入的位置信息版本号
     * @param entity 查询实体
     * @return 位置信息版本号
     */
    String fetchLocationVersionTag(@Param("entity") LocationEntity entity);

    /**
     * 查询是否和设备表关联
     * @param entity 查询尸体
     * @return 与设备关联的个数
     */
    int countLocationDevice(@Param("entity") LocationEntity entity);

    /**
     * 查询是否是叶子
     * @param entity 查询实体
     * @return 当前位置下子位置个数
     */
    int countLocationIfEnd(@Param("entity") LocationEntity entity);

    /**
     * 获取位置信息全称
     * @param param 查询参数
     * @return 位置信息集合
     */
    List<LocationFullNameEntity> getFullNameLocation(@Param("param") LocationPageableSearchParam param);

    /**
     * 获取位置信息全称数量统计
     * @param param 查询参数
     * @return 总数
     */
    int getFullNameLocationCount(@Param("param") LocationPageableSearchParam param);

    /**
     * 获取位置信息详情
     * @param id 查询Id
     * @return 位置信息详情
     */
    LocationEntity getLocationDetail(@Param("id") int id);
    
}