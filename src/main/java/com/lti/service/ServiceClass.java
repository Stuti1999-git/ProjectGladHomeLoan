package com.lti.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lti.Dto.ApplicationDto;
import com.lti.Dto.StatusFetchByIdDto;
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

		if (repo.doesEmailExist(user.getCustomerEmail()))
			throw new CustomerServiceException("Email already exists");

		return repo.registerUser(user);
	}

	@Override
	public Customer isValidUser(int userId, String userPassword) {
		try {
			if (!repo.isCustomerPresent(userId))
				throw new CustomerServiceException("User not found");

			int id = repo.isValidUser(userId, userPassword);
			Customer customer = repo.finById(id);
			return customer;
		} catch (EmptyResultDataAccessException e) {
			throw new CustomerServiceException("Incorrect credentials");
		}
	}

	@Override
	public boolean updateUser(Customer user) {
		return repo.updateUser(user);
	}

	@Override
	public int addLoanApplication(Application application) {
		/*
		 * Customer customer = new Customer(); Application app = new Application();
		 * customer.setCustomerId(application.getCustomerId());
		 * app.setCustomer(customer); app.setAadharCard(application.getAadharCard());
		 * app.setAadharNumber(application.getAadharNumber());
		 * app.setAddress(application.getAddress());
		 * app.setDepandentMonthlyExpenses(application.getDepandentMonthlyExpenses());
		 * app.setDownPayment(application.getDownPayment());
		 * app.setEmiExistingLoan(application.getEmiExistingLoan());
		 * app.setExistingLoan(application.getExistingLoan());
		 * app.setGender(application.getGender());
		 * app.setIncome(application.getIncome());
		 * app.setLetterOfAgreement(application.getLetterOfAgreement());
		 * app.setLoanAmount(application.getLoanAmount());
		 * app.setLoanStatus(application.getLoanStatus());
		 * app.setMaritialStatus(application.getMaritialStatus());
		 * app.setNationality(application.getNationality());
		 * app.setNoOfDependents(application.getNoOfDependents());
		 * app.setOrganisation(application.getOrganisation());
		 * app.setPersonlExpenses(application.getPersonlExpenses());
		 */
		
		
 int noOfdep = application.getNoOfDependents();
 System.out.println(application.getExistingLoan());
		
		if (noOfdep > 0) {
			
			if (application.getExistingLoan().equals("YES")) {
				application.setMaxLoanAmount(application.getIncome() - application.getDepandentMonthlyExpenses()
				- application.getEmiExistingLoan() - application.getPersonlExpenses());
				System.out.println("Hiiiiiiiiiiiiiiiiiii");
			}
			else {
				application.setMaxLoanAmount(application.getIncome() - application.getDepandentMonthlyExpenses()
						 - application.getPersonlExpenses());
				System.out.println("Byeeeeeeeeeeee");
			}
		}
			else {
				if (application.getExistingLoan() == "YES") {
					application.setMaxLoanAmount(application.getIncome() 
					- application.getEmiExistingLoan() - application.getPersonlExpenses());
				}
				else {
					application.setMaxLoanAmount(application.getIncome() 
							 - application.getPersonlExpenses());
				}
				
			}
		
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
		if(repo.isAdminPresent(admin.getAdminId()))
			return repo.updateAdmin(admin);
		
	return false;
	}

	@Override
	public Admin findAAdminById(int adminId) {
		return repo.findAdminById(adminId);
	}
	
	@Override
	public Customer findAUser(int userId) {
		return repo.findAUser(userId);
	}

	@Override
	public List<Application> viewAllApplications() {
		return repo.viewAllApplications();
	}

	@Override
	public boolean changeStatus(Application application) {
		return repo.changeStatus(application);
	}

	@Override
	public Application findByApplicationId(int id) {
		return repo.findByApplicationId(id);
	}

	@Override
	public List<Application> findPendingApplications() {
		return repo.findPendingApplications();
	}

	@Override
	public Loan validateApplication(int id) {
		Application application = repo.findByApplicationId(id);
		if(repo.validateApplication(id)) {
			Loan newLoan = new Loan();
			newLoan.setApplicationLoan(application);
			newLoan.setCustomerId(application.getCustomer().getCustomerId());
			int tenure = application.getTenure();
			tenure = tenure*12;
			double loanAmount = application.getLoanAmount();
			double roi = newLoan.getInterestRate()/(12*100);
			double pow1 = Math.pow((1+roi), (tenure));
			double pow2 = Math.pow((1+roi), (tenure))-1;
			double emi = (loanAmount*roi*pow1)/pow2;
			emi = Math.round(emi);
			newLoan.setEmiAmount(emi);
			newLoan.setTenure(tenure/12);
			newLoan.setLoanAmount(loanAmount);
			newLoan.setEmiStartDate(LocalDate.now());
			newLoan.setEmiEndDate(LocalDate.now().plusYears(tenure/12));
			newLoan.setVerificationDate(application.getAppointmentDate());
			repo.addLoan(newLoan);
			return newLoan;
		}
//		return repo.validateApplication(id);
		return null;
	}

	@Override
	public Application rejctApplication(int id) {
		return repo.rejctApplication(id);
	}

	@Override
	public List<Loan> viewAllLoan() {
		return repo.viewAllLoan();
	}

	@Override
	public List<Loan> viewLoanByCustomerId(int id) {
		return repo.viewLoanByCustomerId(id);
	}

	@Override
	public StatusFetchByIdDto searchStatus(int applicationId,int customerId) {
		return repo.fetchStatus( applicationId, customerId);
	}

}
