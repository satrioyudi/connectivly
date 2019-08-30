package com.weekendproject.connectivly.service;


import javax.validation.Valid;

import com.weekendproject.connectivly.payload.PurchaseOrdersRequest;

import java.util.HashMap;

public interface PurchaseOrdersService {

//    Page<PurchaseOrders> findAllByUserId(Long id, Pageable pageRequest);

	void addPurchaseOrder(@Valid PurchaseOrdersRequest jsonRequest, String userName, int supplierId);

	void editPurchaseOrder(@Valid PurchaseOrdersRequest jsonRequest, String decodeJwt);

	void approvePurchaseOrder(@Valid PurchaseOrdersRequest jsonRequest, String decodeJwt);

	HashMap findApprovedPurchaseOrder(@Valid PurchaseOrdersRequest jsonRequest);

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
