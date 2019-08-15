package com.weekendproject.connectivly.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.weekendproject.connectivly.model.Customers;
import com.weekendproject.connectivly.model.ExtraCost;
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


@RestController
@RequestMapping("/api/master")
public class MasterController {
	@Autowired
    private MasterRepository repository;
	
	@Autowired
    private CustomersRepository cusRepository;
	
	@Autowired
	private SupplierRepository supRepository;
	
	@Autowired
	private ExtraCostRepository ecRepository;
	
	@Autowired
    private MasterService service;
	
	@Autowired
	private LogService logService;
	
	@GetMapping("/getMaster/{menu}")
    public List<Object> getMaster(HttpServletRequest request, @PathVariable String menu) throws IOException, JSONException {
//		Principal principal = request.getUserPrincipal();
//		String userName = principal.getName();
//		String userName = "dev@dev.com";
		List<Object> allMaster = service.getMaster(menu, JwtDecoder.decodeJwt(request).get("userId"));
        return allMaster;
    }
	
	@PostMapping("/saveMaster")
    @ResponseStatus(HttpStatus.OK)
    public void saveMaster(@Valid @RequestBody MasterRequest jsonRequest, HttpServletRequest request) throws Exception {
//		Principal principal = request.getUserPrincipal();
//		String userName = principal.getName();
		service.saveMaster(jsonRequest, JwtDecoder.decodeJwt(request).get("userId"));
    }
	
	@PostMapping("/updateMaster")
	@ResponseStatus(HttpStatus.OK)
	public void updateMaster(@Valid @RequestBody MasterRequest jsonRequest, HttpServletRequest request) throws Exception {
//		Principal principal = request.getUserPrincipal();
//		String userName = principal.getName();
		service.updateMaster(jsonRequest, JwtDecoder.decodeJwt(request).get("userId"));
	}
	
	@PostMapping("/deleteMaster")
	@ResponseStatus(HttpStatus.OK)
	public void deleteMaster(@Valid @RequestBody MasterRequest jsonRequest, HttpServletRequest request) throws Exception {
		repository.deleteById(jsonRequest.getId());
		logService.createLog("deleteMaster", new Date(),jsonRequest.getMasterCode(), JwtDecoder.decodeJwt(request).get("userId"));
	}
	
	@GetMapping("/getCustomer")
    public List<Customers> getCustomer(Pageable page, HttpServletRequest request) throws IOException, JSONException {
//		Principal principal = request.getUserPrincipal();
//		String userName = principal.getName();
		List<Customers> getCustomer = cusRepository.findAllByUserId(JwtDecoder.decodeJwt(request).get("userId"));
        return getCustomer;
    }
	
	@PostMapping("/saveCustomer")
    @ResponseStatus(HttpStatus.OK)
    public void saveCustomer(@Valid @RequestBody CustomerRequest jsonRequest, HttpServletRequest request) throws Exception {
//		Principal principal = request.getUserPrincipal();
//		String userName = principal.getName();
		service.saveCustomer(jsonRequest, JwtDecoder.decodeJwt(request).get("userId"));
    }
	
	@PostMapping("/updateCustomer")
	@ResponseStatus(HttpStatus.OK)
	public void updateCustomer(@Valid @RequestBody CustomerRequest jsonRequest, HttpServletRequest request) throws Exception {
//		Principal principal = request.getUserPrincipal();
//		String userName = principal.getName();
		service.updateCustomer(jsonRequest, JwtDecoder.decodeJwt(request).get("userId"));
	}
	
	@PostMapping("/deleteCustomer")
	@ResponseStatus(HttpStatus.OK)
	public void deleteCustomer(@Valid @RequestBody CustomerRequest jsonRequest, HttpServletRequest request) throws Exception {
		repository.deleteById(jsonRequest.getId());
		logService.createLog("deleteCustomer", new Date(),jsonRequest.getName(), JwtDecoder.decodeJwt(request).get("userId"));
	}
	
	@GetMapping("/getSupplier")
    public List<Supplier> getSupplier(Pageable page, HttpServletRequest request) throws IOException, JSONException {
//		Principal principal = request.getUserPrincipal();
//		String userName = principal.getName();
		List<Supplier> getSupplier = supRepository.findAllByUserId(JwtDecoder.decodeJwt(request).get("userId"));
        return getSupplier;
    }
	
	@PostMapping("/saveSupplier")
    @ResponseStatus(HttpStatus.OK)
    public void saveSupplier(@Valid @RequestBody SupplierRequest jsonRequest, HttpServletRequest request) throws Exception {
//		Principal principal = request.getUserPrincipal();
//		String userName = principal.getName();
		System.out.println("token : "+request.getHeader("authorization"));
		service.saveSupplier(jsonRequest, JwtDecoder.decodeJwt(request).get("userId"), request);
    }
	
	@PostMapping("/updateSupplier")
    @ResponseStatus(HttpStatus.OK)
    public void updateSupplier(@Valid @RequestBody SupplierRequest jsonRequest, HttpServletRequest request) throws Exception {
//		Principal principal = request.getUserPrincipal();
//		String userName = principal.getName();
		service.updateSupplier(jsonRequest, JwtDecoder.decodeJwt(request).get("userId"));
    }
	
	@PostMapping("/deleteSupplier")
	@ResponseStatus(HttpStatus.OK)
	public void deleteSupplier(@Valid @RequestBody SupplierRequest jsonRequest, HttpServletRequest request) throws Exception {
		supRepository.deleteById(jsonRequest.getId());
		logService.createLog("deleteSupplier", new Date(),jsonRequest.getUsername(), JwtDecoder.decodeJwt(request).get("userId"));
	}
	
	@PostMapping("/saveExtraCost")
    @ResponseStatus(HttpStatus.OK)
    public void saveExtraCost(@Valid @RequestBody ExtraCostRequest jsonRequest, HttpServletRequest request) throws Exception {
//		Principal principal = request.getUserPrincipal();
//		String userName = principal.getName();
		service.saveExtraCost(jsonRequest, JwtDecoder.decodeJwt(request).get("userId"));
    }
	
	@PostMapping("/updateExtraCost")
    @ResponseStatus(HttpStatus.OK)
    public void updateExtraCost(@Valid @RequestBody ExtraCostRequest jsonRequest, HttpServletRequest request) throws Exception {
//		Principal principal = request.getUserPrincipal();
//		String userName = principal.getName();
		service.updateExtraCost(jsonRequest, JwtDecoder.decodeJwt(request).get("userId"));
    }
	
	@PostMapping("/deleteExtraCost")
	@ResponseStatus(HttpStatus.OK)
	public void deleteExtraCost(@Valid @RequestBody ExtraCostRequest jsonRequest, HttpServletRequest request) throws Exception {
		ecRepository.deleteById(jsonRequest.getId());
		logService.createLog("deleteExtraCost", new Date(),jsonRequest.getName(), JwtDecoder.decodeJwt(request).get("userId"));
	}
	
	@GetMapping("/getExtraCost")
    public List<ExtraCost> getExtraCost(Pageable page, HttpServletRequest request) throws IOException, JSONException {
//		Principal principal = request.getUserPrincipal();
//		String userName = principal.getName();
		List<ExtraCost> getExtraCost = ecRepository.findAllByUserId(JwtDecoder.decodeJwt(request).get("userId"));
        return getExtraCost;
    }
}
