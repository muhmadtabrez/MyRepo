package com.abc.springmvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.abc.springmvc.model.Company;
import com.abc.springmvc.service.CompanyService;

@Controller
@RequestMapping("/")
public class AppController {

	@Autowired
	CompanyService service;
	
	@Autowired
	MessageSource messageSource;

	/*
	 * This method will list all existing Companies.
	 */
	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listCompany(ModelMap model) {

		List<Company> company = service.findAllCompanies();
		model.addAttribute("companies", company);
		return "allcompanies";
	}

	/*
	 * This method will provide the medium to add a new company.
	 */
	@RequestMapping(value ="/new", method = RequestMethod.GET)
	public String newCompany(ModelMap model) {
		Company company = new Company();
		model.addAttribute("company", company);
		model.addAttribute("edit", false);
		return "registration";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * saving company in database. It also validates the user input
	 */
	@RequestMapping(value ="/new", method = RequestMethod.POST)
	public String saveCompany(@Valid Company company, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			
			return "registration";
		}
		List<Company> companies=service.saveCompany(company);
		model.addAttribute("companies",companies);
		
		return "allcompanies";
	}

		


	@RequestMapping(value ="/edit-{companyId}-companyId", method= RequestMethod.GET)
	public String editCompany(@PathVariable String companyId, ModelMap model) {
		Integer  compid=Integer.parseInt(companyId);
		Company existcompany = service.findCompanyById(compid);
		model.addAttribute("company", existcompany);
		model.addAttribute("edit", true);
		return "registration";
	}
	
	/*
	 * This method will be called on form submission, handling POST request for
	 * updating company in database. It also validates the user input
	 */
	@RequestMapping(value ="/edit-{companyId}-companyId", method = RequestMethod.POST)
	public String updateCompany(@PathVariable String companyId, BindingResult result,
			ModelMap model) {
         Company company=new Company();
         Integer compid=Integer.parseInt(companyId);
         company.setCompanyId(compid);
		if (result.hasErrors()) {
			return "registration";
		}

		
		List<Company> existcompany = service.updateCompany(company);
		model.addAttribute("companies", existcompany);
		model.addAttribute("success", "Company " + company.getName()	+ " updated successfully");
		return "allcompanies";
	}

	
	/*
	 * This method will delete an Company by it's CompanyId value.
	 */
	@RequestMapping(value = { "/delete-{companyId}-companyId" }, method = RequestMethod.GET)
	public String deleteCompany(@PathVariable String companyId ,ModelMap model) {
		List<Company> companies=service.deleteCompanyById(companyId);
		model.addAttribute("companies",companies);
		return "allcompanies";
	}

}
