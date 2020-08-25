package com.lti.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Application {

	@Id
	@SequenceGenerator(name = "user_sequence", initialValue = 20201, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
	private int applicationId;

	@ManyToOne
	@JoinColumn(name = "customer_id")//@JsonIgnore
	private Customer customer;

	@Column
	private String Gender;

	@Column
	private String address;

	@Column
	private String userPAN;

	@Column
	private String aadharNumber;

	@Column
	private String Nationality;

	@Column
	private int retirementAge;

	@Column
	private String organisation;
	
	@Column
	private double income;
	
	@Column
	private double loanAmount;

	@Column
	private int tenure;
	
	@Column
	private double downPayment;
	
	@Column
	private String maritialStatus;
	
	@Column
	private int noOfDependents;
	
	@Column
	private double depandentMonthlyExpenses;
	
	@Column
	private double personlExpenses;
	
	@Column
	private String existingLoan;
	
	@Column
	private double emiExistingLoan;
	
	@Column
	private double maxLoanAmount; //read only field based on above parameters and will be calculated on front end
	
	@Column
	private String loanStatus="Pending";
	
	@Column
	private LocalDate appointmentDate=LocalDate.now().plusDays(7);
	
	@OneToOne(mappedBy = "application",cascade = CascadeType.ALL)
	private Property property;
	
	@OneToOne(mappedBy = "applicationDocument",cascade = CascadeType.ALL)
	private Documents document;
	
	@OneToOne(mappedBy = "applicationLoan",cascade = CascadeType.ALL)
	private Loan loan;
	
	public String getMaritialStatus() {
		return maritialStatus;
	}

	public void setMaritialStatus(String maritialStatus) {
		this.maritialStatus = maritialStatus;
	}

	public int getNoOfDependents() {
		return noOfDependents;
	}

	public void setNoOfDependents(int noOfDependents) {
		this.noOfDependents = noOfDependents;
	}

	public double getDepandentMonthlyExpenses() {
		return depandentMonthlyExpenses;
	}

	public void setDepandentMonthlyExpenses(double depandentMonthlyExpenses) {
		this.depandentMonthlyExpenses = depandentMonthlyExpenses;
	}

	public double getPersonlExpenses() {
		return personlExpenses;
	}

	public void setPersonlExpenses(double personlExpenses) {
		this.personlExpenses = personlExpenses;
	}

	public String getExistingLoan() {
		return existingLoan;
	}

	public void setExistingLoan(String existingLoan) {
		this.existingLoan = existingLoan;
	}

	public double getEmiExistingLoan() {
		return emiExistingLoan;
	}

	public void setEmiExistingLoan(double emiExistingLoan) {
		this.emiExistingLoan = emiExistingLoan;
	}

	public double getMaxLoanAmount() {
		return maxLoanAmount;
	}

	public void setMaxLoanAmount(double maxLoanAmount) {
		this.maxLoanAmount = maxLoanAmount;
	}

	

	

	public String getLoanStatus() {
		return loanStatus;
	}

	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}

	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserPAN() {
		return userPAN;
	}

	public void setUserPAN(String userPAN) {
		this.userPAN = userPAN;
	}

	
	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getNationality() {
		return Nationality;
	}

	public void setNationality(String nationality) {
		Nationality = nationality;
	}

	

	public int getRetirementAge() {
		return retirementAge;
	}

	public void setRetirementAge(int retirementAge) {
		this.retirementAge = retirementAge;
	}

	public String getOrganisation() {
		return organisation;
	}

	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public int getTenure() {
		return tenure;
	}

	public void setTenure(int tenure) {
		this.tenure = tenure;
	}

	public double getDownPayment() {
		return downPayment;
	}

	public void setDownPayment(double downPayment) {
		this.downPayment = downPayment;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public Documents getDocument() {
		return document;
	}

	public void setDocument(Documents document) {
		this.document = document;
	}

	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}
	


}
