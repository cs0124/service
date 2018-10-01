package com.dtelec.icmes.auth.repository;

import com.dtelec.icmes.auth.repository.entity.UserEntity;


public interface IUserRepository {
	
	UserEntity findByEmployeeId(String employeeId);
	
}
