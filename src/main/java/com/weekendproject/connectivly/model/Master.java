package com.weekendproject.connectivly.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "master")
public class Master {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(name = "brands")
    private String brands;
	
	@Column(name = "customer_category")
	private String customerCategory;
	
	@Column(name = "measurements")
	private String measurements;
	
	@Column(name = "item_category")
	private String itemCategory;
	
	@Column(name = "user_id")
	private String userId;
	
	@Column(name = "code_master")
	private String codeMaster;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "custCategories", cascade = CascadeType.ALL)
	private Set<Customers> customers = new HashSet<Customers>(0);
	
//	public Set<Customers> getCustomers() {
//		return customers;
//	}
	
	public void setCustomers(Set<Customers> customers) {
		this.customers = customers;
	}
	
	@OneToMany(mappedBy = "masterBrands")
	private Set<Products> productsBrands;
	
	@OneToMany(mappedBy = "masterMeasurements")
	private Set<Products> productsMeasurements;
	
	@OneToMany(mappedBy = "masterItemCategory")
	private Set<Products> productsItemCategory;

	public Master() {
	}

	public Master(String brands, String customerCategory, String measurements, String itemCategory, String userId) {
		this.brands = brands;
		this.customerCategory = customerCategory;
		this.measurements = measurements;
		this.itemCategory = itemCategory;
		this.userId = userId;
	}

	public Master(String brands, String customerCategory, String measurements, String itemCategory, String userId,
			Set<Customers> customers) {
		this.brands = brands;
		this.customerCategory = customerCategory;
		this.measurements = measurements;
		this.itemCategory = itemCategory;
		this.userId = userId;
		this.customers = customers;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrands() {
		return brands;
	}

	public void setBrands(String brands) {
		this.brands = brands;
	}

	public String getCustomerCategory() {
		return customerCategory;
	}

	public void setCustomerCategory(String customerCategory) {
		this.customerCategory = customerCategory;
	}

	public String getMeasurements() {
		return measurements;
	}

	public void setMeasurements(String measurements) {
		this.measurements = measurements;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCodeMaster() {
		return codeMaster;
	}

	public void setCodeMaster(String codeMaster) {
		this.codeMaster = codeMaster;
	}

}
