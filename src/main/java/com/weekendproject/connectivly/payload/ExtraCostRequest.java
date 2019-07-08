package com.weekendproject.connectivly.payload;

import java.util.Date;


public class ExtraCostRequest {
	private Long id;
    private String name;
	private Integer rate;
	private Date createdAt;
	private Date updatedAt;
	private String userId;
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Integer getRate() {
		return rate;
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
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setRate(Integer rate) {
		this.rate = rate;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
