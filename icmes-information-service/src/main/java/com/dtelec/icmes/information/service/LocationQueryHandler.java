package com.dtelec.icmes.information.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtelec.icmes.information.repository.ILocationRepository;
import com.dtelec.icmes.information.repository.param.LocationPageableSearchParam;
import com.dtelec.icmes.information.service.annotation.QueryAction;
import com.dtelec.icmes.information.service.core.IQueryHandler;
import com.dtelec.icmes.information.service.model.LocationCollection;
import com.dtelec.icmes.information.service.model.LocationModel;
import com.dtelec.icmes.information.service.query.LocationDetailQuery;
import com.dtelec.icmes.information.service.query.LocationSearchQuery;
import com.dtelec.icmes.information.repository.entity.LocationEntity;
import com.dtelec.icmes.information.repository.entity.LocationFullNameEntity;
import com.dtelec.icmes.information.repository.entity.PageableSearchBaseEntity;

/**
 * 位置信息查询Handler
 * 作者：孔轩
 */
@Service
public class LocationQueryHandler implements IQueryHandler {

    @Autowired
    private ILocationRepository locationRepo;


    /**
     * 位置信息详情
     * @param query 位置信息查询
     * @return 位置信息详情
     */
    @QueryAction
    public LocationModel getLocationDetail(LocationDetailQuery query) {

        LocationModel model = null;
        //通过Id获取位置信息
        LocationEntity entity = locationRepo.getLocationDetail(query.getId());
        if(entity != null) {
            model = new LocationModel();
            model.fillModel(entity);
        }
        
        return model;
    }


    /**
     * 获取位置信息
     * @param query 位置信息查询
     * @return 位置信息集合
     */
    @QueryAction
    public LocationCollection getLocations(LocationSearchQuery query) {
        //分页初始化
        int pageNo = query.getPage();
        pageNo = (pageNo < 1) ? 1 : pageNo;
        int pageSize = query.getCount();
        pageSize = (pageSize < 0) ? 1 : pageSize;
        int startIndex = (pageNo - 1) * pageSize;
        //非空判定
        int parentId = query.getParentId();
        Boolean ascending = query.getAscending();
        if (ascending == null) {
            ascending = false;
        }
        int hierarchy;
        String hierarchyStr = query.getHierarchy();
        if (hierarchyStr == null || hierarchyStr.equals("")) {
            // 根节点，不能变
            hierarchy = 0;
        } 
        else {
            hierarchy = Integer.parseInt(hierarchyStr);
        }

        if (String.valueOf(parentId) == null || String.valueOf(parentId).equals("")) {
            // 根节点，不能变
            parentId = 0;
        }
        
        //实体类参数赋值
        LocationPageableSearchParam params = new LocationPageableSearchParam();
        params.setId(query.getId());
        params.setCode(query.getCode());
        params.setName(query.getName());
        params.setParentId(parentId);
        params.setParentCode(query.getParentCode());;
        params.setHierarchy(hierarchy);
        params.setPageSize(pageSize);
        params.setStartIndex(startIndex);
        params.setOrderBy(query.getOrderBy());
        params.setAscending(ascending);

        //调用持久层
        PageableSearchBaseEntity<LocationFullNameEntity> entities = locationRepo
            .getLocationsbyCodeAndName(params);

        //填充返回集合
        LocationCollection coll = new LocationCollection();
        coll.fill(entities, query.getCount());

        return coll;
    }


}