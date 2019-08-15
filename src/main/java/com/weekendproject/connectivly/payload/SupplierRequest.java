package com.weekendproject.connectivly.payload;

public class SupplierRequest {
	 	private Long id;
		private String email;
		private String companyName;
		private String province;
		private String city;
		private String postalCode;
		private Long measurementId;
		private String username;
		private String password;
		private String fullName;
		private Long roleId;
		private Long supplierId;
		
		public Long getId() {
			return id;
		}
		public String getEmail() {
			return email;
		}
		public String getCompanyName() {
			return companyName;
		}
		public String getProvince() {
			return province;
		}
		public String getCity() {
			return city;
		}
		public String getPostalCode() {
			return postalCode;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}
		public void setProvince(String province) {
			this.province = province;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public void setPostalCode(String postalCode) {
			this.postalCode = postalCode;
		}
		public Long getMeasurementId() {
			return measurementId;
		}
		public void setMeasurementId(Long measurementId) {
			this.measurementId = measurementId;
		}
		public String getUsername() {
			return username;
		}
		public String getPassword() {
			return password;
		}
		public String getFullName() {
			return fullName;
		}
		public Long getRoleId() {
			return roleId;
		}
		public Long getSupplierId() {
			return supplierId;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public void setFullName(String fullName) {
			this.fullName = fullName;
		}
		public void setRoleId(Long roleId) {
			this.roleId = roleId;
		}
		public void setSupplierId(Long supplierId) {
			this.supplierId = supplierId;
		}
}
