package com.abc.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abc.springmvc.dao.CompanyDao;
import com.abc.springmvc.model.Company;

@Service("employeeService")
@Transactional
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyDao dao;
	
	public List<Company> saveCompany(Company company) {
		return dao.saveCompany(company);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	public List<Company>  updateCompany(Company company) {
		Company entity = dao.findByCompanyId(company.getCompanyId());
		if(entity!=null){
			entity.setName(company.getName());
			entity.setAddress(company.getAddress());
			entity.setCity(company.getCity());
			entity.setCountry(company.getCountry());
		}
		return dao.updateCompany(entity);
	
	}

	public List<Company> deleteCompanyById(String companyId) {
		Integer com=Integer.parseInt(companyId);
		return dao.deleteCompanyById(com);
	 }

	public List<Company> findAllCompanies() {
	    return dao.findAllCompany();
	}

	public Company findCompanyById(Integer companyId) {
		return dao.findByCompanyId(companyId);
	}
	

	
	
}
