package com.dtelec.icmes.common.model;

import java.util.List;

/**
 * 用于系统权限验证的公用账户对象
 * @author hlxu
 *
 */
public class AuthUserModel {

	/**
	 * 账户Id
	 */
	private int id;
	/**
	 * 员工工号
	 * 使用username 是为了系统融进到Spring Security 系统中
	 */
	private String username;
	/**
	 * 账户密码
	 */
	private String password;
	/**
	 * 是否需要修改密码
	 */
    private boolean changePassword;
    /**
     * 账户是否被锁定
     */
    private boolean isLock;
    /**
     * 账户错误密码登录次数
     */
    private int retryCount;
    /**
     * 系统登录成功授权的 JWT token
     */
    private String accessToken;
    /**
     * 当前账户拥有的角色列表
     */
    private List<AuthRoleModel> roles;
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public boolean isChangePassword() {
		return changePassword;
	}

	public void setChangePassword(boolean changePassword) {
		this.changePassword = changePassword;
	}

	public boolean isLock() {
		return isLock;
	}

	public void setLock(boolean isLock) {
		this.isLock = isLock;
	}

	public int getRetryCount() {
		return retryCount;
	}

	public void setRetryCount(int retryCount) {
		this.retryCount = retryCount;
	}

	public List<AuthRoleModel> getRoles() {
		return roles;
	}

	public void setRoles(List<AuthRoleModel> roles) {
		this.roles = roles;
	}	
}

