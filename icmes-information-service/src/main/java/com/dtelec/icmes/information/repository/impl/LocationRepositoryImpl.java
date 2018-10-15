package com.dtelec.icmes.information.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.dtelec.icmes.information.repository.ILocationRepository;
import com.dtelec.icmes.information.repository.dao.ILocationDao;
import com.dtelec.icmes.information.repository.entity.LocationEntity;
import com.dtelec.icmes.information.repository.entity.LocationFullNameEntity;
import com.dtelec.icmes.information.repository.entity.PageableSearchBaseEntity;
import com.dtelec.icmes.information.repository.param.LocationPageableSearchParam;

/**
 * Location Repository Impl
 * 作者：孔轩
 */
@Repository
public class LocationRepositoryImpl implements ILocationRepository {
    @Autowired
    private ILocationDao locationDao;

    /**
     * 创建位置信息
     */
    @Override
    public void createLocation(LocationEntity entity) {
        locationDao.createLocation(entity);
    }

    /**
	 * 更新位置信息
	 */
	@Override
	public void updateLocation(LocationEntity entity) {
		locationDao.updateLocation(entity);
    }
    
    /**
	 * 删除位置信息
	 */
	@Override
	public void deleteLocation(LocationEntity entity) {
		locationDao.deleteLocation(entity);
	}
	
	
	/**
	 * 检查版本控制信息
	 */
	@Override
	public String fetchLocationVersionTag(LocationEntity entity) {
		String versionTag = locationDao.fetchLocationVersionTag(entity);
	
		return versionTag;
	}

	
	/**
     * 统计符合条件的位置数量
     */
	@Override
	public int countLocationDevice(LocationEntity entity) {
		//定义返回的returnCount
		int returnCount = 1;
		//获取是不是叶子，最后一级，为0是
		int countEnd = locationDao.countLocationIfEnd(entity);
		//判断当前机构是否有关联用户，为0则没有用户
		int count = locationDao.countLocationDevice(entity);

		//如果都是0则可以删除
		if (count == 0 && countEnd == 0 ) {
			returnCount = 0;
		}
		return returnCount;
	}


	/**
	 * 通过Id和Name获取位置信息
	 */
	@Override
	public PageableSearchBaseEntity<LocationFullNameEntity> getLocationsbyCodeAndName(
			LocationPageableSearchParam param) {
		PageableSearchBaseEntity<LocationFullNameEntity> entity = 
			new PageableSearchBaseEntity<LocationFullNameEntity>();
		//查询集合
		List<LocationFullNameEntity> fullNameLocation = locationDao.getFullNameLocation(param);
		//统计条数
		int totalCount = locationDao.getFullNameLocationCount(param);
		entity.setTotalCount(totalCount);
		entity.setItems(fullNameLocation);
		return entity;
	}	



	/**
	 * 通过Id获取位置信息详情
	 */
	@Override
    public LocationEntity getLocationDetail(int id) {
		//获取location entity 
		return locationDao.getLocationDetail(id);
	}
}