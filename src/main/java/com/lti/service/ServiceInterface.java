package com.lti.service;

import java.util.List;

import com.lti.Dto.ApplicationDto;
import com.lti.Dto.UpdateAdminDto;
import com.lti.model.Admin;
import com.lti.model.Application;
import com.lti.model.Customer;
import com.lti.model.Loan;

public interface ServiceInterface {

	// User
	public int registerUser(Customer user);

	public Customer isValidUser(int userId, String userPassword);

	public boolean updateUser(Customer user);

	public int addLoanApplication(Application application);

	// Admin

	public Admin adminLogin(int employeeId, String adminPassword);

	public List<Customer> viewAllUsers();

	public Admin findAAdminById(int adminId);

	public boolean updateAdmin(Admin admin);

	public Customer findAUser(int userId);

	public Customer findByEmail(String email);

	public List<Application> viewAllApplications();

	public boolean changeStatus(Application application);

	public Application findByApplicationId(int id);

	public Application get(int applicationId);

	public void update(Application application);
}
