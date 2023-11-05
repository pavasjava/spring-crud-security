package com.Project.SpringAngular.CustomerRepo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Project.SpringAngular.entity.RefreshToken;

public interface RefreshTokenRepo extends JpaRepository<RefreshToken, Integer> {
	
	Optional<RefreshToken> findByToken(String token);

}
