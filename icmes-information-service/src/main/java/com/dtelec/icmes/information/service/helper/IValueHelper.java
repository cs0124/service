package com.dtelec.icmes.information.service.helper;


/**
 * 数值计算帮助Interface
 * 作者：孔轩
 */
public interface IValueHelper {

	/**
	 * 计算设备的新度系数
	 * @param grossOrgValue  设备总原值
	 * @param grossNetValue   设备总净值
	 * @return double 新度系数
	 */
	double computeNewnessCoefficient(double grossOrgValue, double grossNetValue);
}
