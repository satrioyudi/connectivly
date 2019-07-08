package com.weekendproject.connectivly.payload;

import java.util.Date;
import java.util.List;

import com.weekendproject.connectivly.model.Master;
import com.weekendproject.connectivly.model.ProductPurchaseOrder;

public class PurchaseOrdersRequest {
		private Long id;
	 	private String storeName;
		private String address;
		private Integer areaId;
		private String phone;
		private Double latitude;
		private Double longitude;
		private Date createdAt;
		private Date updatedAt;
		private String name;
		private String npwp;
		private String email;
		private String userId;
		private String linkCode;
		private String codeExpireDate;
		private Master customerCategory;
		
		private List<ProductPurchaseOrder> ppoList;
		public List<ProductPurchaseOrder> getPpoList() {
			return ppoList;
		}
		
		private long productId;
		private long purchaseOrderId;
		private Integer quantity;
		private Integer quantityLeft;
		
		private String poNumber;
		
		public String getStoreName() {
			return storeName;
		}
		public String getAddress() {
			return address;
		}
		public Integer getAreaId() {
			return areaId;
		}
		public String getPhone() {
			return phone;
		}
		public Double getLatitude() {
			return latitude;
		}
		public Double getLongitude() {
			return longitude;
		}
		public Date getCreatedAt() {
			return createdAt;
		}
		public Date getUpdatedAt() {
			return updatedAt;
		}
		public String getName() {
			return name;
		}
		public String getNpwp() {
			return npwp;
		}
		public String getEmail() {
			return email;
		}
		public String getUserId() {
			return userId;
		}
		public String getLinkCode() {
			return linkCode;
		}
		public String getCodeExpireDate() {
			return codeExpireDate;
		}
		public Long getId() {
			return id;
		}
		public Master getCustomerCategory() {
			return customerCategory;
		}
		public void setCustomerCategory(Master customerCategory) {
			this.customerCategory = customerCategory;
		}
		public long getProductId() {
			return productId;
		}
		public void setProductId(long productId) {
			this.productId = productId;
		}
		public long getPurchaseOrderId() {
			return purchaseOrderId;
		}
		public void setPurchaseOrderId(long purchaseOrderId) {
			this.purchaseOrderId = purchaseOrderId;
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
		public String getPoNumber() {
			return poNumber;
		}
}
