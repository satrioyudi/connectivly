package com.weekendproject.connectivly.service;

import javax.validation.Valid;

import com.weekendproject.connectivly.payload.ProductRequest;

public interface ProductService {

	void saveProduct(@Valid ProductRequest jsonRequest, String name);

	void updateProduct(@Valid ProductRequest jsonRequest, String name);

	void modifikasiStok(@Valid ProductRequest jsonRequest, String name);

	void deleteProduct(@Valid ProductRequest jsonRequest, String name);

}
