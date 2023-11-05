package com.Project.SpringAngular.CustomerRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Project.SpringAngular.entity.Property;

public interface PropertyRepo extends JpaRepository<Property, Integer> {

}
