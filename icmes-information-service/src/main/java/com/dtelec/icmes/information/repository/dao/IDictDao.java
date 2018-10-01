package com.dtelec.icmes.information.repository.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.dtelec.icmes.information.repository.entity.DictDataBaseEntity;
import com.dtelec.icmes.information.repository.entity.DictDataFullEntity;
import com.dtelec.icmes.information.repository.entity.DictEntity;
import com.dtelec.icmes.information.repository.entity.DictTypeEntity;
import com.dtelec.icmes.information.repository.param.DictDataDetailPageableSearchParam;
import com.dtelec.icmes.information.repository.param.DictDetailPageableSearchParam;


@Mapper
public interface IDictDao {
	//获取字典类型列表
	List<DictTypeEntity> getDictTypeList(@Param("params") DictDetailPageableSearchParam params);
	//字典类型总条数
	int getDictTypeCount(@Param("params") DictDetailPageableSearchParam params);
	//根据字典类型code获取字典类型
	DictTypeEntity getDictTypeByCode(String code);
	//新增字典类型
	void addDictType( DictTypeEntity dictTypeEntity)  throws Exception;
	//更新字典类型
	void updateDictType( DictTypeEntity dictTypeEntity)  throws Exception;
	//删除字典类型
	void delDictType(String code) throws Exception;
	//获取字典列表
	List<DictDataFullEntity> getDictDataList(@Param("params") DictDataDetailPageableSearchParam params) throws Exception;
	//新增字典
	void addDictData( DictDataBaseEntity dictDataEntity)  throws Exception;
	//更新字典
	void updateDictData( DictDataBaseEntity dictDataEntity)  throws Exception;
	//删除字典
	void delDictData(String code) throws Exception;
	//根据字典code 获取字典
	DictDataBaseEntity getDictDataByCode(@Param("code")String code) throws Exception;
	
	List<DictEntity> getDictList();
	//字典总条数	
	int getDictDataCount(@Param("params") DictDataDetailPageableSearchParam params);
}
