package com.cdac.serviceimpl;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.entity.Company;
import com.cdac.repository.CompanyRepository;
import com.cdac.service.CompanyStateService;

@Service
public class CompanyStateServiceImpl implements CompanyStateService {

	@Autowired
	private CompanyRepository companyRepository;

	public List<Company> getCompanyByDistrict(String district) {
		return this.companyRepository.getCompanyByDistrict(district);
	}

//	public List<Company> getCompanyByMonth(String month) {
//		return this.companyRepository.getCompanyByMonth(month);
//	}

	public double getProfitOrLoss(String district, String month) {
		double profit = 0, loss = 0;
		ArrayList<Company> company = (ArrayList<Company>) getCompanyByDistrict(district);
		System.out.println(company);
		for (Company comp : company) {
			if (comp.getMonth().equalsIgnoreCase(month)) {
				double remainingMonthlyRevenue = comp.getTotalMonthlyRevenue()
						- (comp.getTotalMonthlySalaries() + comp.getTotalMonthlyAllowances());
				if (remainingMonthlyRevenue >= comp.getBudget()) {
					profit = remainingMonthlyRevenue - comp.getBudget();
					return profit;
				} else {
					loss = comp.getBudget() - remainingMonthlyRevenue;

				}
			}
		}

		return loss;
	}

//	public double getProfitOrLossByMonth(String month) {
//		ArrayList<Company> company = (ArrayList<Company>) this.getCompanyByMonth(month);
//		double profit = 0, loss = 0, remainingMonthlyRevenue = 0, totalBudget = 0;
//		for (Company comp : company) {
//			if (comp.getMonth().equals(month)) {
//				remainingMonthlyRevenue += comp.getTotalMonthlyRevenue()
//						- (comp.getTotalMonthlySalaries() + comp.getTotalMonthlyAllowances());
//				totalBudget += comp.getBudget();
//			}
//		}
//		if (remainingMonthlyRevenue >= totalBudget) {
//			return profit = remainingMonthlyRevenue - totalBudget;
//
//		} else {
//			return loss = totalBudget - remainingMonthlyRevenue;
//
//		}
//
//	}

}
