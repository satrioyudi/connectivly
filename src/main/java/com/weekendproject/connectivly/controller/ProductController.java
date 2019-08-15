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

import com.weekendproject.connectivly.model.ProductHistory;
import com.weekendproject.connectivly.model.Products;
import com.weekendproject.connectivly.payload.ProductHistoryRequest;
import com.weekendproject.connectivly.payload.ProductRequest;
import com.weekendproject.connectivly.repository.ProductHistoryRepository;
import com.weekendproject.connectivly.repository.ProductRepository;
import com.weekendproject.connectivly.service.ProductService;


@RestController
@RequestMapping("/api/master")
public class ProductController {
	@Autowired
    private ProductRepository repository;
	
	@Autowired
	private ProductService service;
	
	@Autowired
	private ProductHistoryRepository prodHistoryRepository;
	
	@GetMapping("/getProduct")
    public Page<Products> getAllProduct(Pageable page, HttpServletRequest request) throws IOException, JSONException {
//		Principal principal = request.getUserPrincipal();
//		String userName = principal.getName();
		System.out.println(">>>>>>>>>>>>>>>>>>");
		System.out.println("user login : "+JwtDecoder.decodeJwt(request));
        return repository.findAllByUserIdAndDeletedAtIsNull(page, JwtDecoder.decodeJwt(request).get("userId"));
    }
	
	@PostMapping("/saveProduct")
    @ResponseStatus(HttpStatus.OK)
    public void saveProduct(@Valid @RequestBody ProductRequest jsonRequest, HttpServletRequest request) throws Exception {
//		Principal principal = request.getUserPrincipal();
		service.saveProduct(jsonRequest, JwtDecoder.decodeJwt(request).get("userId"));
    }
	
	@PostMapping("/updateProduct")
	@ResponseStatus(HttpStatus.OK)
	public void updateProduct(@Valid @RequestBody ProductRequest jsonRequest, HttpServletRequest request) throws Exception {
//		Principal principal = request.getUserPrincipal();
		service.updateProduct(jsonRequest, JwtDecoder.decodeJwt(request).get("userId"));
	}
	
	@PostMapping("/modifikasiStok")
	@ResponseStatus(HttpStatus.OK)
	public void modifikasiStok(@Valid @RequestBody ProductRequest jsonRequest, HttpServletRequest request) throws Exception {
//		Principal principal = request.getUserPrincipal();
		service.modifikasiStok(jsonRequest, JwtDecoder.decodeJwt(request).get("userId"));
	}
	
	@PostMapping("/deleteProduct")
	@ResponseStatus(HttpStatus.OK)
	public void deleteProduct(@Valid @RequestBody ProductRequest jsonRequest, HttpServletRequest request) throws Exception {
//		Principal principal = request.getUserPrincipal();
		service.deleteProduct(jsonRequest, JwtDecoder.decodeJwt(request).get("userId"));
	}
	
	@PostMapping("/historyProduct")
	@ResponseStatus(HttpStatus.OK)
	public List<ProductHistory> historyProduct(@Valid @RequestBody ProductHistoryRequest jsonRequest, HttpServletRequest request) throws Exception {
//		Principal principal = request.getUserPrincipal();
		System.out.println(jsonRequest.getProductId());
		return prodHistoryRepository.findAllByProductIdAndUserId(jsonRequest.getProductId(), JwtDecoder.decodeJwt(request).get("userId"));
	}
}
