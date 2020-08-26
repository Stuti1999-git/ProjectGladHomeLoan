package com.lti.Dto;

import javax.persistence.Column;

public class ApplicationDto {
	
	private int customerId;
	
	private String gender;

	
	private String address;

	
	private String userPAN;

	
	private String aadharNumber;

	
	private String nationality;

	
	private int retirementAge;

	
	private String organisation;
	
	
	private double income;
	
	
	private double loanAmount;
	
	
	private String propertyType;
	
	
	private String propertyLocation;
	
	
	private double propertyCost;

	
	private int tenure;
	
	
	private double downPayment;
	
	
	private String maritialStatus;
	
	
	private int noOfDependents;
	
	
	private double depandentMonthlyExpenses;
	
	
	private double personlExpenses;
	
	
	private String existingLoan;
	
	
	private double emiExistingLoan;
	
	
	private double maxLoanAmount; //read only field based on above parameters and will be calculated on front end
	
	
	private String loanStatus="Pending";
	
	
	private String panCard;
	
	
	private String letterOfAgreement;
	
	
	private String noObjectionCerti;
	
	
	private String saleAgreement;
	
	
	private String aadharCard;
	
	
	private String salarySlip;


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
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
	
	

}
