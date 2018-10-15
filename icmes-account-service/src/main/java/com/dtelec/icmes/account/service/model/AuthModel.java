package com.dtelec.icmes.account.service.model;

import com.alibaba.fastjson.JSON;
/**
 * 映射权限服务返回的验证模型
 * 由于Spring Security，成功后 
 * 返回的对象限制，因此属性没有遵循驼峰命名法
 * @author hlxu
 *
 */
public class AuthModel {
	/**
	 * 验证成功的JWT token
	 * 
	 */
	private String access_token;
	/**
	 * 验证类型 这里永远是Bear
	 */
	private String token_type;
	/**
	 * 用于刷新的Token
	 */
	private String refresh_token;
	/**
	 * token 过期时长
	 */
	private int expires_in;
	/**
	 * token 的作用范围
	 */
	private String scope;
	/**
	 * 认证的 JTI 
	 */
	private String jti;
	/**
	 * 当前账户的绑定信息
	 */
	private String account_info;
	
	
	public String getAccess_token() {
		return access_token;
	}
	
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	
	public String getAccount_info() {
		return account_info;
	}

	public void setAccount_info(String account_info) {
		this.account_info = account_info;
	}
	
	public UserModel getAccountModel() {
		UserModel model = JSON.parseObject(this.account_info, UserModel.class);
		model.setAccessToken(this.access_token);
		return model;
	}

	public String getToken_type() {
		return token_type;
	}
	
	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}
	
	public String getRefresh_token() {
		return refresh_token;
	}
	
	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}
	
	public int getExpires_in() {
		return expires_in;
	}
	
	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}
	
	public String getScope() {
		return scope;
	}
	
	public void setScope(String scope) {
		this.scope = scope;
	}
	
	public String getJti() {
		return jti;
	}
	
	public void setJti(String jti) {
		this.jti = jti;
	}
	
}
