package com.cdac.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.entity.Company;
import com.cdac.repository.CompanyRepository;
import com.cdac.service.CompanyCountryService;

//Service implementation class
@Service
public class CompanyCountryServiceImpl implements CompanyCountryService {

	// Company repository reference is autowired.
	@Autowired
	private CompanyRepository companyRepository;

	// Get all company list from database on the basis of state passed.
	@Override
	public List<Company> getCompany(String state) {
		return this.companyRepository.getCompanyByState(state);
	}

	// Profit and loss logic at country level
	@Override
	public double getProfitOrLossByMonth(String state, String month) {
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

	public double calculateTotalBudgetAssign(String state) {
		double totalBudget = 0;

		ArrayList<Company> company = (ArrayList<Company>) this.getCompany(state);
		for (Company comp : company) {
			totalBudget += comp.getBudget();
		}
		return totalBudget;
	}

	public String getProfitfromStates(String state, String month) {
		double valueProfitorLoss = getProfitOrLossByMonth(state, month);
		double valueTotalBudget = calculateTotalBudgetAssign(state);
		if (valueProfitorLoss > valueTotalBudget) {
			return "We are running in a profit with money:- Rs" + valueProfitorLoss + "/-";
		} else if (valueProfitorLoss < valueTotalBudget) {
			return "We are running in a Loss with money:-Rs" + valueProfitorLoss + "/-";
		} else {
			return "We are running within the budget:-Rs" + valueProfitorLoss + "/-";
		}
	}

}
