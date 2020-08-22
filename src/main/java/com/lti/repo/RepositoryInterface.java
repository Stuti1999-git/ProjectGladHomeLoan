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
	
	public int addLoanApplication(Loan loan);
	
	
	
	//Admin
	int registerAdmin(Admin admin);
	
	public boolean adminLogin(int employeeId,String adminPassword);
	
	public List<Application> viewAllUsers();
	
	public boolean updateAdmin(Admin admin);
	
	public Application findAUser(int userId);
}
