package com.dtelec.icmes.information.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dtelec.icmes.information.repository.IProcessRepository;
import com.dtelec.icmes.information.repository.entity.PageableSearchBaseEntity;
import com.dtelec.icmes.information.repository.entity.ProcessEntity;
import com.dtelec.icmes.information.repository.param.ProcessPageableSearchParam;
import com.dtelec.icmes.information.service.annotation.QueryAction;
import com.dtelec.icmes.information.service.core.IQueryHandler;
import com.dtelec.icmes.information.service.model.ProcessCollection;
import com.dtelec.icmes.information.service.model.ProcessModel;
import com.dtelec.icmes.information.service.query.ProcessDetailQuery;
import com.dtelec.icmes.information.service.query.ProcessSearchQuery;

/**
 * 工艺获取业务层
 */
@Service
public class ProcessQueryHandler implements IQueryHandler {
	
	/**
	 * 工艺持久层接口
	 */
	@Autowired
	IProcessRepository processRepo;
	
	/**
	 *通过标识符获取工艺详细信息
	 * @param query 工艺查询
	 * @return 工艺模型
	 */
	@QueryAction
	public ProcessModel getProcessDetail(ProcessDetailQuery query) {
		ProcessModel model = null;
		ProcessEntity entity = processRepo.getProcessById(query.getId());
		if (entity != null) {
		    model = new ProcessModel();	
			model.fill(entity);
		}

		return model;
	}
	
	
	/**
	 * 工艺列表
	 * @param query 查询参数
	 * @return 工艺数据集合
	 */
	@QueryAction
	public ProcessCollection getProcess(ProcessSearchQuery query) {
		//分页初始化
		int pageNo = query.getPage();
		pageNo = (pageNo < 1) ? 1 : pageNo;
		int pageSize = query.getCount();
		pageSize = (pageSize < 0) ? 0 : pageSize;
		int startIndex = (pageNo - 1) * pageSize;
		
		//给查询参数赋值
		ProcessPageableSearchParam params = new ProcessPageableSearchParam();
		
		params.setCode(query.getCode());
		params.setName(query.getName());
		params.setGlobalName(query.getGlobalName());
		params.setPageSize(pageSize);
		params.setStartIndex(startIndex);
		params.setOrderBy(query.getOrderBy());
		params.setAscending(query.isAscending());
		
		//查询数据库
		PageableSearchBaseEntity<ProcessEntity> entities = processRepo.updateProcess(params);
		
		//填充返回值
		ProcessCollection coll = new ProcessCollection();
		coll.fill(entities, query.getCount());

		return coll;
	}
	
}
