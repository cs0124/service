package com.dtelec.icmes.information.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtelec.icmes.information.repository.IVendorRepository;
import com.dtelec.icmes.information.repository.entity.PageableSearchBaseEntity;
import com.dtelec.icmes.information.repository.entity.VendorEntity;
import com.dtelec.icmes.information.repository.param.VendorPageableSearchParam;
import com.dtelec.icmes.information.service.annotation.QueryAction;
import com.dtelec.icmes.information.service.core.IQueryHandler;
import com.dtelec.icmes.information.service.model.VendorCollection;
import com.dtelec.icmes.information.service.model.VendorModel;
import com.dtelec.icmes.information.service.query.VendorDetailQuery;
import com.dtelec.icmes.information.service.query.VendorSearchQuery;

@Service
public class VendorQueryHandler implements IQueryHandler {
	@Autowired
	IVendorRepository vendorRepo;
	
	/**
	 * 获取厂商详细信息
	 * @param query
	 * @return VendorModel
	 */
	@QueryAction
	public VendorModel getVendorDetail(VendorDetailQuery query) {
		VendorModel model = null;
		//通过厂商自增Id查询数据库里是否存在此厂商
		VendorEntity entity = vendorRepo.geVendorById(query.getId());
		if (entity != null) {
		    model = new VendorModel();
			model.fillModel(entity);
		}
		
		return model;
	}
	
	/**
	 * 获取厂商信息列表
	 * @param query
	 */
	@QueryAction
	public VendorCollection getVendorList(VendorSearchQuery query) {
		//分页初始化
		int pageNo = query.getPage();
		pageNo = (pageNo < 1) ? 1 : pageNo;
		int pageSize = query.getCount();
		pageSize = (pageSize < 0) ? 0 : pageSize;
		int startIndex = (pageNo - 1) * pageSize;
		
		//给查询参数赋值
		VendorPageableSearchParam params = new VendorPageableSearchParam();
		
		params.setGlobalName(query.getGlobalName());
		params.setCode(query.getCode());
		params.setName(query.getName());
		params.setPageSize(pageSize);
		params.setStartIndex(startIndex);
		params.setOrderBy(query.getOrderBy());
		params.setAscending(query.isAscending());
		
		//查询数据库
		PageableSearchBaseEntity<VendorEntity> entities = vendorRepo.getVendorList(params);
		
		//填充返回值
		VendorCollection collection = new VendorCollection();
		collection.fill(entities, query.getCount());
		
		return collection;
	}
}
