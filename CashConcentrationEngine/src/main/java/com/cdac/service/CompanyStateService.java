package com.cdac.service;

import java.util.List;

import com.cdac.entity.Company;

public interface CompanyStateService {

	public double getProfitOrLoss(String district, String month);

	public List<Company> getCompanyByDistrict(String district);

}
