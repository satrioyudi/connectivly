package com.weekendproject.connectivly.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_purchase_order")
public class ProductPurchaseOrder {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(name = "product_id")
    private Long productId;
	
	@Column(name = "purchase_order_id")
    private Long purchaseOrderId;
	
	@Column(name = "quantity")
    private Integer quantity;
	
	@Column(name = "quantity_left")
    private Integer quantityLeft;
	
	@Column(name = "deleted_at")
    private Date deletedAt;
	
	@Column(name = "user_id")
    private String userId;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getPurchaseOrderId() {
		return purchaseOrderId;
	}

	public void setPurchaseOrderId(Long purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}

	public Date getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getQuantityLeft() {
		return quantityLeft;
	}

	public void setQuantityLeft(Integer quantityLeft) {
		this.quantityLeft = quantityLeft;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
