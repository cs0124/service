package com.dtelec.icmes.auth.service.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.dtelec.icmes.auth.repository.entity.RoleEntity;
import com.dtelec.icmes.auth.repository.entity.UserEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel
public class UserModel implements UserDetails {

	private static final long serialVersionUID = -2739778674195385529L;
	
	@ApiModelProperty(value = "用户ID")
	private int id;
	@ApiModelProperty(value = "用户名", required = true)
	private String username;
	@ApiModelProperty(value = "密码")
	private String password;
	@ApiModelProperty(value = "修改密码")
    private boolean changePassword;
	@ApiModelProperty(value = "是否锁定" )
    private boolean isLock;
	@ApiModelProperty(value = "重复输入次数" )
    private int retryCount;
	@ApiModelProperty(value = "角色列表" )
    private List<RoleModel> roles;

    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	@Override
	public List<GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> auths = new ArrayList<>();
        List<RoleModel> roles = this.getRoles();
        for(RoleModel role : roles) {
            auths.add(new SimpleGrantedAuthority(role.getId()));
        }
        return auths;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	public UserEntity covert() {
		UserEntity entity = new UserEntity();
		entity.setId(this.id);
		entity.setEmployeeId(this.username);
		entity.setPassword(this.password);
		entity.setChangePassword(this.changePassword);
		entity.setLock(this.isLock);
		entity.setRetryCount(this.retryCount);
		
	    List<RoleEntity> roleEntities = new ArrayList<>();
	    if (this.roles != null) {
	    	for (RoleModel role: this.roles) {
	    		roleEntities.add(role.covert());
	    	}
	    }
		entity.setRoles(roleEntities);
		
		return entity;
	}
	
	public void fill(UserEntity entity) {
		if (entity != null) {
			this.id = entity.getId();
			this.username = entity.getEmployeeId();
			this.password = entity.getPassword();
			this.changePassword = entity.isChangePassword();
			this.isLock = entity.isLock();
			this.retryCount = entity.getRetryCount();
			this.roles = new ArrayList<>();
			
			List<RoleEntity> roleEntities = entity.getRoles();
			if (roleEntities != null) {
		    	for (RoleEntity roleEntity: roleEntities) {
		    		RoleModel role = new RoleModel();
		    		role.fill(roleEntity);
		    		this.roles.add(role);
		    	}
		    }
		}
	}
}
