package com.cdac.service;

import java.util.List;

import com.cdac.entity.Company;

//District service interface to provide methods and loose coupling.
public interface CompanyService {
	public void addCompany(Company company);

	public void updateCompany(Company company, String companyId);

	public void deleteCompanyData(String companyId);

	public List<Company> getAllCompany();

	public Company getCompanyById(String companyId);

}
