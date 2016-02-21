package com.abc.springmvc.service;

import java.util.List;

import com.abc.springmvc.model.Company;

public interface CompanyService {

	
	
	List<Company> saveCompany(Company company);
	
	List<Company>  updateCompany(Company company);
	
	List<Company> deleteCompanyById(String companyId);

	List<Company> findAllCompanies(); 
	
	Company findCompanyById(Integer companyId);

	
	
}
