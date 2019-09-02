package com.weekendproject.connectivly.service;

import java.util.List;

import javax.validation.Valid;

import com.weekendproject.connectivly.payload.SalesOrderRequest;

public interface SalesOrderService {

	void saveSalesOrder(@Valid SalesOrderRequest jsonRequest, String userId) throws Exception;

	void approveSalesOrder(@Valid SalesOrderRequest jsonRequest, String userId);

	void editSalesOrder(@Valid SalesOrderRequest jsonRequest, String string) throws Exception;


}
