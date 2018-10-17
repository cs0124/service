package com.dtelec.icmes.power.service;

import java.util.List;

import com.dtelec.icmes.power.service.model.PowerCutFormBaseModel;
import com.dtelec.icmes.power.service.model.PowerCutFormCollection;
import com.dtelec.icmes.power.service.param.PowerCutPageableSearchParam;

import com.dtelec.icmes.power.service.model.PowerCutFormFullModel;

public interface IPowerCutService {
	
	/**
	 * 通过申请单标识 获取申请单信息
	 * @param id  申请单标识
	 * @return   申请单基础信息
	 * @throws Exception 抛出的异常
	 */
	PowerCutFormFullModel getPowerCutFormDetailById(String id) throws Exception;
	
	
	/**
	 * 新增申请单
	 * @param model  申请单基础模型
	 * @param assDeviceIds 相关的设备标识符
	 * @param ticketPhotos 相关工作票的照片标识符
	 * @throws Exception  抛出的异常
	 */
	void createPowerCutForm(PowerCutFormBaseModel model, List<Integer> assDeviceIds, List<String> ticketPhotos) throws Exception;
	
			
	/**
	 * 获取停电申请单列表
	 * @param params
	 * @return
	 */
	PowerCutFormCollection searchPowerCutFormByParams(PowerCutPageableSearchParam params);
	
	
	/**
	 *获取最大id
	 * @param nowTime
	 * @return
	 * @throws Exception
	 */
	String getMaxcutFormId(String nowTime)  throws Exception;
	
	
	/**
	 * 根据主设备申请单号获取关联设备申请单
	 * @param id
	 * @return
	 * @throws Exception
	 */
	PowerCutFormCollection getAssDeviceCutFormsById(String id) throws Exception;

}
