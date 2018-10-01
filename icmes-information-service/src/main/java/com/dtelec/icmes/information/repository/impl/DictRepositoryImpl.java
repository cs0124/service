package com.dtelec.icmes.information.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dtelec.icmes.information.repository.IDictRepository;
import com.dtelec.icmes.information.repository.dao.IDictDao;
import com.dtelec.icmes.information.repository.entity.DictDataBaseEntity;
import com.dtelec.icmes.information.repository.entity.DictDataFullEntity;
import com.dtelec.icmes.information.repository.entity.DictEntity;
import com.dtelec.icmes.information.repository.entity.DictTypeEntity;
import com.dtelec.icmes.information.repository.entity.PageableSearchBaseEntity;
import com.dtelec.icmes.information.repository.param.DictDataDetailPageableSearchParam;
import com.dtelec.icmes.information.repository.param.DictDetailPageableSearchParam;
/**
 * 字典持久层实现类
 * @author dell
 *
 */
@Repository
public class DictRepositoryImpl implements IDictRepository{


	@Autowired
	IDictDao dictDao;

	
	/**
	 * 根据字典类型code获取字典类型
	 */
	@Override
	public DictTypeEntity getDictTypeByCode(String code) throws Exception {
		
		return dictDao.getDictTypeByCode(code);
	}

	
	/**
	 * 新增字典类型
	 */
	@Override
	public void addDictType(DictTypeEntity dictType) throws Exception {
		dictDao.addDictType(dictType);
		
	}

	
	/**
	 * 更新字典类型
	 */
	@Override
	public void updateDictType(DictTypeEntity dictType) throws Exception {
			dictDao.updateDictType(dictType);
		
	}

	
	/**
	 * 删除字典类型
	 */
	@Override
	public void delDictType(String code) throws Exception {
		dictDao.delDictType(code);
		
		
	}

	
	/**
	 * 获取字典列表
	 */
	@Override
	public PageableSearchBaseEntity<DictDataFullEntity>  getDictDataList(DictDataDetailPageableSearchParam param) throws Exception {
		PageableSearchBaseEntity<DictDataFullEntity> entity = new PageableSearchBaseEntity<DictDataFullEntity>();
		List<DictDataFullEntity> entities = dictDao.getDictDataList(param);
		int totalCount = dictDao.getDictDataCount(param);
		entity.setTotalCount(totalCount);
		entity.setItems(entities);
		return entity;
	}
	

	
	/**
	 * 新增字典
	 */
	@Override
	public void addDictData(DictDataBaseEntity dictData) throws Exception {
		dictDao.addDictData(dictData);
		
	}

	
	/**
	 * 删除字典
	 */
	@Override
	public void delDictData( String code) throws Exception {
		dictDao.delDictData(code);
		
	}

	
	/**
	 * 根据字典code 获取字典数据
	 */
	@Override
	public DictDataBaseEntity getDictDataByCode( String code) throws Exception {
	
		return dictDao.getDictDataByCode(code);
	}

	
	/**
	 * 获取字典类型列表
	 */
	@Override
	public PageableSearchBaseEntity<DictTypeEntity> getDictTypeList(DictDetailPageableSearchParam param) throws Exception {
		PageableSearchBaseEntity<DictTypeEntity> entity = new PageableSearchBaseEntity<DictTypeEntity>();
		List<DictTypeEntity> entities = dictDao.getDictTypeList(param);
		int totalCount = dictDao.getDictTypeCount(param);
		entity.setTotalCount(totalCount);
		entity.setItems(entities);
		return entity;
	}

	@Override
	public List<DictEntity> getDictList() {
		return dictDao.getDictList();
	}

	
	/**
	 * 更新字典
	 */
	@Override
	public void updateDictData(DictDataBaseEntity dictData) throws Exception {
		
		dictDao.updateDictData(dictData);
		
	}
	
}
