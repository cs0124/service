package com.dtelec.icmes.information.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtelec.icmes.information.repository.IDictRepository;
import com.dtelec.icmes.information.repository.entity.DictDataBaseEntity;
import com.dtelec.icmes.information.repository.entity.DictDataFullEntity;
import com.dtelec.icmes.information.repository.entity.DictEntity;
import com.dtelec.icmes.information.repository.entity.DictTypeEntity;
import com.dtelec.icmes.information.repository.entity.PageableSearchBaseEntity;
import com.dtelec.icmes.information.repository.param.DictDataDetailPageableSearchParam;
import com.dtelec.icmes.information.repository.param.DictDetailPageableSearchParam;
import com.dtelec.icmes.information.service.annotation.QueryAction;
import com.dtelec.icmes.information.service.core.IQueryHandler;
import com.dtelec.icmes.information.service.model.DictCollection;
import com.dtelec.icmes.information.service.model.DictDataBaseModel;
import com.dtelec.icmes.information.service.model.DictDataCollection;
import com.dtelec.icmes.information.service.model.DictTypeCollection;
import com.dtelec.icmes.information.service.model.DictTypeModel;
import com.dtelec.icmes.information.service.query.DictDataDetailQuery;
import com.dtelec.icmes.information.service.query.DictDataQuery;
import com.dtelec.icmes.information.service.query.DictDetailQuery;
import com.dtelec.icmes.information.service.query.DictListQuery;
import com.dtelec.icmes.information.service.query.DictTypeQuery;

/**
 * 字典查询handler
 * @author dell
 *
 */
@Service
public class DictQueryHandler  implements IQueryHandler  {

	@Autowired
	private IDictRepository repository;
	
	
	/**
	 * 字典类型列表
	 * @param query 字典查询
	 * @return 字典集合
	 * @throws Exception 抛出的异常
	 */
	@QueryAction
	public DictTypeCollection getDictTypeList(DictDetailQuery query) throws Exception {
		//分页初始化
		int pageNo = query.getPage();
		pageNo = (pageNo < 1) ? 1 : pageNo;
		int pageSize = query.getCount();
		pageSize = (pageSize < 0) ? 0 : pageSize;
		int startIndex = (pageNo - 1) * pageSize;

		//实体类参数赋值
		DictDetailPageableSearchParam params = new DictDetailPageableSearchParam();
		params.setAscending(query.isAscending());
		params.setCode(query.getCode());
		params.setName(query.getName());
		params.setOrderBy(query.getOrderBy());
		params.setPageSize(pageSize);
		params.setStartIndex(startIndex);

		//调用持久层
		PageableSearchBaseEntity<DictTypeEntity> entities = repository.getDictTypeList(params);
		//填充返回集合
		DictTypeCollection coll = new DictTypeCollection();
		coll.fill(entities, query.getCount());

		return coll;
	} 
	
	
	
	/**
	 * 根据字典类型code 获取字典类型
	 * @param query 字典类型查询
	 * @return 字典类型模型
	 * @throws Exception 抛出的异常
	 */
	@QueryAction
	public DictTypeModel getDictTypeByCode(DictTypeQuery query) throws Exception {
		//调用持久层
		DictTypeEntity entity = repository.getDictTypeByCode(query.getCode());	
		//填充返回model
		DictTypeModel model=new DictTypeModel();
		model.fill(entity);
		
		return model;
		
	}
	
	
	
	@QueryAction
	public DictCollection loadDictList(DictListQuery query) {
		DictCollection coll = new DictCollection();
		List<DictEntity> entities = repository.getDictList();
		coll.fill(entities);
		
		return coll;
	}
	
	
	
	/**
	 * 字典数据列表
	 * @param query 字典数据查询
	 * @return 字典数据集合
	 * @throws Exception 抛出的异常
	 */
	@QueryAction
	public DictDataCollection getDictDataList(DictDataDetailQuery query) throws Exception {
		//分页初始化
		int pageNo = query.getPage();
		pageNo = (pageNo < 1) ? 1 : pageNo;
		int pageSize = query.getCount();
		pageSize = (pageSize < 0) ? 0 : pageSize;
		int startIndex = (pageNo - 1) * pageSize;
		//实体类参数赋值
		DictDataDetailPageableSearchParam params = new DictDataDetailPageableSearchParam();
		params.setAscending(query.isAscending());
		params.setCode(query.getCode());
		params.setOrderBy(query.getOrderBy());
		params.setPageSize(pageSize);
		params.setStartIndex(startIndex);

		//调用持久层
		PageableSearchBaseEntity<DictDataFullEntity> entities = repository.getDictDataList(params);
		//填充返回集合
		DictDataCollection coll = new DictDataCollection();
		coll.fill(entities, query.getCount());

		return coll;	
		
	
	} 
	
	
	/**
	 * 根据字典编码获取字典数据
	 * @param query 字典数据查询
	 * @return 字典数据模型
	 * @throws Exception 抛出的异常
	 */ 
	@QueryAction
	public DictDataBaseModel getDictDatayCode(DictDataQuery query) throws Exception {
		//调用持久层
		DictDataBaseEntity entity = repository.getDictDataByCode(query.getCode());	
		//填充返回model			
		DictDataBaseModel model=new DictDataBaseModel();			
		model.fill(entity);
			
		return model;
		
		
	}
	

}
