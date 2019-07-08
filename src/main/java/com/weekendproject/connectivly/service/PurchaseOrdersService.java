package com.weekendproject.connectivly.service;


import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.weekendproject.connectivly.model.PurchaseOrders;
import com.weekendproject.connectivly.payload.PurchaseOrdersRequest;

public interface PurchaseOrdersService {

    Page<PurchaseOrders> findAllByUserId(Long id, Pageable pageRequest);

	void addPurchaseOrder(@Valid PurchaseOrdersRequest jsonRequest, String userName);

	void editPurchaseOrder(@Valid PurchaseOrdersRequest jsonRequest, String decodeJwt);

	void approvePurchaseOrder(@Valid PurchaseOrdersRequest jsonRequest, String decodeJwt);

//    Page<Branch> searchBranches(List<SearchColumn> columns, Pageable pageable);
//
//    void deleteBranch(String solId, DeleteBranchRequest jsonRequest);
//
//    void updateBranch(String id, UpdateBranchRequest jsonRequest);
//
//    void createBranch(CreateBranchRequest jsonRequest);
//
//    void deleteBranch(DeleteBranchRequest jsonRequest);
}
