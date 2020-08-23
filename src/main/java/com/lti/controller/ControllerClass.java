package com.lti.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.Dto.AdminLoginDto;
import com.lti.Dto.CustomerDto;
import com.lti.exception.CustomerServiceException;
import com.lti.model.Admin;
import com.lti.model.Application;
import com.lti.model.Customer;
import com.lti.service.ServiceInterface;
import com.lti.status.AdminLoginStatus;
import com.lti.status.LoginStatus;
import com.lti.status.RegisterStatus;
import com.lti.status.Status;
import com.lti.status.Status.StatusType;


@RestController
@CrossOrigin
public class ControllerClass {

	@Autowired
	ServiceInterface userService;

	@PostMapping("/registerUser")
	public Status addUser(@RequestBody Customer user) {
		try {
			RegisterStatus status = new RegisterStatus();
			status.setCustomerId(userService.registerUser(user));
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Registration successful");
			return status;
			
		}
		catch (CustomerServiceException e) {
			Status status = new Status();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
			
		}
		
	}

	@PostMapping("/adminLogin")
	public Status adminLogin(@RequestBody AdminLoginDto loginDto) {
		try {
			Admin admin = userService.adminLogin(loginDto.getAdminId(), loginDto.getPassword());
			AdminLoginStatus loginStatus = new AdminLoginStatus();
			loginStatus.setMessage("Login Successful!");
			loginStatus.setAdminId(admin.getAdminId());
			loginStatus.setAdminName(admin.getAdminFirstName());
			loginStatus.setStatus(StatusType.SUCCESS);
			return loginStatus;
		} catch (CustomerServiceException e) {
			LoginStatus loginStatus = new LoginStatus();
			loginStatus.setMessage(e.getMessage());
			loginStatus.setStatus(StatusType.FAILURE);
			return loginStatus;
		}
	}
	public boolean updateUser(Customer user) {
		return userService.updateUser(user);
	}

	public boolean isValidUser(int userId, String userPassword) {
		return userService.isValidUser(userId, userPassword);
	}

	public int addloanApplication(Application application) {

		return userService.addLoanApplication(application);
	}

	
	
	public Customer findAUSer(int userId) {
		return userService.findAUser(userId);
	}

	public List<Customer> viewAllUsers() {
		return userService.viewAllUsers();
	}
	
	public boolean updateAdmin(Admin admin) {
		
		return userService.updateAdmin(admin);
	}
	

}
