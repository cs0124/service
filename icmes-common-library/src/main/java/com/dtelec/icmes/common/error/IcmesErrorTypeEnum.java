package com.dtelec.icmes.common.error;

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
	INFO_EMPLOYEE_DONT_DELETE_WITH_ACCOUNT(215, "不能删除带账号的员工");
	
	
	
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
