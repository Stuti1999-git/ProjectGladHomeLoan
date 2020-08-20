package com.lti.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class TrackStatus {

	@OneToOne
	@JoinColumn(name = "loan_id")
	private Loan loan;

	private String loanStatus;
	
	private LocalDate appointmentDate;
}
