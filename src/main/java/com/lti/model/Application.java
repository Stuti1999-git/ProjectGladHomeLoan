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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Application {

	@Id
	@SequenceGenerator(name = "user_sequence", initialValue = 20201, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
	private int applicationId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@Column
	private String gender;

	@Column
	private String address;

	@Column
	private String userPAN;

	@Column
	private String aadharNumber;

	@Column
	private String nationality;

	@Column
	private int retirementAge;

	@Column
	private String organisation;
	
	@Column
	private double income;
	
	@Column
	private double loanAmount;
	
	@Column
	private String propertyType;
	
	@Column
	private String propertyLocation;
	
	@Column
	private double propertyCost;

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
	private String panCard;
	
	@Column
	private String letterOfAgreement;
	
	@Column
	private String noObjectionCerti;
	
	@Column
	private String saleAgreement;
	
	@Column
	private String aadharCard;
	
	@Column
	private String salarySlip;
	
	@Column
	private LocalDate appointmentDate=LocalDate.now().plusDays(7);
	
	@OneToOne(mappedBy = "applicationLoan",cascade = CascadeType.ALL)
	private Loan loan;
	
	
	
	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public String getPropertyLocation() {
		return propertyLocation;
	}

	public void setPropertyLocation(String propertyLocation) {
		this.propertyLocation = propertyLocation;
	}

	public double getPropertyCost() {
		return propertyCost;
	}

	public void setPropertyCost(double propertyCost) {
		this.propertyCost = propertyCost;
	}

	public String getPanCard() {
		return panCard;
	}

	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}

	public String getLetterOfAgreement() {
		return letterOfAgreement;
	}

	public void setLetterOfAgreement(String letterOfAgreement) {
		this.letterOfAgreement = letterOfAgreement;
	}

	public String getNoObjectionCerti() {
		return noObjectionCerti;
	}

	public void setNoObjectionCerti(String noObjectionCerti) {
		this.noObjectionCerti = noObjectionCerti;
	}

	public String getSaleAgreement() {
		return saleAgreement;
	}

	public void setSaleAgreement(String saleAgreement) {
		this.saleAgreement = saleAgreement;
	}

	public String getAadharCard() {
		return aadharCard;
	}

	public void setAadharCard(String aadharCard) {
		this.aadharCard = aadharCard;
	}

	public String getSalarySlip() {
		return salarySlip;
	}

	public void setSalarySlip(String salarySlip) {
		this.salarySlip = salarySlip;
	}

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

	public void setPersonalExpenses(double personlExpenses) {
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

	

	

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
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

	
	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}

	@Override
	public String toString() {
		return "Application [applicationId=" + applicationId + ", customer=" + customer + ", gender=" + gender
				+ ", address=" + address + ", userPAN=" + userPAN + ", aadharNumber=" + aadharNumber + ", nationality="
				+ nationality + ", retirementAge=" + retirementAge + ", organisation=" + organisation + ", income="
				+ income + ", loanAmount=" + loanAmount + ", propertyType=" + propertyType + ", propertyLocation="
				+ propertyLocation + ", propertyCost=" + propertyCost + ", tenure=" + tenure + ", downPayment="
				+ downPayment + ", maritialStatus=" + maritialStatus + ", noOfDependents=" + noOfDependents
				+ ", depandentMonthlyExpenses=" + depandentMonthlyExpenses + ", personlExpenses=" + personlExpenses
				+ ", existingLoan=" + existingLoan + ", emiExistingLoan=" + emiExistingLoan + ", maxLoanAmount="
				+ maxLoanAmount + ", loanStatus=" + loanStatus + ", panCard=" + panCard + ", letterOfAgreement="
				+ letterOfAgreement + ", noObjectionCerti=" + noObjectionCerti + ", saleAgreement=" + saleAgreement
				+ ", aadharCard=" + aadharCard + ", salarySlip=" + salarySlip + ", appointmentDate=" + appointmentDate
				+ ", loan=" + loan + "]";
	}
	


}
