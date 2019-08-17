package com.weekendproject.connectivly.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sales_order_product")
public class SalesOrderProduct {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(name = "created_at")
    private Date createdAt;
	
	@Column(name = "updated_at")
    private Date updatedAt;
	
	@Column(name = "code")
    private String code;
	
	@Column(name = "sales_order_id")
    private Long salesOrderId;
	
	@Column(name = "product_id")
	private Long productId;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "available_qty")
	private Integer availableQty;
	
	@Column(name = "price")
	private Double price;
	
	@Column(name = "percent_1")
	private Double percent1;
	
	@Column(name = "percent_2")
	private Double percent2;
	
	@Column(name = "total")
	private Double total;
	
	@Column(name = "user_id")
	private String userId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getSalesOrderId() {
		return salesOrderId;
	}

	public void setSalesOrderId(Long salesOrderId) {
		this.salesOrderId = salesOrderId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getAvailableQty() {
		return availableQty;
	}

	public void setAvailableQty(Integer availableQty) {
		this.availableQty = availableQty;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getPercent1() {
		return percent1;
	}

	public void setPercent1(Double percent1) {
		this.percent1 = percent1;
	}

	public Double getPercent2() {
		return percent2;
	}

	public void setPercent2(Double percent2) {
		this.percent2 = percent2;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
