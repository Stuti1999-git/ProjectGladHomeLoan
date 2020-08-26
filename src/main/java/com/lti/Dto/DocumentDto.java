package com.lti.Dto;

import org.springframework.web.multipart.MultipartFile;

public class DocumentDto {
	
	private int applicationId;
	private MultipartFile document;
	
	
	
	public int getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}
	public MultipartFile getDocument() {
		return document;
	}
	public void setDocument(MultipartFile document) {
		this.document = document;
	}
	
	
	
	
	
}
