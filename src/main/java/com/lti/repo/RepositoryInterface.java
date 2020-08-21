package com.lti.repo;

import java.util.List;

import com.lti.model.Admin;
import com.lti.model.Application;
import com.lti.model.Customer;
import com.lti.model.Loan;

public interface RepositoryInterface {

	//User
	public int registerUser(Customer user);
	
	public boolean isValidUser(int userId,String userPassword);
	
	public boolean updateUser(Customer user);
	
	public int addLoanApplication(Application application);
	
	
	
	//Admin
	
	public boolean adminLogin(int employeeId,String adminPassword);
	
	public List<Customer> viewAllUsers();
	
	public boolean updateAdmin(Admin admin);
	
	public Customer findAUser(int userId);
}
