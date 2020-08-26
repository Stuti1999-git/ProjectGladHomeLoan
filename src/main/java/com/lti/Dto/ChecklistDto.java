package com.lti.Dto;

import javax.persistence.Column;

import com.lti.status.Status;

public class ChecklistDto extends Status {

	private int applicationId;

	private int customerId;

	private String panCard;

	private String letterOfAgreement;

	private String noObjectionCerti;

	private String saleAgreement;

	private String aadharCard;

	private String salarySlip;

	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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
