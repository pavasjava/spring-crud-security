package com.Project.SpringAngular.Service;

import java.util.List;

import com.Project.SpringAngular.DTO.PropertyDto;

public interface PropertyService {
	
	public PropertyDto save(PropertyDto propertyDto);
	public void delete(int propertyid);
	public List<PropertyDto>getAll();
	public PropertyDto update(PropertyDto propertyDto, int Propertyid);
}
