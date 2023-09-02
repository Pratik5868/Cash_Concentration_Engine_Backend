package com.cdac.serviceimpl;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.entity.Company;
import com.cdac.repository.CompanyRepository;
import com.cdac.service.CompanyStateService;

//Service implementation class
@Service
public class CompanyStateServiceImpl implements CompanyStateService {

	// Company repository reference is autowired.
	@Autowired
	private CompanyRepository companyRepository;

	// Get all company list from database on the basis of district passed.
	@Override
	public List<Company> getCompanyByDistrict(String district) {
		return this.companyRepository.getCompanyByDistrict(district);
	}

	// Profit and loss logic at state level
	@Override
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

	public double calculateTotalBudgetAssign(String district) {
		double totalBudget = 0;

		ArrayList<Company> company = (ArrayList<Company>) getCompanyByDistrict(district);
		for (Company comp : company) {
			totalBudget += comp.getBudget();
		}
		return totalBudget;
	}

	public String getProfitfromDistricts(String district, String month) {
		double valueProfitorLoss = getProfitOrLoss(district, month);
		double valueTotalBudget = calculateTotalBudgetAssign(district);
		if (valueProfitorLoss > valueTotalBudget) {
			return "We are running in a profit with money:- Rs" + valueProfitorLoss+"/-";
		} else if (valueProfitorLoss < valueTotalBudget) {
			return "We are running in a Loss with money:-Rs" + valueProfitorLoss+"/-";
		} else {
			return "We are running within the budget:-Rs" + valueProfitorLoss+"/-";
		}
	}

}
