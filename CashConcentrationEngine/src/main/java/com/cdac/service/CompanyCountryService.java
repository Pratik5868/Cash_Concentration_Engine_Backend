package com.cdac.service;

import java.util.List;

import com.cdac.entity.Company;

public interface CompanyCountryService {
	
	public double getProfitOrLossByMonth(String state,String month);

	public List<Company> getCompany(String state);


}
