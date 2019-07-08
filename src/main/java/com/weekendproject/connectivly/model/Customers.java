package com.weekendproject.connectivly.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customers {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(name = "store_name")
    private String storeName;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "area_id")
	private Integer areaId;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "latitude")
	private Double latitude;
	
	@Column(name = "longitude")
	private Double longitude;
	
	@Column(name = "created_at")
	private Date createdAt;
	
	@Column(name = "updated_at")
	private Date updatedAt;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "npwp")
	private String npwp;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "user_id")
	private String userId;
	
	@Column(name = "link_code")
	private String linkCode;
	
	@Column(name = "code_expire_date")
	private String codeExpireDate;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(
	  name = "customer_category_customer", 
	  joinColumns = @JoinColumn(name = "customer_id"),
	  inverseJoinColumns = @JoinColumn(name = "customer_category_id"))
	Set<Master> custCategories;
	
	public Set<Master> getCustCategories() {
		return custCategories;
	}

	public void setCustCategories(Set<Master> custCategories) {
		this.custCategories = custCategories;
	}

	/*@OneToMany(mappedBy = "customer")
    private Set<CustomerCategoryCustomer> customerCats;

	public Set<CustomerCategoryCustomer> getCustomerCats() {
		return customerCats;
	}

	public void setCustomerCats(Set<CustomerCategoryCustomer> customerCats) {
		this.customerCats = customerCats;
	}*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNpwp() {
		return npwp;
	}

	public void setNpwp(String npwp) {
		this.npwp = npwp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLinkCode() {
		return linkCode;
	}

	public void setLinkCode(String linkCode) {
		this.linkCode = linkCode;
	}

	public String getCodeExpireDate() {
		return codeExpireDate;
	}

	public void setCodeExpireDate(String codeExpireDate) {
		this.codeExpireDate = codeExpireDate;
	}

}
