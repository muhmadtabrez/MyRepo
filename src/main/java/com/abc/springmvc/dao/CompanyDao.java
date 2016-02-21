package com.abc.springmvc.dao;

import java.util.List;

import com.abc.springmvc.model.Company;

public interface CompanyDao {

	Company findByCompanyId(Integer companyId);

	List<Company> saveCompany(Company company);
	List<Company> updateCompany(Company company);
	
	List<Company> deleteCompanyById(Integer companyId);
	
	List<Company> findAllCompany();

	
}
