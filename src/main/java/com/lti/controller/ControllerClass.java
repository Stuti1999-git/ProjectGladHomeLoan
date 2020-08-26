package com.lti.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.Dto.AdminLoginDto;
import com.lti.Dto.DocumentDto;
import com.lti.Dto.LoginDto;
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

	@Autowired
	private MailSender mailSender;

	@PostMapping("/registerUser")
	public Status addUser(@RequestBody Customer user) {
		try {
			Customer customer = new Customer();
			customer = user;
			RegisterStatus status = new RegisterStatus();
			status.setCustomerId(userService.registerUser(user));
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Registration successful");
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom("abhishek.sethi@lntinfotech.com");
			message.setTo(customer.getCustomerEmail());
			message.setSubject("Thank You for registering with Bank Of LTI");
			message.setText("Your Customer ID is : " + status.getCustomerId());
			mailSender.send(message);
			return status;

		} catch (CustomerServiceException e) {
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

	@PostMapping("/updateUser")
	public boolean updateUser(@RequestBody Customer user) {
		System.out.println(user.getCustomerId());
		return userService.updateUser(user);
	}

	@PostMapping("/loginUser")
	public LoginStatus isValidUser(@RequestBody LoginDto loginDto) {
		try {
			Customer customer = userService.isValidUser(loginDto.getCustomerId(), loginDto.getCustomerPassword());
			LoginStatus loginStatus = new LoginStatus();
			loginStatus.setMessage("Login Successful");
			loginStatus.setCustomerFirstName(customer.getCustomerFirstName());
			loginStatus.setCustomerLastName(customer.getCustomerLastName());
			loginStatus.setCustomerEmail(customer.getCustomerEmail());
			loginStatus.setStatus(StatusType.SUCCESS);
			loginStatus.setCustomerId(customer.getCustomerId());
			return loginStatus;
		} catch (CustomerServiceException e) {
			LoginStatus loginStatus = new LoginStatus();
			loginStatus.setMessage(e.getMessage());
			loginStatus.setStatus(StatusType.FAILURE);

			return loginStatus;
		}
	}

	@PostMapping("/applyLoan")
	public int addloanApplication(@RequestBody Application application) {
		//System.out.println(application);
		return userService.addLoanApplication(application);
	}

	@PostMapping("/findAUser")
	public Customer findAUSer(@RequestBody Integer userId) {
		return userService.findAUser(userId);
	}

	@PostMapping("/findAAdmin")
	public Admin findAAdminById(@RequestBody Integer adminId) {
		return userService.findAAdminById(adminId);
	}

	@GetMapping("/viewAllCustomers")
	public List<Customer> viewAllUsers() {
		return userService.viewAllUsers();
	}

	public boolean updateAdmin(Admin admin) {

		return userService.updateAdmin(admin);
	}

	@GetMapping("/viewAllApplications")
	public List<Application> viewAllApplications() {
		return userService.viewAllApplications();
	}

	@PostMapping("/changeStatus")
	public Status changeStatus(Application application) {
		Status status = new Status();
		if(userService.changeStatus(application)) {
			status.setMessage("Updated Successfully");
			status.setStatus(StatusType.SUCCESS);
			return status;
		}
		else {
			status.setMessage("Not Updated");
			status.setStatus(StatusType.FAILURE);
			return status;
		}
	}

	@PostMapping("/viewApplication")
	public Application findByApplicationId(@RequestBody Integer id) {
		return userService.findByApplicationId(id);
	}
	
	@PostMapping("/pic-upload")
	public Status upload(DocumentDto documentDto) {
		String imageUploadLocation = "D:/LoanDocumentsUpload/";
		String fileName = documentDto.getAadharCard().getOriginalFilename();
		String targetFile = imageUploadLocation + fileName;
		try {
			FileCopyUtils.copy(documentDto.getAadharCard().getInputStream(), new FileOutputStream(targetFile));
		} catch (IOException e) {
			e.printStackTrace();
			Status status = new Status();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
		}

		Application application=userService.get(documentDto.getApplicationId());
		application.setAadharCard(fileName);
		userService.update(application);
		Status status = new Status();
		status.setStatus(StatusType.SUCCESS);
		status.setMessage("Uploaded!");
		return status;
	}

	@PostMapping("/PANUpload")
	public Status uploadPAN(DocumentDto document) {
		String imageUploadLocation = "D:/LoanDocumentsUpload/";
		String fileName = document.getPanCard().getOriginalFilename();
		String targetFile = imageUploadLocation + fileName;
		try {
			FileCopyUtils.copy(document.getPanCard().getInputStream(), new FileOutputStream(targetFile));
		} catch (IOException e) {
			e.printStackTrace();
			Status status = new Status();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
		}
		Application application = userService.get(document.getApplicationId());
		application.setPanCard(fileName);
		userService.update(application);
		
		Status status = new Status();
		status.setStatus(StatusType.SUCCESS);
		status.setMessage("Uploaded!");
		return status;
	}
	
	@PostMapping("/NOCUpload")
	public Status uploadNOC(DocumentDto document) {
		String imageUploadLocation = "D:/LoanDocumentsUpload/";
		String fileName = document.getNoObjectionCerti().getOriginalFilename();
		String targetFile = imageUploadLocation + fileName;
		try {
			FileCopyUtils.copy(document.getNoObjectionCerti().getInputStream(), new FileOutputStream(targetFile));
		} catch (IOException e) {
			e.printStackTrace();
			Status status = new Status();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
		}
		Application application = userService.get(document.getApplicationId());
		application.setNoObjectionCerti(fileName);
		userService.update(application);
		
		Status status = new Status();
		status.setStatus(StatusType.SUCCESS);
		status.setMessage("Uploaded!");
		return status;
	}
	
	
	@PostMapping("/LOAUpload")
	public Status uploadLOA(DocumentDto document) {
		String imageUploadLocation = "D:/LoanDocumentsUpload/";
		String fileName = document.getLetterOfAgreement().getOriginalFilename();
		String targetFile = imageUploadLocation + fileName;
		try {
			FileCopyUtils.copy(document.getLetterOfAgreement().getInputStream(), new FileOutputStream(targetFile));
		} catch (IOException e) {
			e.printStackTrace();
			Status status = new Status();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
		}
		Application application = userService.get(document.getApplicationId());
		application.setLetterOfAgreement(fileName);
		userService.update(application);
		
		Status status = new Status();
		status.setStatus(StatusType.SUCCESS);
		status.setMessage("Uploaded!");
		return status;
	}
	
	
	@PostMapping("/saleAgreementUpload")
	public Status uploadSaleAgreement(DocumentDto document) {
		String imageUploadLocation = "D:/LoanDocumentsUpload/";
		String fileName = document.getSaleAgreement().getOriginalFilename();
		String targetFile = imageUploadLocation + fileName;
		try {
			FileCopyUtils.copy(document.getSaleAgreement().getInputStream(), new FileOutputStream(targetFile));
		} catch (IOException e) {
			e.printStackTrace();
			Status status = new Status();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
		}
		Application application = userService.get(document.getApplicationId());
		application.setSaleAgreement(fileName);
		userService.update(application);
		
		Status status = new Status();
		status.setStatus(StatusType.SUCCESS);
		status.setMessage("Uploaded!");
		return status;
	}
	
	@PostMapping("/salarySlipUpload")
	public Status uploadSalarySlip(DocumentDto document) {
		String imageUploadLocation = "D:/LoanDocumentsUpload/";
		String fileName = document.getSalarySlip().getOriginalFilename();
		String targetFile = imageUploadLocation + fileName;
		try {
			FileCopyUtils.copy(document.getSalarySlip().getInputStream(), new FileOutputStream(targetFile));
		} catch (IOException e) {
			e.printStackTrace();
			Status status = new Status();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
		}
		Application application = userService.get(document.getApplicationId());
		application.setSaleAgreement(fileName);
		userService.update(application);
		Status status = new Status();
		status.setStatus(StatusType.SUCCESS);
		status.setMessage("Uploaded!");
		return status;
	}

	

	}
