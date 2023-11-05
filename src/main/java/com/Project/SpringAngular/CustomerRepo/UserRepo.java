package com.Project.SpringAngular.CustomerRepo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Project.SpringAngular.entity.UserInfo;

public interface UserRepo extends JpaRepository<UserInfo, Integer> {
	
	Optional<UserInfo>findByName(String name);

}
