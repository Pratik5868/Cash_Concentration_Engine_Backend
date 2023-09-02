package com.cdac.service;

import java.util.List;

import com.cdac.entity.Company;

//State service interface to provide methods and loose coupling.
public interface CompanyStateService {

	public double getProfitOrLoss(String district, String month);

	public List<Company> getCompanyByDistrict(String district);

	public String getProfitfromDistricts(String district, String month);

}
