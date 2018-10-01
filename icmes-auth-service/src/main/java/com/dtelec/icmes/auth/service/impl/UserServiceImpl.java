package com.dtelec.icmes.auth.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dtelec.icmes.auth.repository.IUserRepository;
import com.dtelec.icmes.auth.repository.entity.UserEntity;
import com.dtelec.icmes.auth.service.IUserService;
import com.dtelec.icmes.auth.service.model.UserModel;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	@Autowired
	private IUserRepository userRepo;

	@Override
	public void createUser(UserModel user) {
		UserEntity existing = userRepo.findByEmployeeId(user.getUsername());
		Optional.ofNullable(existing).ifPresent(it-> {throw new IllegalArgumentException("user already exists: " + it.getEmployeeId());});
		
		UserEntity creating = user.covert();
		String hash = encoder.encode(user.getPassword());
		creating.setPassword(hash);

		//userRepo.saveUser(creating);

		log.info("new user has been created: {}", user.getUsername());
		
	}
    
	@Override
    public UserDetails loadUserByUsername(String username) {
        UserEntity entity = userRepo.findByEmployeeId(username);
        if (entity != null) {
        	UserModel user = new UserModel();
        	user.fill(entity);
            return user;
        } 
        else {
            throw new UsernameNotFoundException("admin: " + username + " do not exist!");
        }
    }
}
