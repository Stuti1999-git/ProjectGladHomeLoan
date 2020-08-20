package com.lti.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Admin {

	@Id
	@SequenceGenerator(name = "admin_sequence", initialValue = 20201, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "admin_sequence")
	private int adminId;

	@Column
	private String adminFirstName;

	@Column
	private String adminLastName;

	@Column
	private String adminEmail;

	@Column
	private String adminPassword;

	@Column
	private String adminContact;

	@Column
	private LocalDate dateOfBirth;

	private String gender;

}
