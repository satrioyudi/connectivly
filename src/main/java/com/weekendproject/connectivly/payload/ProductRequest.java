package com.weekendproject.connectivly.payload;

import java.util.Date;

public class ProductRequest {
    private Long id;
    private Long brandId;
	private String name;
	private Integer price;
	private Integer qty;
	private Integer qtyBox;
	private Long measurementId;
	private String code;
	private Date createdAt;
	private Date updatedAt;
	private Integer itemCategoryId;
	private Integer defect;
	private Integer itemCost;
	private Date deletedAt;
	private Integer itemCostBefore;
	private String image;
	private Integer prevItemCost;
	private Integer itemCostPercent;
	private Integer itemCostRaw;
	private Integer marketplaceCategoryId;
	
	public Long getId() {
		return id;
	}
	public Long getBrandId() {
		return brandId;
	}
	public String getName() {
		return name;
	}
	public Integer getPrice() {
		return price;
	}
	public Integer getQty() {
		return qty;
	}
	public Long getMeasurementId() {
		return measurementId;
	}
	public String getCode() {
		return code;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public Integer getItemCategoryId() {
		return itemCategoryId;
	}
	public Integer getDefect() {
		return defect;
	}
	public Integer getItemCost() {
		return itemCost;
	}
	public Date getDeletedAt() {
		return deletedAt;
	}
	public Integer getItemCostBefore() {
		return itemCostBefore;
	}
	public String getImage() {
		return image;
	}
	public Integer getPrevItemCost() {
		return prevItemCost;
	}
	public Integer getItemCostPercent() {
		return itemCostPercent;
	}
	public Integer getItemCostRaw() {
		return itemCostRaw;
	}
	public Integer getMarketplaceCategoryId() {
		return marketplaceCategoryId;
	}
	public Integer getQtyBox() {
		return qtyBox;
	}


	
}
