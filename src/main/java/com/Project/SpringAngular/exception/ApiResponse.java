package com.Project.SpringAngular.exception;

import lombok.AllArgsConstructor;
import lombok.Data;



@AllArgsConstructor
@Data
public class ApiResponse {
	private String message;
	private boolean status;

}
