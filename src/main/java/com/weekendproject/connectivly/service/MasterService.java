package com.weekendproject.connectivly.service;

import java.util.List;

import javax.validation.Valid;

import com.weekendproject.connectivly.payload.CustomerRequest;
import com.weekendproject.connectivly.payload.ExtraCostRequest;
import com.weekendproject.connectivly.payload.MasterRequest;
import com.weekendproject.connectivly.payload.SupplierRequest;

public interface MasterService {

	List<Object> getMaster(String menu, String userName);

	void saveMaster(@Valid MasterRequest jsonRequest, String name);

	void updateMaster(@Valid MasterRequest jsonRequest, String name);

	void saveCustomer(@Valid CustomerRequest jsonRequest, String name);

	void updateCustomer(@Valid CustomerRequest jsonRequest, String name);

	void saveSupplier(@Valid SupplierRequest jsonRequest, String decodeJwt);

	void updateSupplier(@Valid SupplierRequest jsonRequest, String decodeJwt);

	void saveExtraCost(@Valid ExtraCostRequest jsonRequest, String decodeJwt);

	void updateExtraCost(@Valid ExtraCostRequest jsonRequest, String decodeJwt);

}
