package com.Project.SpringAngular.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Project.SpringAngular.CustomerRepo.UserRepo;
import com.Project.SpringAngular.entity.UserInfo;

@Service
public class UserService {
	

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	public String saveUser(UserInfo userInfo) {
		userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
		userRepo.save(userInfo);
		return "User Saved Successfully";
	}


}
