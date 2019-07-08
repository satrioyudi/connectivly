package com.weekendproject.connectivly.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "good_received_notes")
public class GoodReceivedNotes {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(name = "code")
    private String code;
	
	@Column(name = "grn_date")
	private Date grnDate;
	
	@Column(name = "global_discount")
	private Double globalDiscount;
	
	@Column(name = "is_approved")
	private Boolean isApproved;
	
	@Column(name = "is_paid")
	private Boolean isPaid;
	
	@Column(name = "created_at")
	private Date createdAt;
	
	@Column(name = "updated_at")
	private Date updatedAt;
	
	@Column(name = "sales_order_supplier")
	private String salesOrderSupplier;
	
	@Column(name = "user_id")
	private String userId;
	
	@Column(name = "approved_at")
	private Date approvedAt;

	public Long getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public Date getGrnDate() {
		return grnDate;
	}

	public Double getGlobalDiscount() {
		return globalDiscount;
	}

	public Boolean getIsApproved() {
		return isApproved;
	}

	public Boolean getIsPaid() {
		return isPaid;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public String getSalesOrderSupplier() {
		return salesOrderSupplier;
	}

	public String getUserId() {
		return userId;
	}

	public Date getApprovedAt() {
		return approvedAt;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setGrnDate(Date grnDate) {
		this.grnDate = grnDate;
	}

	public void setGlobalDiscount(Double globalDiscount) {
		this.globalDiscount = globalDiscount;
	}

	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
	}

	public void setIsPaid(Boolean isPaid) {
		this.isPaid = isPaid;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setSalesOrderSupplier(String salesOrderSupplier) {
		this.salesOrderSupplier = salesOrderSupplier;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setApprovedAt(Date approvedAt) {
		this.approvedAt = approvedAt;
	}


}
