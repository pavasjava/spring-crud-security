package com.Project.SpringAngular.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor
public class AuthRequest {
	
	private String name;
	private String password;

}
