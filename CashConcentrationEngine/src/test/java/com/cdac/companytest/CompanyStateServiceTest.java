package com.cdac.companytest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cdac.serviceimpl.CompanyStateServiceImpl;

@SpringBootTest
public class CompanyStateServiceTest {
	
	@Autowired
	private CompanyStateServiceImpl companyStateService;
	
	@Test
	void getProfitOrLossTest() {
		String dataTest = companyStateService.getProfitfromDistricts("Kar", "May");
		System.out.println(dataTest);
		assertNotNull(dataTest);
	}

	
}
