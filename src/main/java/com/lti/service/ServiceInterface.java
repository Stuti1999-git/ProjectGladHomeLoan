package com.lti.service;

import java.util.List;

import com.lti.model.Admin;
import com.lti.model.Application;
import com.lti.model.Customer;
import com.lti.model.Loan;

public interface ServiceInterface {

		//User
		public int registerUser(Customer user);
		
		public Customer isValidUser(int userId,String userPassword);
		
		public boolean updateUser(Customer user);
		
		public int addLoanApplication(Application loan);
		
		
		
		//Admin
		
		public boolean adminLogin(int employeeId,String adminPassword);
		
		public List<Customer> viewAllUsers();
		
		public boolean updateAdmin(Admin admin);
		
		public Customer findAUser(int userId);
}
