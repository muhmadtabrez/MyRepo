package com.abc.springmvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.abc.springmvc.model.Company;
import com.abc.springmvc.service.CompanyService;

@RestController
@RequestMapping("/")
public class RestServiceController {

	@Autowired
	CompanyService service;
	
	@Autowired
	MessageSource messageSource;

	/*
	 * This method will list all existing Companies.
	 */
	@RequestMapping(value = { "/service", "/listservice" }, method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Company>  listCompany(ModelMap model) {

		return service.findAllCompanies();
		
	}

	

	/*
	 * This method will be called on form submission, handling POST request for
	 * saving employee in database. It also validates the user input
	 */
	@RequestMapping(value ="/newservice", method = RequestMethod.POST , produces = "application/json")
	public @ResponseBody List<Company> saveCompany(@Valid Company company, BindingResult result,
			ModelMap model) {

		return service.saveCompany(company);
	}

		


	/*
	 * This method will be called on form submission, handling POST request for
	 * updating company in database. It also validates the user input
	 */
	@RequestMapping(value ="/editservice-{companyId}-companyId", method = RequestMethod.POST ,produces = "application/json")
	public @ResponseBody List<Company> updateCompany(@PathVariable String companyId, BindingResult result,
			ModelMap model) {
         Company company=new Company();
        Integer compid=Integer.parseInt(companyId);
        return service.updateCompany(company);
	
	}

	
	/*
	 * This method will delete an Company by it's companyId value.
	 */
	@RequestMapping(value = { "/deleteservice-{companyId}-companyId" }, method = RequestMethod.GET,produces = "application/json")
	public @ResponseBody List<Company> deleteCompany(@PathVariable String companyId ,ModelMap model) {
		return service.deleteCompanyById(companyId);
		
	}


}
