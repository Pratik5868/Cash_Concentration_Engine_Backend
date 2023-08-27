package com.cdac.serviceimpl;


import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
		System.out.println("Successfully Deleted>>>>>>!!!!");
	}

	@Override
	public List<Company> getAllCompany() {
		
		return repository.findAll();
	}

	@Override
	public Company getCompanyById(String companyId) {
		
		return repository.findById(companyId).get();
	}
	

}
