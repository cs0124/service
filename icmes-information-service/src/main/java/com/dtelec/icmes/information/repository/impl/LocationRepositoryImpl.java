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
		//获取是不是叶子，最后一级，为0是
		int returnCount = locationDao.countLocationIfEnd(entity);
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

		//如果不是根节点，则将节点本身信息追加到集合中。
		if(param.getParentId() != 0) {
			LocationEntity entityTemp = locationDao.getLocationDetail(param.getParentId());
			LocationFullNameEntity entityFullNameTemp = new LocationFullNameEntity();
			entityFullNameTemp.setId(entityTemp.getId());
			entityFullNameTemp.setCode(entityTemp.getCode());
			entityFullNameTemp.setName(entityTemp.getName());
			entityFullNameTemp.setFullName(entityTemp.getFullName());
			entityFullNameTemp.setParentFullName(entityTemp.getParentFullName());
			entityFullNameTemp.setParentId(entityTemp.getParentId());
			entityFullNameTemp.setParentCode(entityTemp.getParentCode());
			entityFullNameTemp.setVersionTag(entityTemp.getVersionTag());
			entityFullNameTemp.setHasChild(totalCount > 0 ? true: false);
			//追加到集合中
			fullNameLocation.add(0, entityFullNameTemp);
			totalCount++;
		}
		
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