package com.cdac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.entity.Company;

//CompanyRepository use to give database related operations
@Repository
public interface CompanyRepository extends JpaRepository<Company, String> {

	//Custom queries.
	public List<Company> getCompanyByDistrict(String district);

	public List<Company> getCompanyByState(String state);
	
	public List<Company> getCompanyByMonth(String month);

}
