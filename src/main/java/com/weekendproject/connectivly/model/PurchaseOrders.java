package com.weekendproject.connectivly.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "purchase_orders")
public class PurchaseOrders {
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(name = "created_at")
    private Date createdAt;
	
	@Column(name = "updated_at")
    private Date updatedAt;
	
	@Column(name = "po_number")
    private String poNumber;
	
	@Column(name = "po_date")
    private Date poDate;
	
	@Column(name = "is_approved")
    private Boolean isApproved;
	
	@Column(name = "supplier_id")
    private Long supplierId;
	
	@Column(name = "user_id")
    private String userId;
	
	@Column(name = "approved_at")
    private Date approvedAt;
	
	@Column(name = "is_linked")
    private String isLinked;
	
	@Column(name = "sales_order_id")
    private Long salesOrderId;

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

	public String getPoNumber() {
		return poNumber;
	}

	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}

	public Date getPoDate() {
		return poDate;
	}

	public void setPoDate(Date poDate) {
		this.poDate = poDate;
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public Date getApprovedAt() {
		return approvedAt;
	}

	public void setApprovedAt(Date approvedAt) {
		this.approvedAt = approvedAt;
	}

	public String getIsLinked() {
		return isLinked;
	}

	public void setIsLinked(String isLinked) {
		this.isLinked = isLinked;
	}

	public Long getSalesOrderId() {
		return salesOrderId;
	}

	public void setSalesOrderId(Long salesOrderId) {
		this.salesOrderId = salesOrderId;
	}

	public Boolean getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
