package com.dtelec.icmes.information.service.helper;

import java.util.Date;

public interface IValueHelper {

	/**
	 * 计算设备的新度系数
	 * @param netValuePeriod 设备净值周期
	 * @param grossOrgValue  设备总原值
	 * @param grossNetValue   设备总净值
	 * @return double 新度系数
	 */
	double computeNewnessCoefficient(Date netValuePeriod, double grossOrgValue, double grossNetValue);
	
}
