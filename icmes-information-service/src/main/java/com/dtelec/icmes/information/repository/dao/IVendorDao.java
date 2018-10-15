package com.dtelec.icmes.information.repository.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.dtelec.icmes.information.repository.entity.VendorEntity;
import com.dtelec.icmes.information.repository.param.VendorPageableSearchParam;

@Mapper
public interface IVendorDao {
	//获取厂商列表
	public List<VendorEntity> getVendorList(@Param("params") VendorPageableSearchParam params);
	
	//厂商总条数
	int getVendorCount(@Param("params") VendorPageableSearchParam params);
	
	//创建厂商
	void addVendor(@Param("entity") VendorEntity entity);
	
	//通过厂商Id获取厂商信息
	VendorEntity getVendorById (@Param("id") Integer id);
	
	//通过厂商Code获取厂商信息
	VendorEntity getVendorByCode (@Param("code") String code);
	
	//编辑厂商
	void updateVendor(@Param("entity") VendorEntity entity);
	
	//删除厂商
	void deleteVendor(@Param("id") Integer id);
	
}
