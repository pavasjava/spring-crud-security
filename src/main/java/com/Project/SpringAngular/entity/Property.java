package com.Project.SpringAngular.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "property")
public class Property {
	@Id
	@Column(name = "propertyid", length = 50)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int propertyid;

	@Column(name = "propertyname", length = 50)
	private String propertyname;

	@Column(name = "location", length = 60)
	private String location;

	@Column(name = "price", length = 12)
	private int price;
	
}