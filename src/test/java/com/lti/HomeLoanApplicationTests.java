package com.lti;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.lti.model.Admin;

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
		
		application.setMaritialStatus("Married");
		application.setNoOfDependents(1);
		application.setDepandentMonthlyExpenses(100000);
		application.setPersonlExpenses(100000);
		application.setExistingLoan("YES");
		application.setEmiExistingLoan(2345);
		application.setMaxLoanAmount(234);
		application.setGender("Male");
		application.setAddress("sdfg");
		application.setUserPAN("vbnm");
		application.setAadharNumber("sdfghj");
		application.setNationality("Indian");
		application.setRetirementAge(60);
		application.setOrganisation("vbnm");
		application.setIncome(12345);
		application.setLoanAmount(5671234);
		application.setTenure(12);
		application.setDownPayment(123);
		
		
		
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
