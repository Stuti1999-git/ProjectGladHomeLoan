package com.lti.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class TrackStatus {
	
	@OneToOne
	@JoinColumn(name = "loan_id")
	private Loan loan;
	
	@Id
	private String loanStatus;
	
	@Column
	private LocalDate appointmentDate;
}
