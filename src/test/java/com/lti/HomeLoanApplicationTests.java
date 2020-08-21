package com.lti;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lti.model.Application;
import com.lti.model.Customer;
import com.lti.repo.RepositoryInterface;

@SpringBootTest
class HomeLoanApplicationTests {

	@Autowired
	private RepositoryInterface repo;
	
	@Test
	void registerCustomer() {
		
		Customer customer = new Customer();
		customer.setCustomerCity("Mohali");
		customer.setCustomerdateOfBirth(LocalDate.of(1999, 07, 17));
		customer.setCustomerEmail("stuti@lti");
		customer.setCustomerEmploymentType("Salaried");
		customer.setCustomerFirstName("Stuti");
		customer.setCustomerLastName("Gupta");
		customer.setCustomerMobileNumber("9876543210");
		customer.setCustomerPassword("Stuti@123");
		
		repo.registerUser(customer);
		
	}
	
	@Test
	void addApplication() {
		
		Application application = new Application();
		application.setAadharNumber("9233756839999");
		application.setAddress("1265 3b2 mohali");
		application.setDownPayment(30000);
		application.setGender("Female");
		application.setIncome(50000);
		application.setLoanAmount(1000000);
		application.setNationality("Indian");
		application.setOrganisation("LTI");
		application.setRetirementAge(60);
		application.setTenure(10);
		application.setUserPAN("ABCD1234");
		
		
		System.out.println(repo.addLoanApplication(application));

		
		
		
	}
	
	@Test
	void userlogin() {
		
		System.out.println(repo.isValidUser(90502, "Stuti@123"));
		
	}
	
	@Test
	void viewAllUsers() {
		
		System.out.println(repo.viewAllUsers());
	}
	
	@Test
	void findAUser() {
		
		System.out.println(repo.findAUser(90501));
	}
	
	
	
	
	

}
