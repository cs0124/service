package com.dtelec.icmes.power.service;


import com.dtelec.icmes.power.service.model.PowerDelayFormBaseModel;
import com.dtelec.icmes.power.service.model.PowerDelayFormFullModel;

public interface IPowerDelayService {
	
	/**
	 * 通过申请单标识 获取申请单信息
	 * @param id  申请单标识
	 * @return   申请单基础信息
	 * @throws Exception 抛出的异常
	 */
	PowerDelayFormFullModel getPowerDelayFullFormDetailById(String id) throws Exception;
	
	
	/**
	 * 新增申请单
	 * @param model  申请单基础模型
	 * @param assDeviceIds 相关的设备标识符
	 * @param ticketPhotos 相关工作票的照片标识符
	 * @throws Exception  抛出的异常
	 */
	void createPowerDelayBaseForm(PowerDelayFormBaseModel model) throws Exception;
	
	/**
	 * 修改申请单
	 * @param model  申请单基础模型
	 * @throws Exception  抛出的异常
	 */
	void updatePowerDelayForm(PowerDelayFormBaseModel model) throws Exception;

	/**
	 *获取当天最大延迟送电id
	 * @param nowTime
	 * @return
	 * @throws Exception
	 */
	String getMaxDelayFormId(String nowTime)  throws Exception;
	
	/**
	 *查看停电申请单是否有未审批的延迟送电申请单
	 * @param powerCutFormId
	 * @return
	 * @throws Exception
	 */
	boolean hasUnapprovedPowerDelayForm(String powerCutFormId)  throws Exception;
}
