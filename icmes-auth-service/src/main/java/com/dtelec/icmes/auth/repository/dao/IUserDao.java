package com.dtelec.icmes.auth.repository.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.dtelec.icmes.auth.repository.entity.UserEntity;

@Mapper
public interface IUserDao {
	UserEntity findByEmployeeId(@Param("employeeId") String employeeId);
}
