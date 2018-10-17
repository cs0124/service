package com.dtelec.icmes.information.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dtelec.icmes.information.controller.vo.ResSpecDataVO;
import com.dtelec.icmes.information.controller.vo.ResSpecTypeVO;
import com.dtelec.icmes.information.service.model.SpecDataCollection;
import com.dtelec.icmes.information.service.model.SpecDataModel;
import com.dtelec.icmes.information.service.query.AllSpecDataQuery;
import com.dtelec.icmes.information.service.query.DeviceCategorySpecDataQuery;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("specDatas")
public class SpecDataController {
    
	@ApiOperation(value="获取所有规格数据模版-作者：", notes="")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
		})
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public List<SpecDataModel> getSpecData() throws Exception {
		return null;
	}
	
	
	@ApiOperation(value="获取所有规格类型和数据模版-作者：", notes="")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
		})
	@RequestMapping(path = "/types", method = RequestMethod.GET)
	public List<ResSpecTypeVO> getSpecType() throws Exception {
		List<ResSpecTypeVO> result = new ArrayList<>();
		
		AllSpecDataQuery query = new AllSpecDataQuery();
		SpecDataCollection coll = query.queryAndWait();
		
		if (coll != null) {
			Map<Integer, List<ResSpecDataVO>> typeMapping = new HashMap<>();
			//遍历返回的数据
			for (SpecDataModel model : coll.getItems()) {
				//规格模版数据所属类别
				Integer typeId = model.getTypeId();
				
				//规格数据VO模型
				ResSpecDataVO dataVo = new ResSpecDataVO();
				dataVo.id = model.getId();
				dataVo.name = model.getName();
				dataVo.unit = model.getUnit();
				dataVo.isExtraDisplayMode = model.isExtraDisplayMode();
				
				List<ResSpecDataVO> dataList = null;
				if (typeMapping.containsKey(typeId)) {
					dataList = typeMapping.get(typeId);
				}
				else {
					dataList = new ArrayList<>();
					typeMapping.put(typeId, dataList);
					
					ResSpecTypeVO typeVo = new ResSpecTypeVO();
					typeVo.id = typeId;
					typeVo.name = model.getTypeName();
					typeVo.specDataList = dataList;
					result.add(typeVo);
				}
				
				dataList.add(dataVo);
			}			
		}
		
		return result;
	}
		
	
	@ApiOperation(value="根据设备类型获取规格类型和数据模版-作者：徐宏亮", notes="根据url的deviceCategoryId来获取规格类型和数据模版")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
		})
	@ApiImplicitParams({
		@ApiImplicitParam(name= "id",value = "设备类型标示")
	})
	@RequestMapping(path = "/deviceCategory/{id}", method = RequestMethod.GET)
	public List<SpecDataModel> getSpecDataByDeviceCategory(@PathVariable @ApiParam(name = "id", value = "设备类型标示") int id) throws Exception {
		DeviceCategorySpecDataQuery query = new DeviceCategorySpecDataQuery(id);
		SpecDataCollection coll = query.queryAndWait();
		
		return (coll == null) ? null : coll.getItems();
	}
	
}
