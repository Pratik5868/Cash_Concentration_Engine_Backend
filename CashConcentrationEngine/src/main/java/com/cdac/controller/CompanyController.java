package com.cdac.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.Exception.BusinessException;
import com.cdac.Exception.ControllerException;
import com.cdac.entity.Company;
import com.cdac.service.CompanyService;

//CompanyController Class at District level.
@RestController
public class CompanyController {

	// Company Service interface is use to autowired for loose coupling
	@Autowired
	public CompanyService companyService;

	// GetMapping use to fetch all the data from database.
	@GetMapping("getAllCompany")
	public List<Company> getAllCompany() {
		return companyService.getAllCompany();

	}

	// GetMapping use to fetch the data from database based on userid
	@GetMapping("getById")
	public Company findCompanyById(@Valid @RequestParam String companyId) {
		return companyService.getCompanyById(companyId);
	}

	/* PutMapping use to update the company while company id is provided to find the
	 data which to be updated.*/
	@PutMapping("updateCompany/{companyId}")
	public void updateCompanyData(@RequestBody Company company, @PathVariable String companyId) {
		companyService.updateCompany(company, companyId);
	}
    
	
	//PostMapping is use to save the company.
	@PostMapping("saveCompany")
	public void saveCompany(@Valid @RequestBody Company company) {
		companyService.addCompany(company);

	}
    
	//DeleteMapping is use to delete the company from database using companyid.
	@DeleteMapping("deleteData")
	public void deleteCompany(
			@Valid @RequestParam String companyId) {
		companyService.deleteCompanyData(companyId);

	}
}
