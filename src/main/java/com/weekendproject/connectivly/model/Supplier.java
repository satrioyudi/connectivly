package com.weekendproject.connectivly.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "suppliers")
public class Supplier {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(name = "name")
    private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "created_at")
	private Date createdAt;
	
	@Column(name = "updated_at")
	private Date updatedAt;
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "province")
	private String province;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "postal_code")
	private String postalCode;
	
	@Column(name = "user_id")
	private String userId;
	
	@Column(name = "measurement_id")
	private Long measurementId;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getProvince() {
		return province;
	}

	public String getCity() {
		return city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getUserId() {
		return userId;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Long getMeasurementId() {
		return measurementId;
	}

	public void setMeasurementId(Long measurementId) {
		this.measurementId = measurementId;
	}

}
