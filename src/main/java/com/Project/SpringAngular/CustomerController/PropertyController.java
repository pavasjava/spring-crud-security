package com.Project.SpringAngular.CustomerController;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Project.SpringAngular.DTO.PropertyDto;
import com.Project.SpringAngular.Service.PropertyService;
import com.Project.SpringAngular.exception.ApiResponse;

@RestController
@CrossOrigin(origins ="*")
@RequestMapping("api/property")
public class PropertyController {
	
	@Autowired
	private PropertyService propertyService;
	
	@PostMapping("/saveproperty")
	public ResponseEntity<PropertyDto>save(@RequestBody PropertyDto propertyDto){
		PropertyDto SaveProp = propertyService.save(propertyDto);
		return new ResponseEntity<>(SaveProp,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteproperty/{propertyid}")
	public ResponseEntity<ApiResponse>delete(@PathVariable int propertyid){
		propertyService.delete(propertyid);
		return new ResponseEntity<>(new ApiResponse("Property Deleted!!", true),HttpStatus.OK);
	}
	@GetMapping("/getallproperty")
	public ResponseEntity<List<PropertyDto>>getAll(){
		List<PropertyDto> all = propertyService.getAll();
		return ResponseEntity.ok(all);
	}
	
	@PutMapping("/updateproperty/{propertyid}")
	public ResponseEntity<PropertyDto>update(@RequestBody PropertyDto prodtoDto, @PathVariable int propertyid){
		PropertyDto updateProp = propertyService.update(prodtoDto, propertyid);
		return ResponseEntity.ok(updateProp);
	}

}
