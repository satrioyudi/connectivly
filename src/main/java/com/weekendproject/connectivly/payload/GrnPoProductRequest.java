package com.weekendproject.connectivly.payload;

import java.util.Date;
import java.util.List;

import com.weekendproject.connectivly.model.GrnPoProduct;

public class GrnPoProductRequest {
	private Long id;
    private Long goodReceivedNoteId;
	private Long purchaseOrderId;
	private Long productId;
	private Long brandId;
	private String poNumber;
	private String productName;
	private String brandName;
	private Integer quantity;
	private Integer real;
	private Integer price;
	private Double percent1;
	private Double percent2;
	private String total;
	private Date createdAt;
	private Date updatedAt;
	private Double itemCost;
	private Date userId;
	private Double sellingPrice;
	private Double sellingPercent;
	private List<GrnPoProduct> grnPoList;
	
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
	public Long getBrandId() {
		return brandId;
	}
	public String getPoNumber() {
		return poNumber;
	}
	public String getProductName() {
		return productName;
	}
	public String getBrandName() {
		return brandName;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public Integer getReal() {
		return real;
	}
	public Integer getPrice() {
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
	public Date getUserId() {
		return userId;
	}
	public Double getSellingPrice() {
		return sellingPrice;
	}
	public Double getSellingPercent() {
		return sellingPercent;
	}
	public List<GrnPoProduct> getGrnPoList() {
		return grnPoList;
	}
}
