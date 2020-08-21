package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.lti.model.Admin;
import com.lti.model.Application;
import com.lti.model.Customer;
import com.lti.model.Loan;
import com.lti.service.ServiceInterface;

@Controller
public class ControllerClass {

	@Autowired
	ServiceInterface userService;

	public int addUser(Customer user) {
		return userService.registerUser(user);
	}

	public boolean updateUser(Customer user) {
		return userService.updateUser(user);
	}

	public boolean isValidUser(int userId, String userPassword) {
		return userService.isValidUser(userId, userPassword);
	}

	public int addloanApplication(Loan loan) {

		return userService.addLoanApplication(loan);
	}

	public boolean adminLogin(int adminId, String adminPassword) {
		return userService.adminLogin(adminId, adminPassword);
	}
	
	public Application findAUSer(int userId) {
		return userService.findAUser(userId);
	}

	public List<Application> viewAllUsers() {
		return userService.viewAllUsers();
	}

	public boolean updateAdmin(Admin admin) {
		
		return userService.updateAdmin(admin);
	}
	

}
