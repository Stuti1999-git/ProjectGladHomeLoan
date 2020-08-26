package com.lti.Dto;

import org.springframework.web.multipart.MultipartFile;

public class DocumentDto {

	private int applicationId;
	private MultipartFile aadharCard;
	private MultipartFile panCard;
	private MultipartFile letterOfAgreement;
	private MultipartFile noObjectionCerti;
	private MultipartFile saleAgreement;
	private MultipartFile salarySlip;

	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public MultipartFile getAadharCard() {
		return aadharCard;
	}

	public void setAadharCard(MultipartFile aadharCard) {
		this.aadharCard = aadharCard;
	}

	public MultipartFile getPanCard() {
		return panCard;
	}

	public void setPanCard(MultipartFile panCard) {
		this.panCard = panCard;
	}

	public MultipartFile getLetterOfAgreement() {
		return letterOfAgreement;
	}

	public void setLetterOfAgreement(MultipartFile letterOfAgreement) {
		this.letterOfAgreement = letterOfAgreement;
	}

	public MultipartFile getNoObjectionCerti() {
		return noObjectionCerti;
	}

	public void setNoObjectionCerti(MultipartFile noObjectionCerti) {
		this.noObjectionCerti = noObjectionCerti;
	}

	public MultipartFile getSaleAgreement() {
		return saleAgreement;
	}

	public void setSaleAgreement(MultipartFile saleAgreement) {
		this.saleAgreement = saleAgreement;
	}

	public MultipartFile getSalarySlip() {
		return salarySlip;
	}

	public void setSalarySlip(MultipartFile salarySlip) {
		this.salarySlip = salarySlip;
	}

	
}
