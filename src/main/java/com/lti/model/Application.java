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
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@Column
	private String Gender;

	@Column
	private String address;

	@Column
	private String userPAN;

	@Column
	private LocalDate dateOfBirth;

	@Column
	private String aadharNumber;

	@Column
	private String Nationality;

	@Column
	private String employmentType;

	@Column
	private int retirementAge;

	@Column
	private String organisation;

	@Column
	private String income;

	private double loanAmount;

	private int tenure;

	private double downPayment;

	@OneToOne(mappedBy = "application",cascade = CascadeType.ALL)
	private Property property;
	
	@OneToOne(mappedBy = "applicationDocument",cascade = CascadeType.ALL)
	private Documents document;
	
	@OneToOne(mappedBy = "applicationLoan",cascade = CascadeType.ALL)
	private Loan loan;
	


}
