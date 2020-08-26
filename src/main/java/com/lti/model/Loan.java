package com.lti.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Loan {

	@Id
	@SequenceGenerator(name = "loan_sequence", initialValue = 1234000001, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loan_sequence")
	private int loanId;

//	@Column
//	private double balance;

	@Column
	private double interestRate=8.75;

	@Column
	private double tenure;

	@Column
	private double loanAmount;

	@Column
	private LocalDate emiStartDate;

	@Column
	private LocalDate emiEndDate;

//	@Column
//	private LocalDate emiNextDate;

	@Column
	private double emiAmount;

	@Column
	private LocalDate verificationDate;
	
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "application_id")
	@JsonIgnore
	private Application applicationLoan;

	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

//	public double getBalance() {
//		return balance;
//	}
//
//	public void setBalance(double balance) {
//		this.balance = balance;
//	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public double getTenure() {
		return tenure;
	}

	public void setTenure(double tenure) {
		this.tenure = tenure;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public LocalDate getEmiStartDate() {
		return emiStartDate;
	}

	public void setEmiStartDate(LocalDate emiStartDate) {
		this.emiStartDate = emiStartDate;
	}

	public LocalDate getEmiEndDate() {
		return emiEndDate;
	}

	public void setEmiEndDate(LocalDate emiEndDate) {
		this.emiEndDate = emiEndDate;
	}

//	public LocalDate getEmiNextDate() {
//		return emiNextDate;
//	}
//
//	public void setEmiNextDate(LocalDate emiNextDate) {
//		this.emiNextDate = emiNextDate;
//	}

	

	public double getEmiAmount() {
		return emiAmount;
	}

	public void setEmiAmount(double emiAmount) {
		this.emiAmount = emiAmount;
	}

	public void setEmiAmount(int emiAmount) {
		this.emiAmount = emiAmount;
	}

	public LocalDate getVerificationDate() {
		return verificationDate;
	}

	public void setVerificationDate(LocalDate verificationDate) {
		this.verificationDate = verificationDate;
	}

	public Application getApplicationLoan() {
		return applicationLoan;
	}

	public void setApplicationLoan(Application applicationLoan) {
		this.applicationLoan = applicationLoan;
	}
	
	
}
