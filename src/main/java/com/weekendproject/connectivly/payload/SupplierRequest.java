package com.weekendproject.connectivly.payload;

import java.util.Date;

public class SupplierRequest {
    private Long id;
    private String name;
	private String phone;
	private String address;
	private String email;
	private Date createdAt;
	private Date updatedAt;
	private String userId;
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddress() {
		return address;
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
	public String getUserId() {
		return userId;
	}
}
