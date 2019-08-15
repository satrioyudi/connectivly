package com.weekendproject.connectivly.service.impl;

import java.util.Date;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weekendproject.connectivly.model.ProductHistory;
import com.weekendproject.connectivly.model.Products;
import com.weekendproject.connectivly.payload.ProductRequest;
import com.weekendproject.connectivly.repository.ProductHistoryRepository;
import com.weekendproject.connectivly.repository.ProductRepository;
import com.weekendproject.connectivly.service.LogService;
import com.weekendproject.connectivly.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
    private ProductRepository repository;
	
	@Autowired
	private LogService logService;
	
	@Autowired
	private ProductHistoryRepository productHistoryRepository;

	@Override
	public void saveProduct(@Valid ProductRequest jsonRequest, String name) {
		Products products = new Products();
		products.setImage(jsonRequest.getImage());
		products.setName(jsonRequest.getName());
		products.setBrandId(jsonRequest.getBrandId());
		products.setItemCategoryId(jsonRequest.getItemCategoryId());
		products.setQtyBox(jsonRequest.getQtyBox());
		products.setMeasurementId(jsonRequest.getMeasurementId());
		products.setCode(jsonRequest.getCode());
		products.setPrice(jsonRequest.getPrice());
		products.setItemCost(jsonRequest.getItemCost());
		products.setCreatedAt(new Date());
		products.setUserId(name);
		
		repository.save(products);
		
		logService.createLog("saveProduct", new Date(), products.getId().toString(), name);
	}


	@Override
	public void updateProduct(@Valid ProductRequest jsonRequest, String name) {
		Optional<Products> oneById = repository.findById(jsonRequest.getId());
		if (oneById.isPresent()) {
			Products products = oneById.get();
			products.setImage(jsonRequest.getImage());
			products.setName(jsonRequest.getName());
			products.setBrandId(jsonRequest.getBrandId());
			products.setItemCategoryId(jsonRequest.getItemCategoryId());
			products.setQtyBox(jsonRequest.getQty());
			products.setMeasurementId(jsonRequest.getMeasurementId());
			products.setCode(jsonRequest.getCode());
			products.setPrice(jsonRequest.getPrice());
			products.setItemCost(jsonRequest.getItemCost());
			products.setUpdatedAt(new Date());
			products.setUserId(name);
			
			repository.save(products);
			
			logService.createLog("updateProduct", new Date(), products.getId().toString(), name);
		}
	}


	@Override
	public void modifikasiStok(@Valid ProductRequest jsonRequest, String name) {
		Optional<Products> oneById = repository.findById(jsonRequest.getId());
		if (oneById.isPresent()) {
			Products products = oneById.get();
			products.setDefect(jsonRequest.getDefect());
			products.setQty(jsonRequest.getQty());
			
			repository.save(products);
			
			Integer prevDefect = products.getDefect();
			Integer prevQty = products.getQty();
			Long productId = products.getId();
			String productName = products.getName();					
			
			ProductHistory ph = new ProductHistory();
			ph.setMutator("Stock Modifier");
			ph.setCode("-");
			ph.setCreatedAt(new Date());
			ph.setCreatedBy(name);
			ph.setDefectStock(null);
			ph.setDirectSalesId(null);
			ph.setGoodReceivedNoteId(null);
			ph.setNote("modifikasiStok");
			ph.setPreviousDefect(prevDefect);
			ph.setPreviousQty(prevQty);
			ph.setProductId(productId);
			ph.setProductName(productName);
			ph.setPurchaseOrderId(null);
			ph.setPurchaseReturnId(null);
			ph.setRemains(prevQty - jsonRequest.getQty());
			ph.setSalesOrderId(null);
			ph.setSalesReturnId(null);
			ph.setStatus(prevQty > jsonRequest.getQty() ? "Increment" : "Decrement");
			ph.setUpdatedAt(null);
			ph.setUserId(name);
			ph.setValue(0);   
			productHistoryRepository.save(ph);
			
			logService.createLog("modifikasiStok", new Date(), products.getId().toString(), name);
		}
		
	}


	@Override
	public void deleteProduct(@Valid ProductRequest jsonRequest, String name) {
		Optional<Products> oneById = repository.findById(jsonRequest.getId());
		if (oneById.isPresent()) {
			System.out.println("ada");
			Products products = oneById.get();
			products.setDeletedAt(new Date());
			
			repository.save(products);
			
			logService.createLog("deleteProduct", new Date(), products.getId().toString(), name);
		}
		
	}

}
