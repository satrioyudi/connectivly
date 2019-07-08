package com.weekendproject.connectivly.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_history")
public class ProductHistory {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(name = "product_id")
    private Long productId;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "code")
	private String code;

	@Column(name = "note")
	private String note;
	
	@Column(name = "defect_stock")
	private Integer defectStock;
	
	@Column(name = "remains")
	private Integer remains;
	
	@Column(name = "created_at")
	private Date createdAt;
	
	@Column(name = "updated_at")
	private Date updatedAt;
	
	@Column(name = "mutator")
	private String mutator;
	
	@Column(name = "purchase_order_id")
	private Long purchaseOrderId;
	
	@Column(name = "good_received_note_id")
	private Long goodReceivedNoteId;
	
	@Column(name = "sales_order_id")
	private Long salesOrderId;
	
	@Column(name = "sales_return_id")
	private Long salesReturnId;
	
	@Column(name = "purchase_return_id")
	private Long purchaseReturnId;
	
	@Column(name = "customer_id")
	private Long customerId;
	
	@Column(name = "previous_qty")
	private Integer previousQty;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "value")
	private Integer value;
	
	@Column(name = "created_by")
	private String createdBy;
	
	@Column(name = "direct_sales_id")
	private Long directSalesId;
	
	@Column(name = "user_id")
	private String userId;
	
	@Column(name = "previous_defect")
	private Integer previousDefect;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getDefectStock() {
		return defectStock;
	}

	public void setDefectStock(Integer defectStock) {
		this.defectStock = defectStock;
	}

	public Integer getRemains() {
		return remains;
	}

	public void setRemains(Integer remains) {
		this.remains = remains;
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

	public String getMutator() {
		return mutator;
	}

	public void setMutator(String mutator) {
		this.mutator = mutator;
	}

	public Long getPurchaseOrderId() {
		return purchaseOrderId;
	}

	public void setPurchaseOrderId(Long purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}

	public Long getGoodReceivedNoteId() {
		return goodReceivedNoteId;
	}

	public void setGoodReceivedNoteId(Long goodReceivedNoteId) {
		this.goodReceivedNoteId = goodReceivedNoteId;
	}

	public Long getSalesOrderId() {
		return salesOrderId;
	}

	public void setSalesOrderId(Long salesOrderId) {
		this.salesOrderId = salesOrderId;
	}

	public Long getSalesReturnId() {
		return salesReturnId;
	}

	public void setSalesReturnId(Long salesReturnId) {
		this.salesReturnId = salesReturnId;
	}

	public Long getPurchaseReturnId() {
		return purchaseReturnId;
	}

	public void setPurchaseReturnId(Long purchaseReturnId) {
		this.purchaseReturnId = purchaseReturnId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Integer getPreviousQty() {
		return previousQty;
	}

	public void setPreviousQty(Integer previousQty) {
		this.previousQty = previousQty;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Long getDirectSalesId() {
		return directSalesId;
	}

	public void setDirectSalesId(Long directSalesId) {
		this.directSalesId = directSalesId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getPreviousDefect() {
		return previousDefect;
	}

	public void setPreviousDefect(Integer previousDefect) {
		this.previousDefect = previousDefect;
	}
	
}
