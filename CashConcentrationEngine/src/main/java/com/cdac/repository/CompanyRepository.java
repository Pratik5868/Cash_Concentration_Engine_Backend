package com.cdac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String> {

	public List<Company> getCompanyByDistrict(String district);

	public List<Company> getCompanyByState(String state);
	
	public List<Company> getCompanyByMonth(String month);

}
