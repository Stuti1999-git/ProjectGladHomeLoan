package com.lti.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Loan {

	@Id
	@SequenceGenerator(name = "loan_sequence", initialValue = 1234000001, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loan_sequence")
	private int loanId;

	@Column
	private double balance;

	@Column
	private double interestRate;

	@Column
	private double tenure;

	@Column
	private double loanAmount;

	@Column
	private LocalDate emiStartDate;

	@Column
	private LocalDate emiEndDate;

	@Column
	private LocalDate emiNextDate;

	@Column
	private int emiAmount;

	@Column
	private LocalDate verificationDate;

	@OneToOne
	@JoinColumn(name = "application_id")
	private Application applicationLoan;
}
