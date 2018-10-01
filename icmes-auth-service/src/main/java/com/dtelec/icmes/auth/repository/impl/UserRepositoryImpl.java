package com.dtelec.icmes.auth.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtelec.icmes.auth.repository.IUserRepository;
import com.dtelec.icmes.auth.repository.dao.IUserDao;
import com.dtelec.icmes.auth.repository.entity.UserEntity;

@Service
public class UserRepositoryImpl implements IUserRepository {
	
	@Autowired
	IUserDao userDao;

	@Override
	public UserEntity findByEmployeeId(String employeeId) {
		return userDao.findByEmployeeId(employeeId);
	}



}
