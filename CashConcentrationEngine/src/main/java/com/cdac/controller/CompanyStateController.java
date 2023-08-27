package com.cdac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.entity.Company;
import com.cdac.service.CompanyStateService;

@RestController
public class CompanyStateController {
	
	@Autowired
	private CompanyStateService companyServiceImpl;
	
	@GetMapping("getCompanyByDistrict/{district}")
	public List<Company> getCompanyByDistrict(@PathVariable String district){
		return companyServiceImpl.getCompanyByDistrict(district);
	}
	
	
	
	
	@GetMapping("getprofitorlossdata")
	public double getProfitOrLossData(@RequestParam String district,@RequestParam String month) {
		return companyServiceImpl.getProfitOrLoss(district,month);
	}
	
	


}
