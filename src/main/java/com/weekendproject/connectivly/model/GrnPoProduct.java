package com.weekendproject.connectivly.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "grn_po_product")
public class GrnPoProduct {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(name = "good_received_note_id")
    private Long goodReceivedNoteId;
	
	@Column(name = "purchase_order_id")
	private Long purchaseOrderId;
	
	@Column(name = "product_id")
	private Long productId;
	
	@Column(name = "po_number")
	private String poNumber;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "real_qty")
	private Integer real;
	
	@Column(name = "price")
	private Double price;
	
	@Column(name = "percent1")
	private Double percent1;
	
	@Column(name = "percent2")
	private Double percent2;
	
	@Column(name = "total")
	private String total;
	
	@Column(name = "created_at")
	private Date createdAt;
	
	@Column(name = "updated_at")
	private Date updatedAt;
	
	@Column(name = "item_cost")
	private Double itemCost;
	
	@Column(name = "user_id")
	private String userId;
	
	@Column(name = "selling_price")
	private Double sellingPrice;
	
	@Column(name = "selling_percent")
	private Double sellingPercent;

	public Long getId() {
		return id;
	}

	public Long getGoodReceivedNoteId() {
		return goodReceivedNoteId;
	}

	public Long getPurchaseOrderId() {
		return purchaseOrderId;
	}

	public Long getProductId() {
		return productId;
	}

	public String getPoNumber() {
		return poNumber;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public Integer getReal() {
		return real;
	}

	public Double getPrice() {
		return price;
	}

	public Double getPercent1() {
		return percent1;
	}

	public Double getPercent2() {
		return percent2;
	}

	public String getTotal() {
		return total;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public Double getItemCost() {
		return itemCost;
	}

	public String getUserId() {
		return userId;
	}

	public Double getSellingPrice() {
		return sellingPrice;
	}

	public Double getSellingPercent() {
		return sellingPercent;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setGoodReceivedNoteId(Long goodReceivedNoteId) {
		this.goodReceivedNoteId = goodReceivedNoteId;
	}

	public void setPurchaseOrderId(Long purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public void setReal(Integer real) {
		this.real = real;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setPercent1(Double percent1) {
		this.percent1 = percent1;
	}

	public void setPercent2(Double percent2) {
		this.percent2 = percent2;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setItemCost(Double itemCost) {
		this.itemCost = itemCost;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setSellingPrice(Double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public void setSellingPercent(Double sellingPercent) {
		this.sellingPercent = sellingPercent;
	}

}
