package com.dtelec.icmes.information.service;

import com.dtelec.icmes.information.repository.IDeviceValueRepository;
import com.dtelec.icmes.information.repository.entity.DeviceValueEntity;
import com.dtelec.icmes.information.repository.entity.PageableSearchBaseEntity;
import com.dtelec.icmes.information.repository.param.DeviceValueDetailPageableSearchParam;
import com.dtelec.icmes.information.service.annotation.QueryAction;
import com.dtelec.icmes.information.service.core.IQueryHandler;
import com.dtelec.icmes.information.service.helper.IValueHelper;
import com.dtelec.icmes.information.service.model.DeviceValueCollection;
import com.dtelec.icmes.information.service.model.DeviceValueModel;
import com.dtelec.icmes.information.service.query.DeviceValueAllGrossOrgValueTotalQuery;
import com.dtelec.icmes.information.service.query.DeviceValueDetailQuery;
import com.dtelec.icmes.information.service.query.DeviceValueSearchQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 设备净值查询Handler
 * 作者：孔轩
 */
@Service
public class DeviceValueQueryHandler implements IQueryHandler {

    @Autowired
    private IDeviceValueRepository deviceValueRepo;

    @Autowired
    private IValueHelper valueHelper;

    /**
     * 设备净值详情查询
     * @param query 详情查询
     * @return 详情
     */
    @QueryAction
    public DeviceValueModel getDeviceValueDetail(DeviceValueDetailQuery query) {
        DeviceValueModel model = null;
        //通过Id获取设备净值详情信息
        DeviceValueEntity entity = deviceValueRepo.getDeviceValueDetail(query.getId());
        if(entity != null) {
            model = new DeviceValueModel();
            model.fillModel(entity);
        }

        //计算新度系数
        model.setNewnessCoefficient(
            valueHelper.computeNewnessCoefficient(model.getGrossOrgValue(), model.getGrossNetValue()));

        return model;
    }


    /**
     * 获取设备净值集合
     * @param query 集合查询
     * @return 集合
     */
    @QueryAction
    public DeviceValueCollection getDeviceValues(DeviceValueSearchQuery query) {
         //分页初始化
         int pageNo = query.getPage();
         pageNo = (pageNo < 1) ? 1 : pageNo;
         int pageSize = query.getCount();
         pageSize = (pageSize < 0) ? 1 : pageSize;
         int startIndex = (pageNo - 1) * pageSize;
         Boolean ascending = query.getAscending();
        if (ascending == null) {
            ascending = false;
        }

        //实体类参数赋值
        DeviceValueDetailPageableSearchParam params = new DeviceValueDetailPageableSearchParam();
        params.setPageSize(pageSize);
        params.setStartIndex(startIndex);
        params.setOrderBy(query.getOrderBy());
        params.setAscending(ascending);

        //调用持久层
        PageableSearchBaseEntity<DeviceValueEntity> entities = deviceValueRepo.getDeviceValues(params);
        for (DeviceValueEntity entity : entities.getItems()) {
            if(entity != null) {
                //计算新度系数
                double newnessCoefficient = valueHelper.computeNewnessCoefficient(entity.getGrossOrgValue(), entity.getGrossNetValue());
                entity.setNewnessCoefficient(newnessCoefficient);
            }
        }
        

        //填充返回集合
        DeviceValueCollection coll = new DeviceValueCollection();
        coll.fill(entities, query.getCount());

        return coll;
    }

    
    /**
     * 计算设备台账已录入的设备总原值的总和
     * @param query 总和查询
     * @return 总和
     */
    @QueryAction
    public Double getAllGrossOrgValueTotal(DeviceValueAllGrossOrgValueTotalQuery query) {
        double total = deviceValueRepo.computeAllGrossOrgValueTotal();
        return total;
    }
}