package com.weekendproject.connectivly.payload;

import java.util.Date;

public class CustomerRequest {
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
		private Long customerCategoryId;
		
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
		public Long getCustomerCategoryId() {
			return customerCategoryId;
		}
		public void setCustomerCategoryId(Long customerCategoryId) {
			this.customerCategoryId = customerCategoryId;
		}
}
