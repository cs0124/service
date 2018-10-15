package com.dtelec.icmes.information.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtelec.icmes.information.repository.IDeviceCategoryRepository;
import com.dtelec.icmes.information.repository.entity.DeviceCategoryBaseEntity;
import com.dtelec.icmes.information.repository.entity.DeviceCategorySpecDataEntity;
import com.dtelec.icmes.information.repository.entity.PageableSearchBaseEntity;
import com.dtelec.icmes.information.repository.entity.SpecDataEntity;
import com.dtelec.icmes.information.repository.param.DeviceCategoryPageableSearchParam;
import com.dtelec.icmes.information.service.annotation.QueryAction;
import com.dtelec.icmes.information.service.core.IQueryHandler;
import com.dtelec.icmes.information.service.model.DeviceCategoryCollection;
import com.dtelec.icmes.information.service.model.DeviceCategoryModel;
import com.dtelec.icmes.information.service.model.SpecDataCollection;
import com.dtelec.icmes.information.service.model.SpecDataModel;
import com.dtelec.icmes.information.service.query.AllSpecDataQuery;
import com.dtelec.icmes.information.service.query.DeviceCategoryDetailQuery;
import com.dtelec.icmes.information.service.query.DeviceCategorySearchQuery;

/**
 * 设备类型业务层
 */
@Service
public class DeviceCategoryQueryHandler implements IQueryHandler{
	
	@Autowired
	private IDeviceCategoryRepository deviceCategoryRepo;
	
	/**
	 *通过标识符获取工艺详细信息
	 * @param query 设备类型查询
	 * @return 设备类型模型
	 */
	@QueryAction
	public DeviceCategoryModel getDeviceCategory(DeviceCategoryDetailQuery query) {
		DeviceCategoryModel model = null;
		SpecDataModel dataModel = null;
		List<SpecDataModel> list = new ArrayList<>();
		//设备类型entity
		DeviceCategoryBaseEntity entity = deviceCategoryRepo.getDeviceCategoryById(query.getId());
		
		List<SpecDataEntity> dataEntity = deviceCategoryRepo.getSpecData(query.getId());
		for (SpecDataEntity child:dataEntity) {
			dataModel = new SpecDataModel();
			dataModel.fill(child);
			list.add(dataModel);
		}
		if (entity != null) {
		    model = new DeviceCategoryModel();	
		    model.setSpecDataList(list);
			model.fill(entity);
		}
		
		//规格数据entity
		
		return model;
	}
	
	
	/**
	 * 设备类型列表
	 * @param query 查询参数
	 * @return 设备类型数据集合
	 */
	@QueryAction
	public DeviceCategoryCollection getDeviceCategory(DeviceCategorySearchQuery query) {
		//分页初始化
		int pageNo = query.getPage();
		pageNo = (pageNo < 1) ? 1 : pageNo;
		int pageSize = query.getCount();
		pageSize = (pageSize < 0) ? 0 : pageSize;
		int startIndex = (pageNo - 1) * pageSize;
		
		//给查询参数赋值
		DeviceCategoryPageableSearchParam params = new DeviceCategoryPageableSearchParam();
		
		params.setIsPrimary(query.getIsPrimary());
		params.setGlobalName(query.getGlobalName());
		params.setPageSize(pageSize);
		params.setStartIndex(startIndex);
		params.setOrderBy(query.getOrderBy());
		params.setAscending(query.isAscending());
		
		//查询数据库
		PageableSearchBaseEntity<DeviceCategoryBaseEntity> entities = deviceCategoryRepo.getDeviceCategorys(params);
		
		List<DeviceCategoryBaseEntity> entity = entities.getItems();
		
        List<Integer> deviceCategoryIds = new ArrayList<>();
		if (entity != null) {
			for (DeviceCategoryBaseEntity child : entity) {
				deviceCategoryIds.add(child.getId());
			}
		}

		List<DeviceCategorySpecDataEntity> specDataEntities = deviceCategoryRepo.getSpecDataListByDeviceCategroyIds(deviceCategoryIds);
		Map<Integer, List<SpecDataModel>> specMapping = new HashMap<>();

		for (DeviceCategorySpecDataEntity specDataEntity : specDataEntities) {
			Integer deviceCategoryId = specDataEntity.getDeviceCategoryId();
			SpecDataModel specDataModel = new SpecDataModel();
			specDataModel.fill(specDataEntity);
			
			List<SpecDataModel> specDataList = null;
			if (specMapping.containsKey(deviceCategoryId)) {
				specDataList = specMapping.get(deviceCategoryId);
			}
			else {
				specDataList = new ArrayList<>();
				specMapping.put(deviceCategoryId, specDataList);
			}
			
			specDataList.add(specDataModel);
		}
				
		//填充返回值
		DeviceCategoryCollection coll = new DeviceCategoryCollection();
		coll.fill(entities, query.getCount(), specMapping);
		
		return coll;
		
	}
	
	
	/**
	 * 获取所有规格类型和数据模版
	 * @param query 所有规格类型和数据模版查询
	 * @return  所有规格类型和数据模版集合
	 */
	@QueryAction
	public SpecDataCollection getAllSpecData(AllSpecDataQuery query) {
		List<SpecDataEntity> entitys = deviceCategoryRepo.getAllSpecData();
		
		SpecDataCollection coll = new SpecDataCollection();
		coll.fill(entitys);
		
		return coll;
	}
	
}
