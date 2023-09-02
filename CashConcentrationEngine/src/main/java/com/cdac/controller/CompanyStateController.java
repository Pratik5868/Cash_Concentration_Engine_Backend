package com.cdac.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.entity.Company;
import com.cdac.service.CompanyStateService;

//CompanyStateController class use at Country level
@RestController
public class CompanyStateController {

	// CompanyState Service interface is use to autowired for loose coupling
	@Autowired
	private CompanyStateService companyServiceImpl;

	// GetMapping use to fetch all the data from database based on district value
	// pass as path variable.
	@GetMapping("getCompanyByDistrict/{district}")
	public List<Company> getCompanyByDistrict(@Valid @PathVariable String district) {
		return companyServiceImpl.getCompanyByDistrict(district);
	}

	/*
	 * GetMapping use to fetch the profit from database based on the state and month
	 * passed.
	 */
	@GetMapping("getprofitorlossdata")
	public String getProfitOrLossData(@Valid @RequestParam String district, @Valid @RequestParam String month) {
		return companyServiceImpl.getProfitfromDistricts(district, month);
	}

}
