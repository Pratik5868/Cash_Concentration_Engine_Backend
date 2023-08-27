package com.cdac.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.entity.Company;
import com.cdac.repository.CompanyRepository;
import com.cdac.service.CompanyCountryService;
@Service
public class CompanyCountryServiceImpl implements CompanyCountryService {
	
	@Autowired
	private CompanyRepository companyRepository;

	public List<Company> getCompany(String state) {
		return this.companyRepository.getCompanyByState(state);
	}
	
	
	@Override
	public double getProfitOrLossByMonth(String state,String month) {
		ArrayList<Company> company = (ArrayList<Company>) this.getCompany(state);
		double profit = 0, loss = 0, remainingMonthlyRevenue = 0, totalBudget = 0;
		for (Company comp : company) {
			if (comp.getMonth().equals(month)) {
				remainingMonthlyRevenue += comp.getTotalMonthlyRevenue()
						- (comp.getTotalMonthlySalaries() + comp.getTotalMonthlyAllowances());
				totalBudget += comp.getBudget();
			}
		}
		if (remainingMonthlyRevenue >= totalBudget) {
			return profit = remainingMonthlyRevenue - totalBudget;

		} else {
			return loss = totalBudget - remainingMonthlyRevenue;

		}

	}

}
