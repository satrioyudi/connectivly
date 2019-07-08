package com.weekendproject.connectivly.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer_category_customer")
public class CustomerCategoryCustomer {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "customer_category_id", insertable=false, updatable=false)
    private Long customerCategoryId;
	
	@Column(name = "customer_id", insertable=false, updatable=false)
	private Long customerId;
	
	@Column(name = "user_id")
	private String userId;
	
	@ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    private Customers customer;
	
	public CustomerCategoryCustomer() {
		
	}
	
	public CustomerCategoryCustomer(Master master, Customers customer, String userId) {
		this.customerId = customer.getId();
		this.customerCategoryId = master.getId();
		this.userId = userId;
	}

	public Customers getCustomer() {
		return customer;
	}

	public void setCustomer(Customers customer) {
		this.customer = customer;
	}
	
	@ManyToOne
    @JoinColumn(name="customer_category_id", nullable=false)
    private Master master;

	public Master getMaster() {
		return master;
	}

	public void setMaster(Master master) {
		this.master = master;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Long getCustomerCategoryId() {
		return customerCategoryId;
	}

	public void setCustomerCategoryId(Long customerCategoryId) {
		this.customerCategoryId = customerCategoryId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

}
