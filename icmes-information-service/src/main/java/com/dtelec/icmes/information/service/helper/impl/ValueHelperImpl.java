package com.dtelec.icmes.information.service.helper.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import com.dtelec.icmes.information.service.helper.IValueHelper;

/**
 * 数值计算帮助Impl
 * 作者：孔轩
 */
@Service
public class ValueHelperImpl implements IValueHelper {

	/**
	 * 计算设备的新度系数
	 * @param grossOrgValue  设备总原值
	 * @param grossNetValue   设备总净值
	 * @return double 新度系数
	 */
	@Override
	public double computeNewnessCoefficient(double grossOrgValue, double grossNetValue) {
		//计算新度系数，保留两位小数，四舍五入保留，如果不需要四舍五入，可以使用RoundingMode.DOWN
		double newnessCoefficient = grossOrgValue == 0 ? 0 : grossNetValue/grossOrgValue;
		BigDecimal bigDecimal = new BigDecimal(newnessCoefficient).setScale(2, RoundingMode.UP);
		return bigDecimal.doubleValue();
	}

}
