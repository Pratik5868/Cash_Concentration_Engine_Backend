package com.cdac.serviceimpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.Exception.BusinessException;
import com.cdac.entity.Company;
import com.cdac.repository.CompanyRepository;
import com.cdac.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	public CompanyRepository repository;

	@Override
	public void addCompany(Company company) {
		
			repository.save(company);
		
	}

	@Override
	public void updateCompany(Company company, String companyId) {
		
			Company companyForUpdate = this.repository.findById(companyId).get();
			companyForUpdate.setDataAddedDate(LocalDateTime.now().toString());
			companyForUpdate.setTotalMonthlyRevenue(company.getTotalMonthlyRevenue());
			companyForUpdate.setTotalMonthlyAllowances(company.getTotalMonthlyAllowances());
			companyForUpdate.setTotalMonthlySalaries(company.getTotalMonthlySalaries());
			companyForUpdate.setBudget(company.getBudget());
			this.repository.save(companyForUpdate);

		

	}

	@Override
	public void deleteCompanyData(String companyId) {

		repository.deleteById(companyId);

	}

	@Override
	public List<Company> getAllCompany() {
		
			return repository.findAll();
			

	}

	@Override
	public Company getCompanyById(String companyId) {

		return repository.findById(companyId).get();

	}

//	public boolean isCompanyEmpty(Company company) {
//		if (company.getCompanyId().length() == 0 || company.getCompanyName().length() == 0
//				|| company.getDataAddedDate().length() == 0 || company.getDistrict().length() == 0
//				|| company.getMonth().length() == 0 || company.getState().length() == 0
//				|| company.getTotalMonthlyAllowances() == 0 || company.getTotalMonthlyRevenue() == 0
//				|| company.getTotalMonthlySalaries() == 0) {
//			return true;
//		}
//		return false;
//	}
//
//	public boolean dataNotProvided(Object object) {
//		if (object == null)
//			return true;
//		return false;
//	}

}
