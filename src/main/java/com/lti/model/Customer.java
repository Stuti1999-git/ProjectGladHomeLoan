package com.lti.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Customer {

	@Id
	@SequenceGenerator(name = "customer_seq", initialValue = 90500, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
	private int customerId;

	@Column
	private String customerFirstName;

	@Column
	private String customerLastName;

	@Column
	private String customerEmail;

	@Column
	private String customerPassword;

	@Column
	private String customerMobileNumber;

	@Column
	private String customerCity;

	@Column
	private String customerEmploymentType;

	@Column
	private LocalDate customerdateOfBirth;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Application> application;

}
