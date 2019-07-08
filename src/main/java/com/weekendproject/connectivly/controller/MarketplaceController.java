package com.weekendproject.connectivly.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weekendproject.connectivly.model.MarketPlaceCategory;
import com.weekendproject.connectivly.repository.MarketplaceRepository;


@RestController
@RequestMapping("/api/master")
public class MarketplaceController {
	@Autowired
	private MarketplaceRepository repository;
	
	@GetMapping("/getMarketplace")
    public List<MarketPlaceCategory> getMarketplace(HttpServletRequest request) throws IOException, JSONException {
//		Principal principal = request.getUserPrincipal();
//		String userName = principal.getName();
		System.out.println(">>>>> " + repository.findAll());
        return repository.findAll();
    }
}
