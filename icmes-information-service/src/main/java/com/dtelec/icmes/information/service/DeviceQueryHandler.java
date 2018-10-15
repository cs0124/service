package com.dtelec.icmes.information.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtelec.icmes.information.repository.IDeviceRepository;
import com.dtelec.icmes.information.repository.entity.PageableSearchBaseEntity;
import com.dtelec.icmes.information.repository.param.DevicePageableSearchParam;
import com.dtelec.icmes.information.repository.param.DevicePageableSearchResultParam;
import com.dtelec.icmes.information.repository.param.DeviceSpecDataParam;
import com.dtelec.icmes.information.service.annotation.QueryAction;
import com.dtelec.icmes.information.service.core.IQueryHandler;
import com.dtelec.icmes.information.service.model.DeviceCollection;
import com.dtelec.icmes.information.service.model.DeviceSpecDataModel;
import com.dtelec.icmes.information.service.query.DeviceSearchQuery;

/**
 * 设备查询handler
 * 
 * @author 张瑞晗
 *
 */
@Service
public class DeviceQueryHandler implements IQueryHandler {
	/**
	 * 注入持久层
	 */
	@Autowired
	private IDeviceRepository repository;
	/**
	 * @author 张瑞晗
	 * @param query 查询query封装实体
	 * @return DeviceCollection 返回的集合
	 */
	@QueryAction
	public DeviceCollection getDeviceSearchCol(DeviceSearchQuery query) {
		// 分页初始化
		int pageNo = query.getPage();
		pageNo = (pageNo < 1) ? 1 : pageNo;
		int pageSize = query.getCount();
		pageSize = (pageSize < 0) ? 1 : pageSize;
		int startIndex = (pageNo - 1) * pageSize;

		// 入参填充
		DevicePageableSearchParam param = new DevicePageableSearchParam(
				query.getParentId(), 
				query.getGlobalName(),
				query.getCategoryList(), 
				query.getLocationList(), 
				query.getStatusList()
		);
		param.setAscending(query.isAscending());
		param.setOrderBy(query.getOrderBy());
		param.setPageSize(pageSize);
		param.setStartIndex(startIndex);

		// 调用查询
		PageableSearchBaseEntity<DevicePageableSearchResultParam> entity = repository.searchDeviceColl(param);

		List<Integer> ids = new ArrayList<>();
		// 将设备列表中的设备id提取出来放到ids中
		List<DevicePageableSearchResultParam> list = entity.getItems();
		for (int i = 0; i < list.size(); i++) {
			ids.add(list.get(i).getId());
		}
		List<DeviceSpecDataModel> specModel = new ArrayList<>();
		if (ids != null && ids.size() > 0) {
			// 查询对应设备的规格列表
			List<DeviceSpecDataParam> specList = repository.searchDeviceSpecColl(ids);

			// 填充规格model
			if (specList != null) {
				for (DeviceSpecDataParam specEntity : specList) {
					DeviceSpecDataModel model = new DeviceSpecDataModel();
					model.fill(specEntity);
					specModel.add(model);
				}
			}
		}
		// 将entity和param分别转换为model，返回controller
		DeviceCollection coll = new DeviceCollection();
		coll.fill(entity, query.getCount());
		coll.setSpecModList(specModel);

		return coll;

	}

}
