package com.weekendproject.connectivly.service;

import javax.validation.Valid;

import com.weekendproject.connectivly.payload.SalesOrderRequest;

public interface SalesOrderService {

	void saveSalesOrder(@Valid SalesOrderRequest jsonRequest, String userId) throws Exception;

	void approveSalesOrder(@Valid SalesOrderRequest jsonRequest, String userId);

}
