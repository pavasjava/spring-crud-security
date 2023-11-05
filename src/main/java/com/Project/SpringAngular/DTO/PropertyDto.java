package com.Project.SpringAngular.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PropertyDto {
	
	private int propertyid;
	private String propertyname;
	private String location;
	private int price;

}
