package com.lti.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.model.Admin;
import com.lti.model.Application;
import com.lti.model.Customer;
import com.lti.model.Loan;

@Repository
public class RepositoryClass implements RepositoryInterface {
	
	@PersistenceContext
	EntityManager em;
	
	
	@Override
	public int registerUser(Customer user) {
		Customer u = em.merge(user);
		return u.getCustomerId();
	}

	@Override
	public boolean isValidUser(int userId, String userPassword) {
		Customer user= em.find(Customer.class, userId);
		if(user!=null && user.getCustomerPassword().equals(userPassword))
			return true;
		return false;
	}

	@Override
	public boolean updateUser(Customer user) {
		Customer u = em.find(Customer.class, user.getCustomerId());
		if (u != null) {
			em.merge(user);
			return true;
		}
		return false;
	}

	@Override
	public int addLoanApplication(Loan loan) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean adminLogin(int employeeId, String adminPassword) {
		Admin admin= em.find(Admin.class, employeeId);
		if(admin!=null && admin.getAdminPassword().equals(adminPassword))
			return true;
		return false;
	}

	@Override
	public List<Application> viewAllUsers() {
		String sql = "select user from Application user order by user.userId";
		Query qry = em.createQuery(sql);
		List<Application> users = qry.getResultList();//typed query
		return users;
	}

	@Override
	public boolean updateAdmin(Admin admin) {
		Admin ad = em.find(Admin.class, admin.getAdminId());
		if (ad != null) {
			em.merge(ad);
			return true;
		}
		return false;
	}

	@Override
	public Application findAUser(int userId) {
		Application user = em.find(Application.class, userId);
		return user;
	}

}
