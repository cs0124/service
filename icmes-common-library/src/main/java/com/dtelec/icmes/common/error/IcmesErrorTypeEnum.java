package com.dtelec.icmes.common.error;

/**
 * 整个微服务系统的全部错误号的枚举
 * 
 * @author hlxu
 *
 */
public enum IcmesErrorTypeEnum {

	ACCOUNT_LOGIN_RETRYCOUNT_ERROR(100, "login retry count times"),
	ACCOUNT_LOGIN_NOFOUND_EMPLOYEE(101, "login don't found employee"),
	ACCOUNT_LOGIN_ISLOCKED_ERROR(102, "login locked for the employee"),
	ACCOUNT_LOGIN_PASSWORD_ERROR(103, "login password is wrong."),
	ACCOUNT_ADDPROXY_TIME_ERROR(104,"startTime must < entTime"),
	ACCOUNT_ADDPROXY_ERROR(105,"this proxyMessage has  exists"),
	ACCOUNT_UPDATEPROXY_ERROR(106,"this proxyMessage has not exists"),
	ACCOUNT_PROXY_VERSIONTAGERROR(107,"versionTag is wrong"),
	ACCOUNT_UPDATE_IS_NULL(108,"账号不存在!"),
	ACCOUNT_DELETE_BY_EMPLOYEEID(109,"员工号不能为空"),
	ACCOUNT_ROLE_DELETE_HASUSER(110, "current role has user"), 
	ACCOUNT_ROLE_DELETE_NOFOUND_ID(111, "current role no found id"),
	ACCOUNT_ROLE_UPDATE_VERSION_ERROR(112, "current versionTag is old"),
	ACCOUNT_ROLE_ACCOUNT_ASS_DELETE_FAILE(113,"exist the user Proxy ASS!"),
	ACCOUNT_ROLE_HAS_EXIST(114,"exist the Role!"),
	ACCOUNT_ROLE_ORG_HAS_EXIST(115,"exist the Role and the ORG to the same user!"),
	ACCOUNT_PASSWORD_CHANGE_ERROR(116, "orginal password is worng."),
	ACCOUNT_PASSWORD_TWICES_ERROR(117, "confirm password is difference with new password."),
	ACCOUNT_PASSWORD_CONFIRM_PASSWORD_EMPTY_ERROR(118, "confirm password is empty."),
	ACCOUNT_PASSWORD_NEW_PASSWORD_EMPTY_ERROR(119, "new password is empty."),
	ACCOUNT_PASSWORD_ORGINAL_PASSWORD_EMPTY_ERROR(120, "orginal password is empty."),
	ACCOUNT_PASSWORD_ORGINAL_PASSWORD_ERROR(121, "orginal password is wrong."),
	
	INFO_EMPLOYEE_CREATEEMPLOYEE_ISNOTNULL(201,"该员工已存在"),
	INFO_DICTTYPE_ADDERROR(202,"该字典类型已存在"),
	INFO_DICTTYPE_UPDATEERROR(203,"该字典类型不存在"),
	INFO_DICTTYPE_VERSIONTAGERROR(204,"vertionTag错误"),
	INFO_DICTDATA_ADDERROR(205,"该字典数据已存在"),	
	INFO_DICTDATA_UPDATEERROR(206,"该字典数据不存在"),
	INFO_DICTDATA_VERSIONTAGERROR(207,"vertionTag 错误"),
	INFO_EMPLOYEE_DELETE_ID_ISNULL(208,"员工工号不能为空"),
	INFO_ORGANIZATION_UPDATEORGANIZATION_NOFOUND_ID(209, "organization don't found id"),
	INFO_ORGANIZATION_UPDATEORGANIZATION_ROOT_PARENTID_ERROR(210, "the root of the tree can't change the parendId"),
	INFO_ORGANIZATION_DELETEORGANIZATION_HASCHILD(211, "current organization has child"),
	INFO_ORGANIZATION_UPDATEVERSION_ERROR(212, "current versionTag is old"),
	INFO_EMPLOYEE_UPDATEEMPLOYEE_ISNULL(213,"该员工不存在"),
	INFO_EMPLOYEE_VERSIONTAGERROR(214,"vertionTag 错误"),
	INFO_EMPLOYEE_DONT_DELETE_WITH_ACCOUNT(215, "不能删除带账号的员工"),
	INFO_ORGANIZATION_REINSERT_ERROR(216, "重复新增"),
	INFO_LOCATION_REINSERT_ERROR(217,"重复新增"),
	INFO_LOCATION_UPDATEVERSION_ERROR(218,"该位置信息已存在"),
	INFO_LOCATION_DELETELOCATION_HASCHILD(219,"该位置信息存在子位置信息"),
	INFO_PROCESS_UPDATEPROCESS_ISNULL(220,"该工艺不存在或已删除"),
	INFO_PROCESS_VERSIONTAGERROR(221,"vertionTag 错误"),
	INFO_PROCESS_CREATEPROCESS_ISNOTNULL(222,"工艺编号已存在"),
	INFO_VENDOR_REINSERT_ERROR(223,"Repeat addition"),
	INFO_VENDOR_ISNULL(224,"This vendor does not exist."),
	INFO_VENDOR_VERSIONTAGERRORL(225,"vertionTag error"),
	INFO_LOCATION_UPDATELOCATION_NOFOUND_ID(226,"location don't found id"),
	INFO_LOCATION_UPDATELOCATION_ROOT_PARENTID_ERROR(227,"the root of the tree can't change the parendId"),
	INFO_LOCATION_QUERYTLOCATION_NOFOUND_ID(228,"location don't found id"),
	INFO_LOCATION_DELETELOCATION_NOFOUND_ID(229,"location don't found id"),
	INFO_DEVICECATEGORY_CREATEDEVICEVATEGORY_ISNOTNULL(230,"设备类型编号已存在"),
	INFO_DEVICECATEGORY_CREATEDEVICEVATEGORY_ISNULL(231,"该设备类型不存在或已删除"),
	INFO_LOCATION_UPDATELOCATION_ERROR(232,"位置信息修改错误"),
	INFO_LOCATION_INSERTLOCATION_ERROR(233,"新增位置信息错误"),
	INFO_DEVICECATEGORY_DELETEDEVICEVATEGORY_ISFAIL(234,"设备类型与设备有关联，不能删除"),
	INFO_PROCESS_DELETEPROCESS_ISFAIL(235,"该工艺与设备有关联，不能删除"),
	INFO_DEVICEVALUE_REINSERT_ERROR(236,"重复新增"),
	INFO_DEVICEVALUE_INSERTDEVICEVALUE_ERROR(237,"新增设备净值错误"),
	INFO_DEVICEVALUE_UPDATEVERSION_ERROR(238,"设备净值版本信息错误"),
	INFO_DEVICEVALUE_UPDATEDEVICEVALUE_ERROR(239,"设备净值版本信息编辑错误"),
	INFO_DEVICEVALUE_DELETEDEVICVALUE_HASASSOCIATE(240,"设备净值存在关联关系"),
	INFO_DEVICEVALUE_DELETEDEVICVALUE_NOFOUND_ID(241,"设备净值信息没找到"),
	INFO_DEVICEVALUE_QUERYTDEVICEVALUE_NOFOUND_ID(242,"设备净值信息查询ID不能为空"),
	INFO_VENDOR__DONT_DELETE_WITH_DEVICE(243,"不能删除已关联设备的厂商"),
	INFO_DEVICECATEGORY_CREATEDEVICE_ISNOTNULL(244,"设备编号已存在"),
	INFO_DEVICE_DELETEDEVICE_HASCHILD(245,"当前设备存在子设备或关联设备，不能删除"),
	INFO_DEVICE_UPDATEDEVICE_ISNULL(246,"该设备不存在或已删除"),
	
	POWER_CUTFORM_CREATECUTFORM_ISNOTNULL(301,"该停电申请单号已存在！"),
	POWER_DELAYFORM_CREATEDELAYFORM_HASUNAPPRDELAYFORM(302,"该停电申请单存在尚未批准的延迟送电申请单！"),
	POWER_CUTFORM_CREATECUTFORM_DEVICEIDERROR(303,"关联设备不能和主设备相同！");
	
	private final int errorCode;
	private final String errorDesc;

	private IcmesErrorTypeEnum(int errorCode, String errorDesc) {
		this.errorCode = errorCode;
		this.errorDesc = errorDesc;
	}

	public static IcmesErrorTypeEnum getEnumByKey(int errorCode) {
		for (IcmesErrorTypeEnum item : IcmesErrorTypeEnum.values()) {
			if (item.getErrorCode() == errorCode) {
				return item;
			}
		}

		return null;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public String getErrorDesc() {
		return errorDesc;
	}
}
