package com.lti.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.Dto.StatusFetchByIdDto;
import com.lti.Dto.UpdateAdminDto;
import com.lti.Dto.UpdateUserDto;
import com.lti.model.Admin;
import com.lti.model.Application;
import com.lti.model.Customer;
import com.lti.model.Loan;

@Repository
public class RepositoryClass implements RepositoryInterface {

	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional
	public int registerUser(Customer user) {
		Customer u = em.merge(user);
		return u.getCustomerId();
	}
	@Override
	public boolean isCustomerPresent(int userId) {
		return (Long) em.createQuery("select count(c.customerId) from Customer c where c.customerId =: id")
				.setParameter("id", userId).getSingleResult() == 1 ? true : false;
	}

	@Override
	public Customer findbyEmail(String email) {
		return (Customer) em.createQuery("select c from Customer c where c.customerEmail =: eml")
				.getResultList();
	}
	@Override
	public boolean doesEmailExist(String email) {
		return (Long) em.createQuery("select count(c.customerEmail) from Customer c where c.customerEmail =: eml")
				.setParameter("eml", email).getSingleResult() == 1 ? true : false;
	}

	@Override
	public Customer finById(int id) {
		return em.find(Customer.class, id);
	}

	@Override
	public int isValidUser(int userId, String userPassword) {
		return (Integer) em
				.createQuery("select c.id from Customer c where c.customerId =: id and c.customerPassword =:psw")
				.setParameter("id", userId).setParameter("psw", userPassword).getSingleResult();
	}
	
	

	@Override
	@Transactional
	public boolean updateUser(Customer user) {
		System.out.println(user.getCustomerId());
		Customer u = em.find(Customer.class, user.getCustomerId());

		if (u != null) {

			em.merge(user);
			System.out.println(user);
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public int addLoanApplication(Application application) {
		System.out.println(application);
		Application u = em.merge(application);
		return u.getApplicationId();
	}

	@Override
	@Transactional
	public int registerAdmin(Admin admin) {
		Admin ad = em.merge(admin);
		return ad.getAdminId();
	}

	@Override
	public long adminLogin(int employeeId, String adminPassword) {
		return (Integer) em.createQuery("select a.id from Admin a where a.adminId=:id and a.adminPassword=:pw")
				.setParameter("id", employeeId).setParameter("pw", adminPassword).getSingleResult();
	}

	@Override
	public boolean isAdminPresent(int adminId) {
		return (Long) em.createQuery("select count(a.id) from Admin a where a.adminId=:id").setParameter("id", adminId)
				.getSingleResult() == 1 ? true : false;
	}

	@Override
	public Admin findAdminById(int adminId) {
		return em.find(Admin.class, adminId);
	}

	@Override
	public List<Customer> viewAllUsers() {
		String sql = "select cust from Customer cust order by cust.customerId";
		Query qry = em.createQuery(sql);
		List<Customer> users = qry.getResultList();// typed query
		return users;
	}

	@Override
	@Transactional
	public boolean updateAdmin(Admin admin) {
		Admin ad = em.find(Admin.class, admin.getAdminId());
		if (ad != null) {
			em.merge(ad);
			return true;
		}
		return false;
	}

	@Override
	public Customer findAUser(int customerId) {
		Customer user = em.find(Customer.class, customerId);
		System.out.println(user);
		return user;
	}

	@Override
	@Transactional
	public boolean changeStatus(Application application) { // update status in database
		Application app = em.find(Application.class, application.getApplicationId());
		
		if (app != null) {
			em.merge(application);
			return true;
		}
		return false;
	}

	@Override
	public List<Application> viewAllApplications() {
		String sql = "select app from Application app order by app.applicationId";
		Query qry = em.createQuery(sql);
		
		List<Application> application = qry.getResultList();
		return application;
	}
	@Override
	public Application findByApplicationId(int id) {
		Application app = em.find(Application.class, id);
		return app;
	}

	@Override
	public List<Application> findPendingApplications() {
		String sql = "select app from Application app where app.loanStatus='Pending' order by app.applicationId";
		Query qry = em.createQuery(sql);
		List<Application> application = qry.getResultList();
		return application;
	}

	@Override
	@Transactional
	public boolean validateApplication(int id) {
//		String sql = "update Application app set app.loanStatus='Verified' where app.applicationId=:appId";
//		Query qry = em.createQuery(sql);
//		qry.setParameter("appId", id);
		Application application = em.find(Application.class, id);
		application.setLoanStatus("Verified");
		em.merge(application);
//		return em.merge(application);
		return true;
	}
	
	

	@Override
	@Transactional
	public Application rejctApplication(int id) {
		Application application = em.find(Application.class, id);
		application.setLoanStatus("Rejected");
		return em.merge(application);
	}

	@Override
	@Transactional
	public int addLoan(Loan loan) {
		Loan ln = em.merge(loan);
		return ln.getLoanId();
	}

	@Override
	public List<Loan> viewAllLoan() {
		String sql = "select ln from Loan ln order by ln.loanId";
		Query qry = em.createQuery(sql);
		List<Loan> allLoan = qry.getResultList();
		return allLoan;
	}
	@Override
	public List<Loan> viewLoanByCustomerId(int id) {
		String sql = "select ln from Loan ln where customerId=:custId";
		Query qry = em.createQuery(sql);
		qry.setParameter("custId", id);
		List<Loan> allLoan = qry.getResultList();
		return allLoan;
	}
	@Override
	public StatusFetchByIdDto fetchStatus(int applicationId,int customerId) {
//		String sql = "select app.applicationId, app.loanStatus, app.appointmentDate from Application app where app.applicationId=:appId";
//		Query qry = em.createQuery(sql);
//		qry.setParameter("appId", id);
//		FetchByIdDto result = (FetchByIdDto) qry.getSingleResult();
		Application app = em.find(Application.class, applicationId);
		if(app.getCustomer().getCustomerId()==customerId) {
			StatusFetchByIdDto result = new StatusFetchByIdDto();
			result.setApplicationId(app.getApplicationId());
			result.setAppointmentDate(app.getAppointmentDate());
			result.setLoanStatus(app.getLoanStatus());
			return result;
		}
		return null;
	}
}
