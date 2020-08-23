package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lti.exception.CustomerServiceException;
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
	public int addLoanApplication(Application application) {
		return repo.addLoanApplication(application);
	}

	@Override
	public Admin adminLogin(int adminId, String adminPassword) {
		try {
			if (!repo.isAdminPresent(adminId))
				throw new CustomerServiceException("Admin not Present in Database.");
			int id = (int) repo.adminLogin(adminId, adminPassword);
			Admin admin = repo.findAdminById(adminId);
			return admin;
		} catch (EmptyResultDataAccessException e) {
			throw new CustomerServiceException("Incorrect username/password");

		}
	}

	@Override
	public List<Customer> viewAllUsers() {
		return repo.viewAllUsers();
	}

	@Override
	public boolean updateAdmin(Admin admin) {
		return repo.updateAdmin(admin);
	}

	@Override
	public Customer findAUser(int userId) {
		return repo.findAUser(userId);
	}

}
