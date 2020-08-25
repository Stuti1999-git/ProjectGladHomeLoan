package com.lti.repo;

import java.util.List;

import com.lti.model.Admin;
import com.lti.model.Application;
import com.lti.model.Customer;
import com.lti.model.Loan;

public interface RepositoryInterface {

	//User
	public int registerUser(Customer user);
	
	public int isValidUser(int userId,String userPassword);
	
	public boolean updateUser(Customer user);
	
	public int addLoanApplication(Application application);
	
	public boolean isCustomerPresent(int userId);
	
	
	//Admin
	int registerAdmin(Admin admin);
	public long adminLogin(int employeeId,String adminPassword);
	public Admin findAdminById(int adminId);
	public boolean isAdminPresent(int adminId);
	
	
	public List<Customer> viewAllUsers();
	
	public List<Application> viewAllApplications();
	
	public boolean updateAdmin(Admin admin);
	
	public Customer findAUser(int userId);
	
	public boolean changeStatus(Application application); //Will pass full application from Admin side also with auto filled fields

	Customer finById(int id);
	
	Application findByApplicationId(int id);
	
	
}
