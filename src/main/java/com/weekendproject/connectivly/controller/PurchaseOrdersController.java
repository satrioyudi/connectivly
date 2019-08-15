package com.weekendproject.connectivly.controller;

import java.io.IOException;
import java.util.List;

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

import com.weekendproject.connectivly.model.Products;
import com.weekendproject.connectivly.model.PurchaseOrders;
import com.weekendproject.connectivly.payload.PurchaseOrdersRequest;
import com.weekendproject.connectivly.repository.ProductRepository;
import com.weekendproject.connectivly.repository.PurchaseOrdersRepository;
import com.weekendproject.connectivly.repository.PurchaseOrdersRepository.PurchaseOrderView;
import com.weekendproject.connectivly.repository.PurchaseOrdersRepository.PurchaseOrderViewDetail;
import com.weekendproject.connectivly.service.PurchaseOrdersService;

@RestController
@RequestMapping("/api/purchaseOrders")
public class PurchaseOrdersController {
	@Autowired
    private PurchaseOrdersRepository repository;
	
	@Autowired
    private ProductRepository productRepository;
	
	@Autowired
	private PurchaseOrdersService purchaseOrdersService;
	
	@GetMapping("/getAllPurchaseOrder")
    @ResponseStatus(HttpStatus.OK)
    public Page<PurchaseOrderView> getAllPurchaseOrder(Pageable page, HttpServletRequest request) throws IOException, JSONException {
        return repository.getAllPurchaseOrder(page, JwtDecoder.decodeJwt(request).get("userId"), Integer.parseInt(JwtDecoder.decodeJwt(request).get("supplierId")));
    }
	
	@GetMapping("/getProductBySupplier")
    public Page<Products> getProductBySupplier(Pageable page, HttpServletRequest request) throws IOException, JSONException {
//		Principal principal = request.getUserPrincipal();
//		String userName = principal.getName();
		Page<Products> getSupplier = productRepository.findAllByUserId(page, JwtDecoder.decodeJwt(request).get("userId"));
        return getSupplier;
    }
	
	@PostMapping("/viewPurchaseOrderDetail")
    @ResponseStatus(HttpStatus.OK)
    public List<PurchaseOrderViewDetail> viewPurchaseOrderDetail(@Valid @RequestBody PurchaseOrdersRequest jsonRequest, HttpServletRequest request) throws IOException, JSONException {
        return repository.viewPurchaseOrderDetail(JwtDecoder.decodeJwt(request).get("userId"), jsonRequest.getPoNumber());
    }
	
	@PostMapping("/addPurchaseOrder")
	public void addPurchaseOrder(@Valid @RequestBody PurchaseOrdersRequest jsonRequest, HttpServletRequest request) throws IOException, JSONException{
		purchaseOrdersService.addPurchaseOrder(jsonRequest, JwtDecoder.decodeJwt(request).get("userId"), Integer.parseInt(JwtDecoder.decodeJwt(request).get("supplierId")));
	}
	
	@PostMapping("/editPurchaseOrder")
	public void editPurchaseOrder(@Valid @RequestBody PurchaseOrdersRequest jsonRequest, HttpServletRequest request) throws IOException, JSONException{
		purchaseOrdersService.editPurchaseOrder(jsonRequest, JwtDecoder.decodeJwt(request).get("userId"));
	}
	
	@PostMapping("/approvePurchaseOrder")
	public void approvePurchaseOrder(@Valid @RequestBody PurchaseOrdersRequest jsonRequest, HttpServletRequest request) throws IOException, JSONException{
		purchaseOrdersService.approvePurchaseOrder(jsonRequest, JwtDecoder.decodeJwt(request).get("userId"));
	}
	
	@PostMapping("/deletePurchaseOrder")
	@ResponseStatus(HttpStatus.OK)
	public void deletePurchaseOrder(@Valid @RequestBody PurchaseOrdersRequest jsonRequest, HttpServletRequest request) throws Exception {
		repository.deleteById(jsonRequest.getId());
	}
	
	@GetMapping("/getListApprovedPO")
	@ResponseStatus(HttpStatus.OK)
	public List<PurchaseOrders> getListApprovedPO(HttpServletRequest request) throws IOException, JSONException {
		List<PurchaseOrders> getListApprovedPO = repository.findAllByIsApprovedTrueAndUserId(JwtDecoder.decodeJwt(request).get("userId"));
		return getListApprovedPO;
	}

}
