package com.cdac.serviceimpl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.Exception.CompanyDataEmptyException;
import com.cdac.Exception.DataNotProvidedException;
import com.cdac.entity.Company;
import com.cdac.repository.CompanyRepository;
import com.cdac.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	public CompanyRepository repository;

	@Override
	public void addCompany(Company company) {
		if (isCompanyEmpty(company))
			throw new CompanyDataEmptyException("Not provided Company Data..!");
		else
			repository.save(company);
	}

	@Override
	public void updateCompany(Company company, String companyId) {
		if (isCompanyEmpty(company)) {
			throw new CompanyDataEmptyException("Please provide company object properly.");
		} else if (dataNotProvided(companyId)) {
			throw new DataNotProvidedException("Please provide company related data properly.");
		} else {
			Company companyForUpdate = this.repository.findById(companyId).get();
			companyForUpdate.setDataAddedDate(LocalDateTime.now().toString());
			companyForUpdate.setTotalMonthlyRevenue(company.getTotalMonthlyRevenue());
			companyForUpdate.setTotalMonthlyAllowances(company.getTotalMonthlyAllowances());
			companyForUpdate.setTotalMonthlySalaries(company.getTotalMonthlySalaries());
			companyForUpdate.setBudget(company.getBudget());
			this.repository.save(companyForUpdate);
		}

	}

	@Override
	public void deleteCompanyData(String companyId) {
		if (dataNotProvided(companyId)) {
			throw new DataNotProvidedException("Please provide company related data properly.");
		} else {
			repository.deleteById(companyId);
		}
			

	}

	@Override
	public List<Company> getAllCompany() {

		return repository.findAll();
	}

	@Override
	public Company getCompanyById(String companyId) {

		return repository.findById(companyId).get();
	}

	public boolean isCompanyEmpty(Company company) {
		if (company == null) {
			return true;
		}
		return false;
	}

	public boolean dataNotProvided(Object object) {
		if (object == null)
			return true;
		return false;
	}

}
