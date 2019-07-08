package com.weekendproject.connectivly.payload;

import java.util.Date;

public class GoodReceivedNotesRequest {
	private Long id;
    private String code;
	private Date grnDate;
	private Double globalDiscount;
	private String isApproved;
	private String isPaid;
	private Date createdAt;
	private Date updatedAt;
	private String salesOrderSupplier;
	private String userId;
	private String approvedAt;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getGrnDate() {
		return grnDate;
	}
	public void setGrnDate(Date grnDate) {
		this.grnDate = grnDate;
	}
	public String getIsApproved() {
		return isApproved;
	}
	public void setIsApproved(String isApproved) {
		this.isApproved = isApproved;
	}
	public String getIsPaid() {
		return isPaid;
	}
	public void setIsPaid(String isPaid) {
		this.isPaid = isPaid;
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
	public String getSalesOrderSupplier() {
		return salesOrderSupplier;
	}
	public void setSalesOrderSupplier(String salesOrderSupplier) {
		this.salesOrderSupplier = salesOrderSupplier;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getApprovedAt() {
		return approvedAt;
	}
	public void setApprovedAt(String approvedAt) {
		this.approvedAt = approvedAt;
	}
	public Double getGlobalDiscount() {
		return globalDiscount;
	}
	public void setGlobalDiscount(Double globalDiscount) {
		this.globalDiscount = globalDiscount;
	}
}
