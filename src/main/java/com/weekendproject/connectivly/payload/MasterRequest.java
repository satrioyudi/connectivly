package com.weekendproject.connectivly.payload;

public class MasterRequest {
	private Long id;
    private String brands;
	private String customerCategory;
	private String measurements;
	private String itemCategory;
	private String userId;
	private String masterCode;
	
	public Long getId() {
		return id;
	}
	public String getBrands() {
		return brands;
	}
	public String getCustomerCategory() {
		return customerCategory;
	}
	public String getMeasurements() {
		return measurements;
	}
	public String getItemCategory() {
		return itemCategory;
	}
	public String getUserId() {
		return userId;
	}
	public String getMasterCode() {
		return masterCode;
	}
	public void setMasterCode(String masterCode) {
		this.masterCode = masterCode;
	}
}
