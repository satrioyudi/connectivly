package com.weekendproject.connectivly.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sales_order")
public class SalesOrder {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(name = "created_at")
    private Date createdAt;
	
	@Column(name = "updated_at")
    private Date updatedAt;
	
	@Column(name = "code")
    private String code;
	
	@Column(name = "customer_id")
    private Long customerId;
	
	@Column(name = "is_approved")
    private Boolean isApproved;
	
	@Column(name = "is_ready")
    private Boolean isReady;
	
	@Column(name = "is_delivered")
	private Boolean isDelivered;
	
	@Column(name = "is_override")
	private Boolean isOverride;
	
	@Column(name = "total")
	private Double total;
	
	@Column(name = "total_before_discount")
	private Double totalBeforeDiscount;
	
	@Column(name = "so_date")
	private Date soDate;
	
	@Column(name = "global_discount")
	private Double globalDiscount;
	
	@Column(name = "global_discount_flat")
	private Double globalDiscountFlat;
	
	@Column(name = "bonus_online_order")
	private Integer bonusOnlineOrder;
	
	@Column(name = "user_id")
    private String userId;
	
	@Column(name = "employee_id")
	private Long employeeId;
	
	@Column(name = "sale_representative_id")
	private Long saleRepresentativeId;
	
	@Column(name = "approved_at")
    private Date approvedAt;
	
	@Column(name = "is_linked")
    private String isLinked;

	@Column(name = "po_code")
    private String poCode;

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

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Boolean getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
	}

	public Boolean getIsReady() {
		return isReady;
	}

	public void setIsReady(Boolean isReady) {
		this.isReady = isReady;
	}

	public Boolean getIsDelivered() {
		return isDelivered;
	}

	public void setIsDelivered(Boolean isDelivered) {
		this.isDelivered = isDelivered;
	}

	public Boolean getIsOverride() {
		return isOverride;
	}

	public void setIsOverride(Boolean isOverride) {
		this.isOverride = isOverride;
	}


	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}


	public Date getSoDate() {
		return soDate;
	}

	public void setSoDate(Date soDate) {
		this.soDate = soDate;
	}

	public Double getGlobalDiscount() {
		return globalDiscount;
	}

	public void setGlobalDiscount(Double globalDiscount) {
		this.globalDiscount = globalDiscount;
	}

	public Double getGlobalDiscountFlat() {
		return globalDiscountFlat;
	}

	public void setGlobalDiscountFlat(Double globalDiscountFlat) {
		this.globalDiscountFlat = globalDiscountFlat;
	}

	public Integer getBonusOnlineOrder() {
		return bonusOnlineOrder;
	}

	public void setBonusOnlineOrder(Integer bonusOnlineOrder) {
		this.bonusOnlineOrder = bonusOnlineOrder;
	}

	public String getUserId() {
		return userId;
	}

	public String getPoCode() {
		return poCode;
	}

	public void setPoCode(String poCode) {
		this.poCode = poCode;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Long getSaleRepresentativeId() {
		return saleRepresentativeId;
	}

	public void setSaleRepresentativeId(Long saleRepresentativeId) {
		this.saleRepresentativeId = saleRepresentativeId;
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

	public Double getTotalBeforeDiscount() {
		return totalBeforeDiscount;
	}

	public void setTotalBeforeDiscount(Double totalBeforeDiscount) {
		this.totalBeforeDiscount = totalBeforeDiscount;
	}

	
	
	
}
