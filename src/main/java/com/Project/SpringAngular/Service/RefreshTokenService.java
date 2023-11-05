package com.Project.SpringAngular.Service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.SpringAngular.CustomerRepo.RefreshTokenRepo;
import com.Project.SpringAngular.CustomerRepo.UserRepo;
import com.Project.SpringAngular.entity.RefreshToken;

@Service
public class RefreshTokenService {
	
	@Autowired
	private RefreshTokenRepo refreshTokenRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	public RefreshToken createRefreshToken(String username) {
		RefreshToken refreshToken = RefreshToken.builder()
		.userInfo(userRepo.findByName(username).get())
		.token(UUID.randomUUID().toString())
		.expiryDate(Instant.now().plusMillis(600000))
		.build();
		
		return refreshTokenRepo.save(refreshToken);
	}
	
	public Optional<RefreshToken>findByToken(String token){
		return refreshTokenRepo.findByToken(token);
	}
	
	public RefreshToken verifyExpiration(RefreshToken token) {
		
		if(token.getExpiryDate().compareTo(Instant.now())<0) {
			refreshTokenRepo.delete(token);
			throw new RuntimeException(token.getToken()+"Refresh Token is Expired");
		}
		return token;
		
	}

}
