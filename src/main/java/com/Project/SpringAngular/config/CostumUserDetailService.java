package com.Project.SpringAngular.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.Project.SpringAngular.CustomerRepo.UserRepo;
import com.Project.SpringAngular.entity.UserInfo;
@Component
public class CostumUserDetailService implements UserDetailsService {
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserInfo> userName = userRepo.findByName(username);
		return userName.map(CostumUserDetails::new).orElseThrow(()->new UsernameNotFoundException("User Not Found"+username));
	}

}
