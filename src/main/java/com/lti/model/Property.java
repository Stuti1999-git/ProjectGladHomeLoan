package com.lti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class Property {

	@Id
	private int propertyId;
	
	@Column
	private String propertyType;
	
	@Column
	private String propertyLocation;
	
	@Column
	private double propertyCost;
	
	@OneToOne
	@JoinColumn(name = "application_id")
	private Application application;
}
