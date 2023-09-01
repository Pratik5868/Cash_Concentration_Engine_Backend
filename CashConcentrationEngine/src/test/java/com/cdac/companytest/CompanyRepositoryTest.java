package com.cdac.companytest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cdac.entity.Company;
import com.cdac.repository.CompanyRepository;

@SpringBootTest
public class CompanyRepositoryTest {

	@Autowired
	private CompanyRepository companyRepository;

	@Test
	void getCompByDistrict() {
		List<Company> company = companyRepository.getCompanyByDistrict("Jalgaon");
		assertNotNull(company);
	}

	@Test
	void getCompanyUsingState() {
		List<Company> company = companyRepository.getCompanyByState("MH");
		assertNotNull(company);
	}

	@Test
	void getCompByMonth() {
		List<Company> company = companyRepository.getCompanyByMonth("May");
		assertNotNull(company);
	}

}
