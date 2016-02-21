package com.abc.springmvc.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.abc.springmvc.model.Company;

@Repository("CompanyDao")
public class CompanyDaoImpl extends AbstractDao<Integer, Company> implements
		CompanyDao {

	public List<Company> saveCompany(Company company) {
		
		persist(company);
		List<Company> companies= findAllCompany();
		return companies;
	}

	public List<Company> findAllCompany() {
		Criteria criteria = createEntityCriteria();
		List<Company> list2 = (List<Company>) criteria.list();
		List<Company> list = list2;
		return list;
	}

	public Company findByCompanyId(Integer companyId) {
		return getByKey(companyId);
	}

	public List<Company> updateCompany(Company company) {
		   update(company);
		   List<Company> companies= findAllCompany();
		
		return companies;

	}

	public List<Company> deleteCompanyById(Integer companyId) {
		String flag=null;
		List<Company> companies=new ArrayList<Company>();
		Query query = getSession().createSQLQuery(
				"delete from Company where companyId = :companyId");
		query.setInteger("companyId", companyId);
		int a=query.executeUpdate();
       if(a>0){
    	  companies= findAllCompany();
       }
       
		return companies;
	}
}
