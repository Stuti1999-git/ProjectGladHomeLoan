package com.lti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class Documents {

	@Id
	@OneToOne
	@JoinColumn(name="application_id")
	private Application applicationDocument;
	
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
}
