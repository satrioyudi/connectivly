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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.weekendproject.connectivly.model.GoodReceivedNotes;
import com.weekendproject.connectivly.model.GrnPoProduct;
import com.weekendproject.connectivly.payload.GoodReceivedNotesRequest;
import com.weekendproject.connectivly.payload.GrnPoProductRequest;
import com.weekendproject.connectivly.payload.PurchaseOrdersRequest;
import com.weekendproject.connectivly.repository.GoodReceivedNotesRepository;
import com.weekendproject.connectivly.service.GoodReceivedNotesService;


@RestController
@RequestMapping("/api/goodReceivedNotes")
public class GoodReceivedNotesController {
	@Autowired
    private GoodReceivedNotesRepository repository;
	
	@Autowired
	private GoodReceivedNotesService goodReceivedNotesService;
	
	@PostMapping("/addGrnPoProduct")
	public void addGrnPoProduct(@Valid @RequestBody GrnPoProductRequest jsonRequest, HttpServletRequest request) throws IOException, JSONException{
		goodReceivedNotesService.addGrnPoProduct(jsonRequest, JwtDecoder.decodeJwt(request));
	}
	
	@PostMapping("/getAllGoodReceivedNotes")
    @ResponseStatus(HttpStatus.OK)
    public Page<GoodReceivedNotes> getAllGoodReceivedNotes(Pageable page, HttpServletRequest request) throws IOException, JSONException {
		Page<GoodReceivedNotes> getAllGoodReceivedNotes = repository.findAllByUserId(page, JwtDecoder.decodeJwt(request)); 
        return getAllGoodReceivedNotes;
    }
	
	@PostMapping("/addGoodReceivedNotes")
	public void addGoodReceivedNotes(@Valid @RequestBody GoodReceivedNotesRequest jsonRequest, HttpServletRequest request) throws IOException, JSONException{
		goodReceivedNotesService.addGoodReceivedNotes(jsonRequest, JwtDecoder.decodeJwt(request));
	}
	
	@PostMapping("/editPurchaseOrder")
	public void editPurchaseOrder(@Valid @RequestBody PurchaseOrdersRequest jsonRequest, HttpServletRequest request) throws IOException, JSONException{
//		purchaseOrdersService.editPurchaseOrder(jsonRequest, JwtDecoder.decodeJwt(request));
	}
	
	@PostMapping("/approveGoodReceivedNotes")
	public void approveGoodReceivedNotes(@Valid @RequestBody GoodReceivedNotesRequest jsonRequest, HttpServletRequest request) throws IOException, JSONException{
		goodReceivedNotesService.approveGoodReceivedNotes(jsonRequest, JwtDecoder.decodeJwt(request));
	}
	
	@PostMapping("/findGrnPoProductByPO")
	public List<GrnPoProduct> findGrnPoProductByPO(@Valid @RequestBody GrnPoProductRequest jsonRequest, HttpServletRequest request) throws IOException, JSONException{
		return goodReceivedNotesService.findGrnPoProductByPO(jsonRequest, JwtDecoder.decodeJwt(request));
	}
	
}
