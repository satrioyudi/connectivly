package com.weekendproject.connectivly.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Products {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(name = "brand_id")
    private Long brandId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "price")
	private Integer price;
	
	@Column(name = "qty")
	private Integer qty;
	
	@Column(name = "qty_box")
	private Integer qtyBox;
	
	@Column(name = "measurement_id")
	private Long measurementId;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "created_at")
	private Date createdAt;
	
	@Column(name = "updated_at")
	private Date updatedAt;
	
	@Column(name = "price_before")
	private Integer priceBefore;
	
	@Column(name = "item_category_id")
	private Integer itemCategoryId;
	
	@Column(name = "defect")
	private Integer defect;
	
	@Column(name = "item_cost")
	private Integer itemCost;
	
	@Column(name = "deleted_at")
	private Date deletedAt;
	
	@Column(name = "item_cost_before")
	private Integer itemCostBefore;
	
	@Column(name = "image")
	private String image;
	
	@Column(name = "prev_item_cost")
	private Integer prevItemCost;
	
	@Column(name = "user_id")
	private String userId;
	
	@Column(name = "item_cost_percent")
	private Integer itemCostPercent;
	
	@Column(name = "item_cost_raw")
	private Integer itemCostRaw;
	
	@Column(name = "marketplace_category_id")
	private Integer marketplaceCategoryId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public Integer getQtyBox() {
		return qtyBox;
	}

	public void setQtyBox(Integer qtyBox) {
		this.qtyBox = qtyBox;
	}

	public Long getMeasurementId() {
		return measurementId;
	}

	public void setMeasurementId(Long measurementId) {
		this.measurementId = measurementId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public Integer getPriceBefore() {
		return priceBefore;
	}

	public void setPriceBefore(Integer priceBefore) {
		this.priceBefore = priceBefore;
	}

	public Integer getItemCategoryId() {
		return itemCategoryId;
	}

	public void setItemCategoryId(Integer itemCategoryId) {
		this.itemCategoryId = itemCategoryId;
	}

	public Integer getDefect() {
		return defect;
	}

	public void setDefect(Integer defect) {
		this.defect = defect;
	}

	public Integer getItemCost() {
		return itemCost;
	}

	public void setItemCost(Integer itemCost) {
		this.itemCost = itemCost;
	}

	public Date getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}

	public Integer getItemCostBefore() {
		return itemCostBefore;
	}

	public void setItemCostBefore(Integer itemCostBefore) {
		this.itemCostBefore = itemCostBefore;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getPrevItemCost() {
		return prevItemCost;
	}

	public void setPrevItemCost(Integer prevItemCost) {
		this.prevItemCost = prevItemCost;
	}

	public Integer getItemCostPercent() {
		return itemCostPercent;
	}

	public void setItemCostPercent(Integer itemCostPercent) {
		this.itemCostPercent = itemCostPercent;
	}

	public Integer getItemCostRaw() {
		return itemCostRaw;
	}

	public void setItemCostRaw(Integer itemCostRaw) {
		this.itemCostRaw = itemCostRaw;
	}

	public Integer getMarketplaceCategoryId() {
		return marketplaceCategoryId;
	}

	public void setMarketplaceCategoryId(Integer marketplaceCategoryId) {
		this.marketplaceCategoryId = marketplaceCategoryId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "brand_id", nullable=false, insertable=false, updatable=false)
	private Master masterBrands;

	public Master getMasterBrands() {
		return masterBrands;
	}

	public void setMasterBrands(Master masterBrands) {
		this.masterBrands = masterBrands;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "measurement_id", nullable=false, insertable=false, updatable=false)
	private Master masterMeasurements;


	public Master getMasterMeasurements() {
		return masterMeasurements;
	}

	public void setMasterMeasurements(Master masterMeasurements) {
		this.masterMeasurements = masterMeasurements;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "item_category_id", nullable=false, insertable=false, updatable=false)
	private Master masterItemCategory;
	
	public Master getMasterItemCategory() {
		return masterItemCategory;
	}

	public void setMasterItemCategory(Master masterItemCategory) {
		this.masterItemCategory = masterItemCategory;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "marketplace_category_id", nullable=false, insertable=false, updatable=false)
	private MarketPlaceCategory marketplaceCategory;

	public MarketPlaceCategory getMarketplaceCategory() {
		return marketplaceCategory;
	}

	public void setMarketplaceCategory(MarketPlaceCategory marketplaceCategory) {
		this.marketplaceCategory = marketplaceCategory;
	}

	public Products() {
	}

	public Products(Long id, Long brandId, String name, Integer price, Integer qty, Integer qtyBox, Long measurementId,
			String code, Date createdAt, Date updatedAt, Integer priceBefore, Integer itemCategoryId, Integer defect,
			Integer itemCost, Date deletedAt, Integer itemCostBefore, String image, Integer prevItemCost, String userId,
			Integer itemCostPercent, Integer itemCostRaw, Integer marketplaceCategoryId, Master masterBrands) {
		super();
		this.id = id;
		this.brandId = brandId;
		this.name = name;
		this.price = price;
		this.qty = qty;
		this.qtyBox = qtyBox;
		this.measurementId = measurementId;
		this.code = code;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.priceBefore = priceBefore;
		this.itemCategoryId = itemCategoryId;
		this.defect = defect;
		this.itemCost = itemCost;
		this.deletedAt = deletedAt;
		this.itemCostBefore = itemCostBefore;
		this.image = image;
		this.prevItemCost = prevItemCost;
		this.userId = userId;
		this.itemCostPercent = itemCostPercent;
		this.itemCostRaw = itemCostRaw;
		this.marketplaceCategoryId = marketplaceCategoryId;
		this.masterBrands = masterBrands;
	}
	
}
