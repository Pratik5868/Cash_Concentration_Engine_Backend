package com.cdac.service;

import java.util.List;

import com.cdac.entity.Company;

//Country service interface to provide methods and loose coupling.
public interface CompanyCountryService {

	public double getProfitOrLossByMonth(String state, String month);

	public List<Company> getCompany(String state);

}
