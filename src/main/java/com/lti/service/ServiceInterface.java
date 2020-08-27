package com.lti.service;

import java.util.List;


import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;

import com.lti.Dto.ApplicationDto;
import com.lti.Dto.ChecklistDto;
import com.lti.Dto.StatusFetchByIdDto;
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

	public int findByEmailforOTP(String userEmail);

	public boolean forgotPassword(String userEmail, String newPassword);
	// Admin

	public Admin adminLogin(int employeeId, String adminPassword);

	public List<Customer> viewAllUsers();

	public Admin findAAdminById(int adminId);

	public boolean updateAdmin(Admin admin);

	public Customer findAUser(int userId);

	public List<Application> viewAllApplications();

	public boolean changeStatus(Application application);

	public Application findByApplicationId(int id);
	
	public List<Application> findPendingApplications();
	
	public Loan validateApplication(int id);
	public Application rejctApplication(int id);
	public List<Loan> viewAllLoan();
	public List<Loan> viewLoanByCustomerId(int id);
	public StatusFetchByIdDto searchStatus(int applicationId,int customerId);


	

	ChecklistDto checklist(int applicationId, int customerId);

	

	public Application get(int applicationId);

	public void update(Application application);

}
