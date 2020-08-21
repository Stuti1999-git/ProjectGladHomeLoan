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

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public String getCustomerMobileNumber() {
		return customerMobileNumber;
	}

	public void setCustomerMobileNumber(String customerMobileNumber) {
		this.customerMobileNumber = customerMobileNumber;
	}

	public String getCustomerCity() {
		return customerCity;
	}

	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}

	public String getCustomerEmploymentType() {
		return customerEmploymentType;
	}

	public void setCustomerEmploymentType(String customerEmploymentType) {
		this.customerEmploymentType = customerEmploymentType;
	}

	public LocalDate getCustomerdateOfBirth() {
		return customerdateOfBirth;
	}

	public void setCustomerdateOfBirth(LocalDate customerdateOfBirth) {
		this.customerdateOfBirth = customerdateOfBirth;
	}

	public List<Application> getApplication() {
		return application;
	}

	public void setApplication(List<Application> application) {
		this.application = application;
	}
	
	

}
