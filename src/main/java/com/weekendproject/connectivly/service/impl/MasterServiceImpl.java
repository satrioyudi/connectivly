package com.weekendproject.connectivly.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weekendproject.connectivly.model.Customers;
import com.weekendproject.connectivly.model.ExtraCost;
import com.weekendproject.connectivly.model.Master;
import com.weekendproject.connectivly.model.Supplier;
import com.weekendproject.connectivly.payload.CustomerRequest;
import com.weekendproject.connectivly.payload.ExtraCostRequest;
import com.weekendproject.connectivly.payload.MasterRequest;
import com.weekendproject.connectivly.payload.SupplierRequest;
import com.weekendproject.connectivly.repository.CustomersRepository;
import com.weekendproject.connectivly.repository.ExtraCostRepository;
import com.weekendproject.connectivly.repository.MasterRepository;
import com.weekendproject.connectivly.repository.SupplierRepository;
import com.weekendproject.connectivly.service.LogService;
import com.weekendproject.connectivly.service.MasterService;

@Service
public class MasterServiceImpl implements MasterService{
	@Autowired
    private MasterRepository repository;
	
	@Autowired
    private CustomersRepository cusRepository;
	
	@Autowired
	private SupplierRepository supRepository;
	
	@Autowired
	private ExtraCostRepository ecRepository;
	
	@Autowired
	private LogService logService;

	@Override
	public List<Object> getMaster(String menu, String user) {
		List<Object> res = new ArrayList<>();
		List<Master> m = repository.findAllByUserId(user);
		for (Master master : m) {
			Map<String, Object> map = new HashMap<String, Object>();
			if (master != null) {
				switch (menu) {
				case "brands":
					if (master.getBrands() != null && !master.getBrands().isEmpty() && master.getBrands().toString().trim() != "") {
						map.put("id", master.getId());
						map.put("name", master.getBrands());
						map.put("code", master.getCodeMaster());
						res.add(map);
					}
					break;
				case "customerCategory":
					if (master.getCustomerCategory() != null && !master.getCustomerCategory().isEmpty() && !master.getCustomerCategory().toString().trim().equals("")) {
						map.put("id", master.getId());
						map.put("name", master.getCustomerCategory());
						map.put("code", master.getCodeMaster());
						res.add(map);
					}
					break;
				case "measurements":
					if (master.getMeasurements() != null && !master.getMeasurements().isEmpty() && !master.getMeasurements().toString().trim().equals("")) {
						map.put("id", master.getId());
						map.put("name", master.getMeasurements());
						map.put("code", master.getCodeMaster());
						res.add(map);
					}
					break;
				case "itemCategory":
					if (master.getItemCategory() != null && !master.getItemCategory().isEmpty() && master.getItemCategory().toString().trim() != "") {
						map.put("id", master.getId());
						map.put("name", master.getItemCategory());
						map.put("code", master.getCodeMaster());
						res.add(map);
					}
					break;
					
				default:
					res = new ArrayList<>();
					break;
				}
			}
			
		}
		return res;
	}

	@Override
	public void saveMaster(@Valid MasterRequest jsonRequest, String name) {
		Master master = new Master();
		master.setBrands(jsonRequest.getBrands());
		master.setCustomerCategory(jsonRequest.getCustomerCategory());
		master.setItemCategory(jsonRequest.getItemCategory());
		master.setMeasurements(jsonRequest.getMeasurements());
		master.setCodeMaster(jsonRequest.getMasterCode());
		master.setUserId(name);
		repository.save(master);
		
		logService.createLog("saveMaster", new Date(), master.getId().toString(), name);
		
	}

	@Override
	public void updateMaster(@Valid MasterRequest jsonRequest, String name) {
		Optional<Master> oneById = repository.findById(jsonRequest.getId());
		if (oneById.isPresent()) {
			Master master = oneById.get();
			master.setBrands(jsonRequest.getBrands());
			master.setCustomerCategory(jsonRequest.getCustomerCategory());
			master.setItemCategory(jsonRequest.getItemCategory());
			master.setMeasurements(jsonRequest.getMeasurements());
			master.setCodeMaster(jsonRequest.getMasterCode());
			repository.save(master);
			
			logService.createLog("updateMaster", new Date(),jsonRequest.toString(), name);
		}
		
	}

	@Override
	public void saveCustomer(@Valid CustomerRequest jsonRequest, String name) {
		Customers cus = new Customers();
		cus.setStoreName(jsonRequest.getStoreName());
		cus.setName(jsonRequest.getName());
		cus.setEmail(jsonRequest.getEmail());
		cus.setAddress(jsonRequest.getAddress());
		cus.setPhone(jsonRequest.getPhone());
		cus.setNpwp(jsonRequest.getNpwp());
		cus.setUserId(name);
		cus.setCreatedAt(new Date());
		
//		Optional<Master> oneById = repository.findByCustomerCategory(jsonRequest.getCustomerCategory().getCustomerCategory());
		Optional<Master> oneById = repository.findById(jsonRequest.getCustomerCategoryId());
		if (oneById.isPresent()) {
			Master master = oneById.get();
			Set<Master> custCategories = new HashSet<Master>();
			custCategories.add(master);
			cus.setCustCategories(custCategories);
			
		}
		
		cusRepository.save(cus);
		
		logService.createLog("saveCustomer", new Date(), cus.getId().toString(), name);
	}

	@Override
	public void updateCustomer(@Valid CustomerRequest jsonRequest, String name) {
		Optional<Customers> oneById = cusRepository.findById(jsonRequest.getId());
		if (oneById.isPresent()) {
			Customers cus = oneById.get();
			cus.setStoreName(jsonRequest.getStoreName());
			cus.setName(jsonRequest.getName());
			cus.setEmail(jsonRequest.getEmail());
			cus.setAddress(jsonRequest.getAddress());
			cus.setPhone(jsonRequest.getPhone());
			cus.setNpwp(jsonRequest.getNpwp());
			cus.setUserId(name);
			cus.setUpdatedAt(new Date());
			
			Optional<Master> oneById2 = repository.findById(jsonRequest.getCustomerCategoryId());
			if (oneById2.isPresent()) {
				Master master = oneById2.get();
				Set<Master> custCategories = new HashSet<Master>();
				custCategories.add(master);
				cus.setCustCategories(custCategories);
				
			}
			
			cusRepository.save(cus);
			logService.createLog("saveCustomer", new Date(), jsonRequest.toString(), name);
		}
		
	}

	@Override
	public void saveSupplier(@Valid SupplierRequest jsonRequest, String name) {
		Supplier supplier = new Supplier();
		supplier.setName(jsonRequest.getName());
		supplier.setAddress(jsonRequest.getAddress());
		supplier.setPhone(jsonRequest.getPhone());
		supplier.setEmail(jsonRequest.getEmail());
		supplier.setCreatedAt(new Date());
		supplier.setUserId(name);
		
		supRepository.save(supplier);
		
		logService.createLog("saveSupplier", new Date(),jsonRequest.toString(), name);
	}

	@Override
	public void updateSupplier(@Valid SupplierRequest jsonRequest, String name) {
		Optional<Supplier> oneById = supRepository.findById(jsonRequest.getId());
		if (oneById.isPresent()) {
			Supplier supplier = oneById.get();
			supplier.setName(jsonRequest.getName());
			supplier.setAddress(jsonRequest.getAddress());
			supplier.setPhone(jsonRequest.getPhone());
			supplier.setEmail(jsonRequest.getEmail());
			supplier.setUserId(name);
			supplier.setUpdatedAt(new Date());
			supRepository.save(supplier);
			
			logService.createLog("updateMaster", new Date(),jsonRequest.toString(), name);
		}
		
	}

	@Override
	public void saveExtraCost(@Valid ExtraCostRequest jsonRequest, String userName) {
		ExtraCost ec = new ExtraCost();
		ec.setCreatedAt(new Date());
		ec.setUserId(userName);
		ec.setName(jsonRequest.getName());
		ec.setRate(jsonRequest.getRate());
		
		ecRepository.save(ec);
		
		logService.createLog("saveExtraCost", new Date(),jsonRequest.getName()+"|"+jsonRequest.getRate(), userName);
	}

	@Override
	public void updateExtraCost(@Valid ExtraCostRequest jsonRequest, String userName) {
		Optional<ExtraCost> oneById = ecRepository.findById(jsonRequest.getId());
		if (oneById.isPresent()) {
			ExtraCost ec = oneById.get();
			ec.setUserId(userName);
			ec.setName(jsonRequest.getName());
			ec.setRate(jsonRequest.getRate());
			ec.setUpdatedAt(new Date());
			
			ecRepository.save(ec);
			
			logService.createLog("updateExtraCost", new Date(),jsonRequest.getName()+"|"+jsonRequest.getRate(), userName);
		}
	}
	
	
	
}
