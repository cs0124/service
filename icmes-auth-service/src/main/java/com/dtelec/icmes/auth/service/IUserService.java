package com.dtelec.icmes.auth.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.dtelec.icmes.auth.service.model.UserModel;

public interface IUserService extends UserDetailsService {

	public void createUser(UserModel user);
	
}
