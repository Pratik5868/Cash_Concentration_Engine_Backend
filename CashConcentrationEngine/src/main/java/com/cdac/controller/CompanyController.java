package com.cdac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.entity.Company;
import com.cdac.service.CompanyService;

@RestController
public class CompanyController {
	@Autowired
     public CompanyService companyService;
     
	
	@GetMapping("getAllCompany")
     public List<Company> getAllCompany(){
    	 
    	 return companyService.getAllCompany();
     }
	
	@GetMapping("getById")
	public Company findCompanyById(@RequestParam String companyId) {
		return companyService.getCompanyById(companyId);
	}
	
	@PutMapping("updateCompany/{companyId}")
	public void updateCompanyData(@RequestBody Company company,@PathVariable String companyId) {
		companyService.updateCompany(company,companyId);
	}
	
	@PostMapping("saveCompany")
	public void saveCompany(@RequestBody Company company) {
		companyService.addCompany(company);
	}
	
	@DeleteMapping("deleteData")
	public void deleteCompany(@RequestParam String companyId) {
		companyService.deleteCompanyData(companyId);
	}
}
