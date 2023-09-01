package com.cdac.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.entity.Company;
import com.cdac.service.CompanyCountryService;

//CompanyCountryController class use at Country level
@RestController
public class CompanyCountryController {

	// CompanyCountry Service interface is use to autowired for loose coupling
	@Autowired
	private CompanyCountryService companyCountryService;

	// GetMapping use to fetch all the data from database based on state value pass
	// as path variable.
	@GetMapping("getCompanyByState/{state}")
	public List<Company> getCompany(@Valid @PathVariable String state) {
		return this.companyCountryService.getCompany(state);
	}

	// GetMapping use to fetch the profit from database based on the state and month
	// passed.
	@GetMapping("getprofitorlossdatabycountry")
	public double getProfitOrLossDataCountryLevel(@Valid @RequestParam String state,
			@Valid @RequestParam String month) {
		return companyCountryService.getProfitOrLossByMonth(state, month);
	}

}
