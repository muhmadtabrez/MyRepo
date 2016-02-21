package com.abc.springmvc.model;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="Company")
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int companyId;

	@Size(min=3, max=50)
	@Column(name = "NAME", nullable = false)
	private String name;

	@Size(min=3, max=50)
	@Column(name = "ADDRESS", nullable = false)
	private String address;

	@Size(min=3, max=50)
	@Column(name = "CITY", nullable = false)
	private String city;
	
	@Size(min=3, max=50)
	@Column(name = "COUNTRY", nullable = false)
	private String country;
	@Size(min=3, max=50)
	@Column(name = "EMAIL", nullable = false)
	private String  email;
	@Size(min=3, max=10)
	@Column(name = "PHONENUMBER", nullable = false)
	private Integer  phoneNumber;
	@Size(min=3, max=50)

	 public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
