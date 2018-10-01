package com.dtelec.icmes.information.repository;

import java.util.List;

import com.dtelec.icmes.information.repository.entity.DictDataBaseEntity;
import com.dtelec.icmes.information.repository.entity.DictDataFullEntity;
import com.dtelec.icmes.information.repository.entity.DictEntity;
import com.dtelec.icmes.information.repository.entity.DictTypeEntity;
import com.dtelec.icmes.information.repository.entity.PageableSearchBaseEntity;
import com.dtelec.icmes.information.repository.param.DictDataDetailPageableSearchParam;
import com.dtelec.icmes.information.repository.param.DictDetailPageableSearchParam;

/**
 * 字典持久层接口
 * @author dell
 *
 */
public interface IDictRepository {
	//获取字典类型类别
	PageableSearchBaseEntity<DictTypeEntity> getDictTypeList(DictDetailPageableSearchParam param) throws Exception;
	//根据字典类别编码获取字典类别
	DictTypeEntity getDictTypeByCode(String code) throws Exception;
	//新增字典类别
	void addDictType( DictTypeEntity dictType)  throws Exception;
	//更新字典类别
	void updateDictType( DictTypeEntity dictType)  throws Exception;
	//删除字典类别
	void delDictType(String code) throws Exception;
	//获取字典列表
	PageableSearchBaseEntity<DictDataFullEntity> getDictDataList(DictDataDetailPageableSearchParam param) throws Exception;
	//新增字典
	void addDictData( DictDataBaseEntity dictData)  throws Exception;
	//更新字典
	void updateDictData( DictDataBaseEntity dictData)  throws Exception;
	//删除字典
	void delDictData(String code) throws Exception;
	//根据字典code 获取字典
	DictDataBaseEntity getDictDataByCode(String code) throws Exception;
	
	List<DictEntity> getDictList();
}
