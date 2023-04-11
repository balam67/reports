package com.reports.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//@Data
@Entity
@Table(name="CITIZEN_PLAN_INFO")
public class CitizenPlanEntity {

	
		@Id 
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer citizenId;
		
		private String gender;
		private String planName;
		private String planStatus;
		private LocalDate planStartDate;
		private LocalDate planEndDate;
		private Double benifitAmount;
		private String denialReason;
		private LocalDate terminatedDate;
		private String terminationReason;
		
		
		  @Override public String toString() { // TODO Auto-generated method stub
		  return "CitizenPlanEntity [gender=" + gender + ", planName=" + planName + ", planStatus=" + planStatus + ", planStartDate ="+ planStartDate + ""
		  		+ ",planEndDate =" +planEndDate+",benifitAmount =" +benifitAmount+ ",denialReason = " +denialReason+",terminatedDate =" +terminatedDate+ ","
		  				+ "terminationReason ="+terminationReason+"]";}
		
		public Integer getCitizenId() {
			return citizenId;
		}
		public void setCitizenId(Integer citizenId) {
			this.citizenId = citizenId;
		}
		public String getCitizenName() {
			return citizenName;
		}
		public void setCitizenName(String citizenName) {
			this.citizenName = citizenName;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getPlanName() {
			return planName;
		}
		public void setPlanName(String planName) {
			this.planName = planName;
		}
		public String getPlanStatus() {
			return planStatus;
		}
		public void setPlanStatus(String planStatus) {
			this.planStatus = planStatus;
		}
		public LocalDate getPlanStartDate() {
			return planStartDate;
		}
		public void setPlanStartDate(LocalDate planStartDate) {
			this.planStartDate = planStartDate;
		}
		public LocalDate getPlanEndDate() {
			return planEndDate;
		}
		public void setPlanEndDate(LocalDate planEndDate) {
			this.planEndDate = planEndDate;
		}
		public Double getBenifitAmount() {
			return benifitAmount;
		}
		public void setBenifitAmount(Double benifitAmount) {
			this.benifitAmount = benifitAmount;
		}
		public String getDenialReason() {
			return denialReason;
		}
		public void setDenialReason(String denialReason) {
			this.denialReason = denialReason;
		}
		public LocalDate getTerminatedDate() {
			return terminatedDate;
		}
		public void setTerminatedDate(LocalDate terminatedDate) {
			this.terminatedDate = terminatedDate;
		}
		public String getTerminationReason() {
			return terminationReason;
		}
		public void setTerminationReason(String terminationReason) {
			this.terminationReason = terminationReason;
		}
		private String citizenName;
		public CitizenPlanEntity(String citizenName, String gender, String planName, String planStatus,
				LocalDate planStartDate, LocalDate planEndDate, Double benifitAmount, String denialReason,
				LocalDate terminatedDate, String terminationReason) {
			super();
			this.citizenName = citizenName;
			this.gender = gender;
			this.planName = planName;
			this.planStatus = planStatus;
			this.planStartDate = planStartDate;
			this.planEndDate = planEndDate;
			this.benifitAmount = benifitAmount;
			this.denialReason = denialReason;
			this.terminatedDate = terminatedDate;
			this.terminationReason = terminationReason;
		}
		
		public CitizenPlanEntity() {
			// TODO Auto-generated constructor stub
		}
		
		
	}

