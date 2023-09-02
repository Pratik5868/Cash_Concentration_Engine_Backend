package com.cdac.companytest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cdac.serviceimpl.CompanyCountryServiceImpl;

@SpringBootTest
public class CompanyCountryServiceTest {
	
	@Autowired
	private CompanyCountryServiceImpl companyCountryService;
	
	@Test
	void getProfitOrLossByMonthTest() {
		double dataTest = companyCountryService.getProfitOrLossByMonth("MH", "May");
		System.out.println(dataTest);
		assertNotNull(dataTest);
	}

}
