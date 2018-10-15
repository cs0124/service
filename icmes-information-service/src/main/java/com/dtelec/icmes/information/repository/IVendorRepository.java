package com.dtelec.icmes.information.repository;

import com.dtelec.icmes.information.repository.entity.PageableSearchBaseEntity;
import com.dtelec.icmes.information.repository.entity.VendorEntity;
import com.dtelec.icmes.information.repository.param.VendorPageableSearchParam;

/**
 * 产商资料持久层接口
 * @author dell
 *
 */
public interface IVendorRepository {
	/**
	 * 查询厂商资料列表
	 * @param params
	 * @return
	 */
	PageableSearchBaseEntity<VendorEntity> getVendorList(VendorPageableSearchParam params);
	
	/**
	 * 新增厂商资料
	 * @param entity
	 * @throws Exception
	 */
	void addVendor(VendorEntity entity);
	
	
	/**
	 * 更新厂商资料
	 * @param entity
	 * @throws Exception
	 */
	void updateVendor(VendorEntity entity);
	
	
	/**
	* 删除厂商资料
	* @param id
	* @throws Exception
	*/
	void delVendor(Integer id);
	
	
	/**
	 * 根据id获取厂商资料
	 * @param id
	 * @return
	 * @throws Exception
	 */
	
	VendorEntity geVendorById(Integer id);
	
	/**
	 * 根据code获取厂商资料
	 * @param code
	 * @return
	 * @throws Exception
	 */
	VendorEntity geVendorByCode(String code);
}
