package com.dtelec.icmes.information.service.helper.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.dtelec.icmes.information.service.helper.IValueHelper;

@Service
public class ValueHelperImpl implements IValueHelper {

	/**
	 * 计算设备的新度系数
	 * @param netValuePeriod 设备净值周期
	 * @param grossOrgValue  设备总原值
	 * @param grossNetValue   设备总净值
	 * @return double 新度系数
	 */
	@Override
	public double computeNewnessCoefficient(Date netValuePeriod, double grossOrgValue, double grossNetValue) {
		// TODO Auto-generated method stub
		return 0;
	}

}
