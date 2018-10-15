package com.dtelec.icmes.account.service.model;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 用户模型
 * @author zturnking
 *
 */
@ApiModel
public class UserModel {
	@ApiModelProperty(value = "登录账号流水号")
	private int id;
	@ApiModelProperty(value = "用户名")
	private String username;
	@ApiModelProperty(value = "密码")
	private String password;
	@ApiModelProperty(value = "表示账号是否需要更改密码")
    private boolean changePassword;
	@ApiModelProperty(value = "表示账号是否已经被锁定")
    private boolean isLock;
	@ApiModelProperty(value = "表示账号被错误登录的次数")
    private int retryCount;
	@ApiModelProperty(value = "登录权限验证token")
    private String accessToken;
	@ApiModelProperty(value = "角色")
    private List<RoleModel> roles;
    
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

	public List<RoleModel> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleModel> roles) {
		this.roles = roles;
	}	
}
