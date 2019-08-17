package com.weekendproject.connectivly.payload;

import java.util.Date;
import java.util.List;

import com.weekendproject.connectivly.model.SalesOrderProduct;

public class SalesOrderRequest {
	
	private Long id;
    private Date createdAt;
    private Date updatedAt;
    private String code;
    private Long customerId;
    private Boolean isApproved;
    private Boolean isReady;
	private Boolean isDelivered;
	private Boolean isOverride;
	private Double totalBeforeDiscount;
	private Date soDate;
	private Double globalDiscount;
	private Double globalDiscountFlat;
	private Integer bonusOnlineOrder;
    private String userId;
	private Long employeeId;
	private Long saleRepresentativeId;
    private String isLinked;
    
    private List<SalesOrderProduct> sopList;
	private Double total;
    
	public Long getId() {
		return id;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public String getCode() {
		return code;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public Boolean getIsApproved() {
		return isApproved;
	}
	public Boolean getIsReady() {
		return isReady;
	}
	public Boolean getIsDelivered() {
		return isDelivered;
	}
	public Boolean getIsOverride() {
		return isOverride;
	}
	public Double getTotalBeforeDiscount() {
		return totalBeforeDiscount;
	}
	public Date getSoDate() {
		return soDate;
	}
	public Integer getBonusOnlineOrder() {
		return bonusOnlineOrder;
	}
	public String getUserId() {
		return userId;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public Long getSaleRepresentativeId() {
		return saleRepresentativeId;
	}
	public String getIsLinked() {
		return isLinked;
	}
	public Double getGlobalDiscount() {
		return globalDiscount;
	}
	public Double getGlobalDiscountFlat() {
		return globalDiscountFlat;
	}
	public List<SalesOrderProduct> getSopList() {
		return sopList;
	}
	public Double getTotal() {
		return total;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
	}
	public void setIsReady(Boolean isReady) {
		this.isReady = isReady;
	}
	public void setIsDelivered(Boolean isDelivered) {
		this.isDelivered = isDelivered;
	}
	public void setIsOverride(Boolean isOverride) {
		this.isOverride = isOverride;
	}
	public void setTotalBeforeDiscount(Double totalBeforeDiscount) {
		this.totalBeforeDiscount = totalBeforeDiscount;
	}
	public void setSoDate(Date soDate) {
		this.soDate = soDate;
	}
	public void setGlobalDiscount(Double globalDiscount) {
		this.globalDiscount = globalDiscount;
	}
	public void setGlobalDiscountFlat(Double globalDiscountFlat) {
		this.globalDiscountFlat = globalDiscountFlat;
	}
	public void setBonusOnlineOrder(Integer bonusOnlineOrder) {
		this.bonusOnlineOrder = bonusOnlineOrder;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public void setSaleRepresentativeId(Long saleRepresentativeId) {
		this.saleRepresentativeId = saleRepresentativeId;
	}
	public void setIsLinked(String isLinked) {
		this.isLinked = isLinked;
	}
	public void setSopList(List<SalesOrderProduct> sopList) {
		this.sopList = sopList;
	}
	public void setTotal(Double total) {
		this.total = total;
	}

	
}
