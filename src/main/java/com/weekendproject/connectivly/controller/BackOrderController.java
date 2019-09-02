package com.weekendproject.connectivly.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weekendproject.connectivly.model.BackOrder;
import com.weekendproject.connectivly.payload.ProductRequest;
import com.weekendproject.connectivly.repository.BackOrderRepository;

@RestController
@RequestMapping("/api/salesOrder")
public class BackOrderController {
	@Autowired
    private BackOrderRepository repository;
	
	@GetMapping("/getAllBackOrder")
    public Page<BackOrder> getAllSalesOrder(Pageable page, HttpServletRequest request) throws IOException, JSONException {
        return repository.findAllByUserId(page, JwtDecoder.decodeJwt(request).get("userId"));
    }
	
	@GetMapping("/getAllBackOrderByProduct")
    public Page<BackOrder> getAllBackOrderByProduct(@Valid @RequestBody ProductRequest jsonRequest, HttpServletRequest request) throws IOException, JSONException {
        return repository.findAllByUserIdAndProductId(JwtDecoder.decodeJwt(request).get("userId"), jsonRequest.getId());
    }
	
}
