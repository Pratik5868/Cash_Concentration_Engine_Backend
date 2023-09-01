package com.cdac.serviceimpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.Exception.BusinessException;
import com.cdac.entity.Company;
import com.cdac.repository.CompanyRepository;
import com.cdac.service.CompanyService;

//Service implementation class
@Service
public class CompanyServiceImpl implements CompanyService {

	// Company repository reference is autowired.
	@Autowired
	public CompanyRepository repository;

	// Add company method
	@Override
	public void addCompany(Company company) {

		repository.save(company);

	}

	// Update company from database.
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

	// Delete company from database using company_id
	@Override
	public void deleteCompanyData(String companyId) {

		repository.deleteById(companyId);

	}

	// Get all the entire companies from database based on list format.
	@Override
	public List<Company> getAllCompany() {

		return repository.findAll();

	}

	// Get Company on the basis of company_id pass.
	@Override
	public Company getCompanyById(String companyId) {

		return repository.findById(companyId).get();

	}

}
