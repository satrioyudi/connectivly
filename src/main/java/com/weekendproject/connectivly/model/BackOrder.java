package com.weekendproject.connectivly.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "back_order")
public class BackOrder {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(name = "sales_invoice_id")
    private Long salesInvoiceId;
	
	@Column(name = "customer_id")
	private Long customerId;
	
	@Column(name = "product_id")
	private Long productId;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "back_order_date")
	private Date backOrderDate;
	
	@Column(name = "created_at")
	private Date createdAt;
	
	@Column(name = "updated_at")
	private Date updatedAt;
	
	@Column(name = "day_counter")
	private Integer dayCounter;
	
	@Column(name = "user_id")
	private String userId;

	public Long getId() {
		return id;
	}

	public Long getSalesInvoiceId() {
		return salesInvoiceId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public Long getProductId() {
		return productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public Date getBackOrderDate() {
		return backOrderDate;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public Integer getDayCounter() {
		return dayCounter;
	}

	public String getUserId() {
		return userId;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setSalesInvoiceId(Long salesInvoiceId) {
		this.salesInvoiceId = salesInvoiceId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public void setBackOrderDate(Date backOrderDate) {
		this.backOrderDate = backOrderDate;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setDayCounter(Integer dayCounter) {
		this.dayCounter = dayCounter;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	

}
