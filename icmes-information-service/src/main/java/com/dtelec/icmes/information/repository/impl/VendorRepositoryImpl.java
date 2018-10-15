package com.dtelec.icmes.information.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dtelec.icmes.information.repository.IVendorRepository;
import com.dtelec.icmes.information.repository.dao.IVendorDao;
import com.dtelec.icmes.information.repository.entity.PageableSearchBaseEntity;
import com.dtelec.icmes.information.repository.entity.VendorEntity;
import com.dtelec.icmes.information.repository.param.VendorPageableSearchParam;

/**
 * 厂商资料持久层实现类
 * @author dell
 *
 */
@Repository
public class VendorRepositoryImpl implements IVendorRepository {

	
	@Autowired
	IVendorDao vendorDao;
	
	
	/*
	 * 根据条件获取厂商列表
	 */
	@Override
	public PageableSearchBaseEntity<VendorEntity> getVendorList(VendorPageableSearchParam params) {
		PageableSearchBaseEntity<VendorEntity> entity = new PageableSearchBaseEntity<VendorEntity>();
		List<VendorEntity> resultVendor = vendorDao.getVendorList(params);
		int totalCount = vendorDao.getVendorCount(params);
		//set返回值
		entity.setTotalCount(totalCount);
		entity.setItems(resultVendor);
		return entity;
	}
	
	/**
	 * 新增厂商信息
	 * @throws Exception 
	 */
	@Override
	public void addVendor(VendorEntity entity) {
		vendorDao.addVendor(entity);
	}
	
	/**
	 * 修改厂商信息
	 */
	@Override
	public void updateVendor(VendorEntity entity) {
		vendorDao.updateVendor(entity);
	}
	
	/**
	 * 删除厂商信息
	 */
	@Override
	public void delVendor(Integer id) {
		vendorDao.deleteVendor(id);
	}

	/**
	 * 通过id获取厂商信息
	 */
	@Override
	public VendorEntity geVendorById(Integer id) {
		return vendorDao.getVendorById(id);
	}
	
	/**
	 * 通过code获取厂商信息
	 */
	@Override
	public VendorEntity geVendorByCode(String code) {
		return vendorDao.getVendorByCode(code);
	}
}
