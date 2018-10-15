package com.dtelec.icmes.information.repository.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.dtelec.icmes.information.repository.IProcessRepository;
import com.dtelec.icmes.information.repository.dao.IProcessDao;
import com.dtelec.icmes.information.repository.entity.PageableSearchBaseEntity;
import com.dtelec.icmes.information.repository.entity.ProcessEntity;
import com.dtelec.icmes.information.repository.param.ProcessPageableSearchParam;

/**
 * 工艺持久层实现类
 *
 */
@Repository
public class ProcessRepositoryImpl implements IProcessRepository{
	
	/**
	 * 工艺DAO接口
	 */
	@Autowired
	IProcessDao dao;

	/**
	 * 新建工艺
	 */
	@Override
	public void createProcess(ProcessEntity entity) {
		dao.createProcess(entity);
	}

	/**
	 * 通过标识符获取工艺详细信息
	 */
	@Override
	public ProcessEntity getProcessById(int id) {
		return dao.getProcessById(id);
	}

	/**
	 * 删除工艺
	 */
	@Override
	public void deleteProcess(int id) {
		dao.deleteProcess(id);
	}

	/**
	 * 编辑工艺
	 */
	@Override
	public void updateProcess(ProcessEntity entity) {
		dao.updateProcess(entity);
	}

	/**
	 * 工艺列表
	 */
	@Override
	public PageableSearchBaseEntity<ProcessEntity> updateProcess(ProcessPageableSearchParam params) {
		PageableSearchBaseEntity<ProcessEntity> entity = new PageableSearchBaseEntity<ProcessEntity>();
		List<ProcessEntity> lists = dao.getProcess(params);
		int totalCount = dao.getProcessCount(params);
		//set返回值
		entity.setTotalCount(totalCount);
		entity.setItems(lists);
		return entity;
	}

	/**
	 * 通过编码获取工艺详细信息
	 */
	@Override
	public ProcessEntity getProcessByCode(String code) {
		return dao.getProcessByCode(code);
	}

}
