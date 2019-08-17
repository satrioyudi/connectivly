package com.weekendproject.connectivly.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.weekendproject.connectivly.payload.SalesOrderRequest;
import com.weekendproject.connectivly.repository.SalesOrderRepository;
import com.weekendproject.connectivly.service.SalesOrderService;
import com.weekendproject.connectivly.model.SalesOrder;

@RestController
@RequestMapping("/api/salesOrder")
public class SalesOrderController {
	@Autowired
    private SalesOrderRepository repository;
	
	@Autowired
	private SalesOrderService service;

	@GetMapping("/getAllSalesOrder")
    public Page<SalesOrder> getAllSalesOrder(Pageable page, HttpServletRequest request) throws IOException, JSONException {
        return repository.findAllByUserIdAndIsLinkedAndIsApproved(page, JwtDecoder.decodeJwt(request).get("userId"), "YES", false);
    }
	
	@PostMapping("/saveSalesOrder")
    @ResponseStatus(HttpStatus.OK)
    public void saveSalesOrder(@Valid @RequestBody SalesOrderRequest jsonRequest, HttpServletRequest request) throws Exception {
//		Principal principal = request.getUserPrincipal();
		service.saveSalesOrder(jsonRequest, JwtDecoder.decodeJwt(request).get("userId"));
    }
	
	@PostMapping("/editSalesOrder")
	@ResponseStatus(HttpStatus.OK)
	public void editSalesOrder(@Valid @RequestBody SalesOrderRequest jsonRequest, HttpServletRequest request) throws Exception {
//		Principal principal = request.getUserPrincipal();
		service.editSalesOrder(jsonRequest, JwtDecoder.decodeJwt(request).get("userId"));
	}
	
	@PostMapping("/approveSalesOrder")
	@ResponseStatus(HttpStatus.OK)
	public void approveSalesOrder(@Valid @RequestBody SalesOrderRequest jsonRequest, HttpServletRequest request) throws IOException, JSONException{
		service.approveSalesOrder(jsonRequest, JwtDecoder.decodeJwt(request).get("userId"));
	}
}
