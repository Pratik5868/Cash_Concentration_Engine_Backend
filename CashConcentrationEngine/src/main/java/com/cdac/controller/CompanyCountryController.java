package com.cdac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.entity.Company;
import com.cdac.service.CompanyCountryService;

@RestController
public class CompanyCountryController {
	
	@Autowired
	private CompanyCountryService companyCountryService;
	
	@GetMapping("getCompanyByState/{state}")
	public List<Company> getCompany(@PathVariable String state){
		return this.companyCountryService.getCompany(state);
	}
	
	@GetMapping("getprofitorlossdatabycountry")
	public double getProfitOrLossDataCountryLevel(@RequestParam String state,@RequestParam String month) {
		return companyCountryService.getProfitOrLossByMonth(state,month);
	}

}
