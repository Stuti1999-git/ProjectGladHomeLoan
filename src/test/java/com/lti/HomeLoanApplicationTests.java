package com.lti;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lti.model.Admin;
import com.lti.model.Customer;
import com.lti.repo.RepositoryInterface;

@SpringBootTest
class HomeLoanApplicationTests {
	
	@Autowired
	RepositoryInterface repo;
	
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
}
