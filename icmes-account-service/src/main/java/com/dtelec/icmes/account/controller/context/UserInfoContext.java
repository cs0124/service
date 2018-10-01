package com.dtelec.icmes.account.controller.context;

public class UserInfoContext {

	private static ThreadLocal<UserInfo> localUserInfo = new ThreadLocal<UserInfo>();
	public static String KEY_USERINFO_HTTP_HEADER = "X-HTTP-USERINFO-KEY";
	
	
	public static UserInfo getUserInfo() {
		return localUserInfo.get();
	}
	
	public static void setUserInfo(UserInfo userInfo) {
		localUserInfo.set(userInfo);
	}
	
}
