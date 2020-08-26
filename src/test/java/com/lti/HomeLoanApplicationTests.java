package com.lti;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.lti.model.Admin;

import com.lti.model.Application;
import com.lti.model.Customer;
import com.lti.repo.RepositoryInterface;
import com.lti.service.ServiceInterface;

@SpringBootTest
class HomeLoanApplicationTests {


	@Autowired
	private RepositoryInterface repo;
	
	
	@Autowired
	private ServiceInterface service;
	
	@Test
	void registerCustomer() {
		
		Customer customer = new Customer();
		customer.setCustomerCity("chd");
		customer.setCustomerdateOfBirth(LocalDate.of(1999, 07, 17));
		customer.setCustomerEmail("stutigupta177@lti");
		customer.setCustomerEmploymentType("Salaried");
		customer.setCustomerFirstName("Frooti");
		customer.setCustomerLastName("Gupta");
		customer.setCustomerMobileNumber("9676543210");
		customer.setCustomerPassword("Stuti@123");
		
		repo.registerUser(customer);
	}
	

	
	
	@Test
	void registerAdmin() {
		Admin admin = new Admin();
		admin.setAdminFirstName("Majrul");
		admin.setAdminLastName("Ansari");
		admin.setAdminEmail("majrul@gmail.com");
		admin.setAdminPassword("majrul@123");
		admin.setAdminContact("098765321");
		admin.setDateOfBirth(LocalDate.of(1982, 02, 01));
		admin.setGender("Male");
		
		System.out.println(repo.registerAdmin(admin));
	}
	
	
	@Test
	void adminLogin() {
		System.out.println(repo.adminLogin(20201, "majrul@123"));
		
	}

	@Test
	void addApplication() {
		
		Application application = new Application();
//		application.setAadharNumber("9233756839999");
//		application.setAddress("1265 3b2 mohali");
//		application.setDownPayment(30000);
//		application.setGender("Female");
//		application.setIncome(50000);
//		application.setLoanAmount(1000000);
//		application.setNationality("Indian");
//		application.setOrganisation("LTI");
//		application.setRetirementAge(60);
//		application.setTenure(10);
//		application.setUserPAN("ABCD1234");
		
//		application.setMaritialStatus("Married");
//		application.setNoOfDependents(0);
//		application.setDepandentMonthlyExpenses(0);
//		application.setPersonlExpenses(0);
//		application.setExistingLoan("NO");
		Customer customer = new Customer();
		customer = repo.finById(90585);
		application.setMaritialStatus("UnMarried");
		application.setNoOfDependents(0);
		application.setDepandentMonthlyExpenses(0);
		application.setPersonlExpenses(0);
		application.setExistingLoan("NO");
		application.setEmiExistingLoan(0);
		application.setMaxLoanAmount(0);
		application.setGender("Male");
		application.setAddress("EFG, HL");
		application.setUserPAN("JRVPS1079P");
		application.setAadharNumber("248512340000");
		application.setNationality("Indian");
		application.setRetirementAge(60);
		application.setOrganisation("LTI");
		application.setIncome(35000);
		application.setLoanAmount(2500000);
		application.setTenure(20);
		application.setDownPayment(550000);
		application.setCustomer(customer);
		System.out.println(repo.addLoanApplication(application));

		
		
		
	}
	
	@Test
	void changeStatus() {
		Application application = new Application();
		application.setApplicationId(20262);
		application.setMaritialStatus("Married");
		application.setDownPayment(350000);
		System.out.println(repo.changeStatus(application));
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
	
	@Test
	void findPending() {
		System.out.println(repo.findPendingApplications());
	}
	
	
	@Test
	void validate() {
		service.validateApplication(20302);
	}
}
