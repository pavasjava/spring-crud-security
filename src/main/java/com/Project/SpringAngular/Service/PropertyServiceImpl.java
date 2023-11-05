package com.Project.SpringAngular.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.Project.SpringAngular.CustomerRepo.PropertyRepo;
import com.Project.SpringAngular.DTO.PropertyDto;
import com.Project.SpringAngular.entity.Property;

import jakarta.el.PropertyNotFoundException;

@Service
public class PropertyServiceImpl implements PropertyService {
	
	@Autowired
	private PropertyRepo propertyRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	//Save Property
	@Override
	public PropertyDto save(PropertyDto propertyDto) {
		Property Saveprop = modelMapper.map(propertyDto, Property.class);
		Property saveProperty = propertyRepo.save(Saveprop);
		return modelMapper.map(saveProperty, PropertyDto.class);
		
	}
	
	//delete Data
	@Override
	public void delete(int propertyid) {
		Property dData = propertyRepo.findById(propertyid).orElseThrow(()->new PropertyNotFoundException("Property Not Found"));
		propertyRepo.delete(dData);
	}
	
	//getAll Data
	@Override
	public List<PropertyDto> getAll() {
		List<Property> AllData = propertyRepo.findAll();
		List<PropertyDto> collect = AllData.stream().map(all->modelMapper.map(all, PropertyDto.class)).collect(Collectors.toList());
		return collect;
	}

	//Update
	@Override
	public PropertyDto update(PropertyDto propertyDto, int Propertyid) {
		Property updateProp = propertyRepo.findById(Propertyid).orElseThrow(()->new PropertyNotFoundException("Property Not Found"));
		updateProp.setLocation(propertyDto.getLocation());
		updateProp.setPrice(propertyDto.getPrice());
		updateProp.setPropertyname(propertyDto.getPropertyname());
		Property UpdateProperty = propertyRepo.save(updateProp);
		return modelMapper.map(UpdateProperty, PropertyDto.class);
	}

}
