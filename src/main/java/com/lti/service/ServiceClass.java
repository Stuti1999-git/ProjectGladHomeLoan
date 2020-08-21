package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.lti.model.Admin;
import com.lti.model.Application;
import com.lti.model.Customer;
import com.lti.model.Loan;
import com.lti.repo.RepositoryInterface;

@Service
public class ServiceClass implements ServiceInterface {

	@Autowired
	private RepositoryInterface repo;

	@Override
	public int registerUser(Customer user) {
		return repo.registerUser(user);
	}

	@Override
	public boolean isValidUser(int userId, String userPassword) {
		return repo.isValidUser(userId, userPassword);
	}

	@Override
	public boolean updateUser(Customer user) {
		return repo.updateUser(user);
	}

	@Override
	public int addLoanApplication(Loan loan) {
		return repo.addLoanApplication(loan);
	}

	@Override
	public boolean adminLogin(int adminId, String adminPassword) {
		return repo.adminLogin(adminId, adminPassword);
	}

	@Override
	public List<Application> viewAllUsers() {
		return repo.viewAllUsers();
	}

	@Override
	public boolean updateAdmin(Admin admin) {
		return repo.updateAdmin(admin);
	}

	@Override
	public Application findAUser(int userId) {
		return repo.findAUser(userId);
	}

}
