package com.lti.Dto;

import java.time.LocalDate;

import com.lti.status.Status;

public class StatusFetchByIdDto extends Status{
	@Override
	public String toString() {
		return "FetchByIdDto [applicationId=" + applicationId + ", loanStatus=" + loanStatus + ", appointmentDate="
				+ appointmentDate + "]";
	}
	private int applicationId;
	private String loanStatus;
	private LocalDate appointmentDate;
	public int getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}
	public String getLoanStatus() {
		return loanStatus;
	}
	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}
	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	
	
}
