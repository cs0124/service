package com.dtelec.icmes.information.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dtelec.icmes.common.utility.ConditionUtils;
import com.dtelec.icmes.information.controller.vo.ReqCreateDeviceVO;
import com.dtelec.icmes.information.controller.vo.ReqCreateDeviceVO.PhotoVO;
import com.dtelec.icmes.information.controller.vo.ReqCreateDeviceVO.SpecDataVO;
import com.dtelec.icmes.information.controller.vo.ReqUpdateDeviceVO;
import com.dtelec.icmes.information.controller.vo.ResUploadDevicePhotoVO;
import com.dtelec.icmes.information.service.command.DeviceCreateCommand;
import com.dtelec.icmes.information.service.command.DeviceDeleteCommand;
import com.dtelec.icmes.information.service.command.DeviceUpdateCommand;
import com.dtelec.icmes.information.service.model.DeviceCollection;
import com.dtelec.icmes.information.service.model.DeviceModel;
import com.dtelec.icmes.information.service.model.DevicePhotoModel;
import com.dtelec.icmes.information.service.model.DeviceSpecDataModel;
import com.dtelec.icmes.information.service.query.DeviceDetailQuery;
import com.dtelec.icmes.information.service.query.DeviceSearchQuery;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 设备控制器
 * @author schi
 *
 */
@RestController
@RequestMapping("/devices")
public class DeviceController {

	@ApiOperation(value = "获取设备详细信息-作者：戴常怡", notes = "根据url的id来获取设备的详细信息")
	@ApiResponses({ @ApiResponse(code = 200, message = "成功"), @ApiResponse(code = 401, message = "验证失败"),
			@ApiResponse(code = 404, message = "未找到"), @ApiResponse(code = 500, message = "内部系统错误") })
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "设备标示") })
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public DeviceModel getDevice(@PathVariable @ApiParam(name = "id", value = "设备标示") int id) throws Exception {
		DeviceDetailQuery query = new DeviceDetailQuery(id);
		DeviceModel model = query.queryAndWait();
		return model;
	}

	/**
	 * 编辑设备
	 * @param id 设备标识符
	 * @param reqVo 编辑设备模型
	 * @throws Exception 抛出的异常
	 */
	@ApiOperation(value = "修改设备信息-作者：迟山", notes = "根据url的id来修改设备信息")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"),
		@ApiResponse(code = 404, message = "未找到"), 
		@ApiResponse(code = 500, message = "内部系统错误") 
	})
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "设备标示") })
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public void updateDevice(
			@PathVariable @ApiParam(name = "id", value = "设备标示") int id,
			@Valid @RequestBody @ApiParam(name = "ReqUpdateDeviceVO", value = "更新模型") ReqUpdateDeviceVO reqVo
			)throws Exception {
		DeviceModel model = new DeviceModel();
		if (reqVo.parentId < 0) {
			model.setParentId(0);
		}
		else {
			model.setParentId(reqVo.parentId);
		}
		model.setId(id);
		model.setProcessNo(reqVo.processNo);
		model.setName(reqVo.name);
		model.setModel(reqVo.model);
		model.setPurchaseDate(reqVo.purchaseDate);
		model.setPurchasePrice(reqVo.purchasePrice);
		model.setManufacturingDate(reqVo.manufacturingDate);
		model.setManufacturingPlace(reqVo.manufacturingPlace);
		model.setSetupDate(reqVo.setupDate);
		model.setMemo(reqVo.memo);
		model.setStatus(reqVo.status);
		model.setLocationId(reqVo.locationId);
		model.setOrganizationId(reqVo.organizationId);
		model.setProcessId(reqVo.processId);
		model.setCategoryId(reqVo.categoryId);
		model.setVendorId(reqVo.vendorId);
		model.setManufacturerId(reqVo.manufacturerId);
		model.setVersionTag(reqVo.versionTag);
		
		//遍历规格
		List<DeviceSpecDataModel> deviceSpecDataList = new ArrayList<>();
		if (reqVo.specDataList != null) {
			for (ReqUpdateDeviceVO.SpecDataVO specDataVo : reqVo.specDataList) {
				DeviceSpecDataModel specDataModel = new DeviceSpecDataModel();
				specDataModel.setSpecDataId(specDataVo.specId);
				specDataModel.setValue(specDataVo.value);
				
				deviceSpecDataList.add(specDataModel);
			}
		}
		model.setSpecDataList(deviceSpecDataList);
		
		//遍历图片
		List<DevicePhotoModel> devicePhotoList = new ArrayList<>();
		if (reqVo.photoList != null) {
			for (ReqUpdateDeviceVO.PhotoVO photoVO : reqVo.photoList) {
				DevicePhotoModel devicePhotoModel = new DevicePhotoModel();
				devicePhotoModel.setPhoto(photoVO.photo);;
				devicePhotoModel.setOrder(photoVO.order);;
				
				devicePhotoList.add(devicePhotoModel);
			}
		}
		model.setPhotoList(devicePhotoList);
		DeviceUpdateCommand command = new DeviceUpdateCommand(model);
		command.sendAndWait();
	}

	@ApiOperation(value = "删除设备信息-作者：戴常怡", notes = "根据url的id来删除设备信息")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"),
		@ApiResponse(code = 404, message = "未找到"), 
		@ApiResponse(code = 500, message = "内部系统错误") })
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "设备标示") })
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public void deleteDevice(@PathVariable @ApiParam(name = "id", value = "设备标示") int id) throws Exception {
		//初始化command
		DeviceDeleteCommand command = new DeviceDeleteCommand(id);
		command.sendAndWait();
	}

	
	/**
	 * 新建设备
	 * @param reqVo 新建设备模型
	 * @throws Exception 抛出的异常
	 */
	@ApiOperation(value = "创建设备信息-作者：迟山", notes = "code和name是必填项")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"),
		@ApiResponse(code = 401, message = "验证失败"),
		@ApiResponse(code = 404, message = "未找到"), 
		@ApiResponse(code = 500, message = "内部系统错误") })
	@RequestMapping(path = "/", method = RequestMethod.POST)
	public void createDevice(@Valid @RequestBody @ApiParam(name = "ReqCreateDeviceVO", value = "新建模型") ReqCreateDeviceVO reqVo)throws Exception {
		DeviceModel model = new DeviceModel();
		if (reqVo.parentId < 0) {
			model.setParentId(0);
		}
		else {
			model.setParentId(reqVo.parentId);
		}
		model.setProcessNo(reqVo.processNo);
		model.setCode(reqVo.code);
		model.setName(reqVo.name);
		model.setModel(reqVo.model);
		model.setPurchaseDate(reqVo.purchaseDate);
		model.setPurchasePrice(reqVo.purchasePrice);
		model.setManufacturingDate(reqVo.manufacturingDate);
		model.setManufacturingPlace(reqVo.manufacturingPlace);
		model.setSetupDate(reqVo.setupDate);
		model.setMemo(reqVo.memo);
		model.setStatus(reqVo.status);
		model.setLocationId(reqVo.locationId);
		model.setOrganizationId(reqVo.organizationId);
		model.setProcessId(reqVo.processId);
		model.setCategoryId(reqVo.categoryId);
		model.setVendorId(reqVo.vendorId);
		model.setManufacturerId(reqVo.manufacturerId);
		
		//遍历规格
		List<DeviceSpecDataModel> deviceSpecDataList = new ArrayList<>();
		if (reqVo.specDataList != null) {
			for (SpecDataVO specDataVo : reqVo.specDataList) {
				DeviceSpecDataModel specDataModel = new DeviceSpecDataModel();
				specDataModel.setSpecDataId(specDataVo.specId);
				specDataModel.setValue(specDataVo.value);
				
				deviceSpecDataList.add(specDataModel);
			}
		}
		model.setSpecDataList(deviceSpecDataList);
		
		//遍历图片
		List<DevicePhotoModel> devicePhotoList = new ArrayList<>();
		if (reqVo.photoList != null) {
			for (PhotoVO photoVO : reqVo.photoList) {
				DevicePhotoModel devicePhotoModel = new DevicePhotoModel();
				devicePhotoModel.setPhoto(photoVO.photo);;
				devicePhotoModel.setOrder(photoVO.order);;
				
				devicePhotoList.add(devicePhotoModel);
			}
		}
		model.setPhotoList(devicePhotoList);
		DeviceCreateCommand command = new DeviceCreateCommand(model);
		command.sendAndWait();
	}

	/**
	 * 查询设备列表
	 * 
	 * @param condition 传入的参数，查询条件的拼串
	 * @return DeviceCollection 设备的列表实体集合
	 * @throws Exception 抛出的异常
	 * @author RHZhang 张瑞晗
	 */
	@ApiOperation(value = "设备查询--作者：张瑞晗", notes = "condition是查询条件")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "category", value = "设备标识符", dataType = "int", allowMultiple = true, paramType = "query"),
			@ApiImplicitParam(name = "location", value = "位置标识符", dataType = "int", allowMultiple = true, paramType = "query"),
			@ApiImplicitParam(name = "status", value = "设备状态", dataType = "string", allowMultiple = true, paramType = "query"),
			@ApiImplicitParam(name = "isPrimary", value = "是否为主设备，1主设备，0附属设备，不传或传空为两者全要", dataType = "Boolean",  paramType = "query"),
			@ApiImplicitParam(name = "parentId", value = "所属父级设备标识符，为0或者小于0或者空时，为查询主设备", dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "hierarchy", value = "迭代层级数，全集为0", dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "globalName", value = "全局搜索", dataType = "string", paramType = "query"),
			@ApiImplicitParam(name = "pageNo", value = "当前页码数", dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "pageSize", value = "一页多少条记录 0标识不分页全部显示", dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "orderBy", value = "排序的字段名", dataType = "string", paramType = "query"),
			@ApiImplicitParam(name = "ascending", value = "是否正序", dataType = "boolean", paramType = "query"), })
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"),
		@ApiResponse(code = 404, message = "未找到"), 
		@ApiResponse(code = 500, message = "内部系统错误") })
	@RequestMapping(path = "/list/{condition}", method = RequestMethod.GET)
	public DeviceCollection getDevices(@PathVariable String condition) throws Exception {
		// 传入参数初始化
		ConditionUtils util = new ConditionUtils(condition);
		List<Integer> categoryList = util.getValueIntegerArray("category", true);
		List<Integer> locationList = util.getValueIntegerArray("location", true);
		List<String> statusList = util.getValueStringArray("status", true);
		int parentId = util.getValueInteger("parentId", 0);
		if(parentId<0) {
			parentId=0;
		}
		int hierarchy = util.getValueInteger("hierarchy", 0);
		Boolean isPrimary = util.getValueBoolean("isPrimary", null);
		String globalName = util.getValueString("globalName", null);
		int pageNo = util.getValueInteger("pageNo", 1);
		int pageSize = util.getValueInteger("pageSize", 0);
		String orderBy = util.getValueString("orderBy", null);
		boolean ascending = util.getValueBoolean("ascending", true);

		DeviceSearchQuery query = new DeviceSearchQuery(pageNo, pageSize);
		query.setCategoryList(categoryList);
		query.setLocationList(locationList);
		query.setStatusList(statusList);
		query.setParentId(parentId);
		query.setGlobalName(globalName);
		query.setOrderBy(orderBy);
		query.setAscending(ascending);
		query.setHierarchy(hierarchy);
		query.setIsPrimary(isPrimary);

		// 调用service
		DeviceCollection coll = query.queryAndWait();

		// 拼装返回的设备列表和规格列表，将规格列表扁平化拼插在规格列表
		List<DeviceModel> items = coll.getItems();
		List<DeviceSpecDataModel> specModList = coll.getSpecModList();
		if (items != null && items.size() > 0) {
			for (int i = 0; i < items.size(); i++) {
				DeviceModel deviceModel = items.get(i);
				int devId = deviceModel.getId();
				StringBuffer specDataFullName = new StringBuffer();
				if (specModList != null && specModList.size() > 0) {
					for (int j = 0; j < specModList.size(); j++) {
						DeviceSpecDataModel deviceSpecDataModel = specModList.get(j);
						if (devId == specModList.get(j).getDeviceId()) {
							specDataFullName.append(deviceSpecDataModel.getName()).append("=").append(deviceSpecDataModel.getValue()).append(deviceSpecDataModel.getUnit()).append(" ");
							deviceModel.setSpecDataFullName(specDataFullName.toString());
						}
					}
				}
			}
		}
		return coll;
	}

	@ApiOperation(value = "上传设备照片-作者：", notes = "")
	@ApiResponses({ @ApiResponse(code = 200, message = "成功"), @ApiResponse(code = 401, message = "验证失败"),
			@ApiResponse(code = 404, message = "未找到"), @ApiResponse(code = 500, message = "内部系统错误") })
	@RequestMapping(path = "/photo", method = RequestMethod.POST)
	public ResUploadDevicePhotoVO uploadDevicePhoto() throws Exception {
		return null;
	}

}
