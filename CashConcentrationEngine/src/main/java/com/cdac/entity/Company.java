package com.cdac.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
//Company Entity Class
@Table
@Entity
public class Company {

	@Id
	@Column(name = "CompanyID")
	@NotEmpty(message = "CompanyId should not be  null/blank.")
	private String companyId;

	@Column(name = "CompanyName")
	@NotEmpty(message = "CompanyName should not be  null/blank.")
	private String companyName;

	@Column(name = "DataAddedDate")
	@NotEmpty(message = "Date should not be  null/blank.")
	private String dataAddedDate;

	@Column(name = "Month")
	@NotEmpty(message = "Month should not be  null/blank.")
	private String month;

	@Column(name = "Total_Monthly_Revenue")
	private double totalMonthlyRevenue;

	@Column(name = "Total_Monthly_Salary")
	private double totalMonthlySalaries;

	@Column(name = "Total_Monthly_Allowance")
	private double totalMonthlyAllowances;

	@Column(name = "Monthly_Budget")
	private double budget;

	@Column(name = "State")
	@NotEmpty(message = "State should not be blank")
	private String state;

	@Column(name = "District")
	@NotEmpty(message = "District should not be blank")
	private String district;

	public Company() {

	}

	public Company(String companyId, String companyName, String dataAddedDate, String month, double totalMonthlyRevenue,
			double totalMonthlySalaries, double totalMonthlyAllowances, double budget, String state, String district) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.dataAddedDate = dataAddedDate;
		this.month = month;
		this.totalMonthlyRevenue = totalMonthlyRevenue;
		this.totalMonthlySalaries = totalMonthlySalaries;
		this.totalMonthlyAllowances = totalMonthlyAllowances;
		this.budget = budget;
		this.state = state;
		this.district = district;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDataAddedDate() {
		return dataAddedDate;
	}

	public void setDataAddedDate(String dataAddedDate) {
		this.dataAddedDate = dataAddedDate;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public double getTotalMonthlyRevenue() {
		return totalMonthlyRevenue;
	}

	public void setTotalMonthlyRevenue(double totalMonthlyRevenue) {
		this.totalMonthlyRevenue = totalMonthlyRevenue;
	}

	public double getTotalMonthlySalaries() {
		return totalMonthlySalaries;
	}

	public void setTotalMonthlySalaries(double totalMonthlySalaries) {
		this.totalMonthlySalaries = totalMonthlySalaries;
	}

	public double getTotalMonthlyAllowances() {
		return totalMonthlyAllowances;
	}

	public void setTotalMonthlyAllowances(double totalMonthlyAllowances) {
		this.totalMonthlyAllowances = totalMonthlyAllowances;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", companyName=" + companyName + ", dataAddedDate=" + dataAddedDate
				+ ", month=" + month + ", totalMonthlyRevenue=" + totalMonthlyRevenue + ", totalMonthlySalaries="
				+ totalMonthlySalaries + ", totalMonthlyAllowances=" + totalMonthlyAllowances + ", budget=" + budget
				+ ", state=" + state + ", district=" + district + "]";
	}

}
