package com.weekendproject.connectivly.service;

import java.util.List;

import javax.validation.Valid;

import com.weekendproject.connectivly.model.GrnPoProduct;
import com.weekendproject.connectivly.payload.GoodReceivedNotesRequest;
import com.weekendproject.connectivly.payload.GrnPoProductRequest;

public interface GoodReceivedNotesService {

	void addGoodReceivedNotes(@Valid GoodReceivedNotesRequest jsonRequest, String decodeJwt);

	void addGrnPoProduct(@Valid GrnPoProductRequest jsonRequest, String decodeJwt);

	void approveGoodReceivedNotes(@Valid GoodReceivedNotesRequest jsonRequest, String decodeJwt);

	List<GrnPoProduct> findGrnPoProductByPO(@Valid GrnPoProductRequest jsonRequest, String decodeJwt);

}
