package com.weekendproject.connectivly.service.impl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weekendproject.connectivly.model.BackOrder;
import com.weekendproject.connectivly.model.Products;
import com.weekendproject.connectivly.model.SalesOrder;
import com.weekendproject.connectivly.model.SalesOrderProduct;
import com.weekendproject.connectivly.model.SeqNumber;
import com.weekendproject.connectivly.payload.SalesOrderRequest;
import com.weekendproject.connectivly.repository.BackOrderRepository;
import com.weekendproject.connectivly.repository.ProductRepository;
import com.weekendproject.connectivly.repository.SalesOrderProductRepository;
import com.weekendproject.connectivly.repository.SalesOrderRepository;
import com.weekendproject.connectivly.repository.SeqNumberRepository;
import com.weekendproject.connectivly.service.LogService;
import com.weekendproject.connectivly.service.SalesOrderService;

@Service
public class SalesOrderServiceImpl implements SalesOrderService{
	@Autowired
	private SalesOrderRepository repository;
	
	@Autowired
	private SalesOrderProductRepository sopRepository;
	
	@Autowired
	private LogService logService;
	
	@Autowired
	private SeqNumberRepository seqRepository;
	
	@Autowired
	private ProductRepository prodRepository;
	
	@Autowired
	private BackOrderRepository boRepository;
	
	@Override
	@Transactional
	public void saveSalesOrder(@Valid SalesOrderRequest jsonRequest, String userId) throws Exception {
		String soCode = generateSONumber();
		if (jsonRequest.getSopList().size() > 0) {
			List<SalesOrderProduct> sopList = jsonRequest.getSopList();
			for (SalesOrderProduct salesOrderProduct : sopList) {
				SalesOrderProduct sop = new SalesOrderProduct();
				sop.setCode(soCode);
				
				sop.setCreatedAt(new Date());
				sop.setPercent1(salesOrderProduct.getPercent1());
				sop.setPercent2(salesOrderProduct.getPercent2());
				sop.setPrice(salesOrderProduct.getPrice());
				sop.setProductId(salesOrderProduct.getProductId());
				
				Optional<Products> oneByid = prodRepository.findById(salesOrderProduct.getProductId());
				if (oneByid.isPresent()) {
					Products product = oneByid.get();
					if (product.getQty()-salesOrderProduct.getQuantity() < 0) {
						throw new Exception("Stock kurang dari 0");
					}
					product.setQty(product.getQty()-salesOrderProduct.getQuantity());
					prodRepository.save(product);
					
					sop.setAvailableQty(product.getQty()-salesOrderProduct.getQuantity());
				}
				
				sop.setQuantity(salesOrderProduct.getQuantity());
				sop.setSalesOrderId(salesOrderProduct.getSalesOrderId());
				sop.setTotal(salesOrderProduct.getTotal());
				sop.setUpdatedAt(salesOrderProduct.getUpdatedAt());
				sop.setUserId(userId);
				
				sopRepository.save(sop);
			}
			
		}
		
		
		
		SalesOrder so = new SalesOrder();
		so.setBonusOnlineOrder(jsonRequest.getBonusOnlineOrder());
		so.setCode(soCode);
		so.setCreatedAt(new Date());
		so.setCustomerId(jsonRequest.getCustomerId());
		so.setEmployeeId(jsonRequest.getEmployeeId());
		so.setGlobalDiscount(jsonRequest.getGlobalDiscount());
		so.setGlobalDiscountFlat(jsonRequest.getGlobalDiscountFlat());
		so.setIsApproved(false);
		so.setIsDelivered(false);
		so.setIsLinked("");
		so.setIsOverride(false);
		so.setIsReady(jsonRequest.getIsReady());
		so.setSaleRepresentativeId(jsonRequest.getSaleRepresentativeId());
		so.setSoDate(new Date());
		so.setTotal(jsonRequest.getTotal());
		so.setTotalBeforeDiscount(jsonRequest.getTotalBeforeDiscount());
		so.setUserId(userId);
		so.setIsLinked("YES");
		
		repository.save(so);
		
		logService.createLog("saveSalesOrder", new Date(), so.getCode(), userId);
		
	}
	
	private String generateSONumber() {
//		AtomicInteger seq = new AtomicInteger();
//		int nextVal = seq.incrementAndGet();
		
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		long num = 0;
		
		StringBuilder sb = new StringBuilder();
		sb.append("SO-");
		sb.append(localDate.getYear());
		sb.append("-");
		if (seqRepository.findTopByCodeOrderByIdDesc("so") != null) {
			
			if (seqRepository.findTopByCodeOrderByIdDesc("so").getSeqId() >= 10) {
				sb.append("00");
			} else if (seqRepository.findTopByCodeOrderByIdDesc("so").getSeqId() >= 100) {
				sb.append("0");
			} else {
				sb.append("000");
			}
			num = seqRepository.findTopByCodeOrderByIdDesc("so").getSeqId()+1;
		} else {
			sb.append("000");
			num = 1;
		}
		sb.append(num);
		
		SeqNumber seqNum = new SeqNumber();
		seqNum.setSeqId(num);
		seqNum.setCode("so");
		seqRepository.save(seqNum);
		
		System.out.println("SO Number : " + sb);
		return sb.toString();
	}

	@Transactional
	@Override
	public void approveSalesOrder(@Valid SalesOrderRequest jsonRequest, String userId) {
		Optional<SalesOrder> oneByCode = repository.findByCode(jsonRequest.getCode());
		if (oneByCode.isPresent()) {
			SalesOrder so = oneByCode.get();
			so.setApprovedAt(new Date());
			so.setIsApproved(true);
			
			repository.save(so);
			
			//setInvoiceHere
			
			List<SalesOrderProduct> sopList = sopRepository.findAllByCode(so.getCode());
			if (sopList.size() > 0) {
				for (SalesOrderProduct salesOrderProduct : sopList) {
					Optional<Products> p = prodRepository.findById(salesOrderProduct.getProductId());
					if (p.isPresent()) {
						Products prod = p.get();
						int sisa = prod.getQty() - salesOrderProduct.getQuantity();
						if (sisa < 0) {
							BackOrder bo = new BackOrder();
							bo.setBackOrderDate(new Date());
							bo.setCreatedAt(new Date());
							bo.setProductId(salesOrderProduct.getProductId());
							bo.setQuantity(sisa);
							bo.setUserId(userId);
//							bo.setDayCounter(dayCounter);
//							bo.setSalesInvoiceId(salesInvoiceId);
							
							boRepository.save(bo);
						}
					}
				}
				
			}
			//set history product
			
			logService.createLog("approveSalesOrder", new Date(), jsonRequest.getCode(), userId);
		}
	}

	@Override
	@Transactional
	public void editSalesOrder(@Valid SalesOrderRequest jsonRequest, String userId) throws Exception {
		if (jsonRequest.getSopList().size() > 0) {
			List<SalesOrderProduct> sopList = jsonRequest.getSopList();
			
			List<SalesOrderProduct> list = new ArrayList<SalesOrderProduct>();
			
			for (SalesOrderProduct salesOrderProduct2 : sopList) {
				
				Optional<SalesOrderProduct> oneById = sopRepository.findById(salesOrderProduct2.getId());
				if (oneById.isPresent()) {
					SalesOrderProduct sop = oneById.get();
					sop.setUpdatedAt(new Date());
					sop.setPercent1(salesOrderProduct2.getPercent1());
					sop.setPercent2(salesOrderProduct2.getPercent2());
					sop.setPrice(salesOrderProduct2.getPrice());
					sop.setProductId(salesOrderProduct2.getProductId());
					
					Optional<Products> oneByid2 = prodRepository.findById(salesOrderProduct2.getProductId());
					if (oneByid2.isPresent()) {
						Products product = oneByid2.get();
						if (product.getQty()-salesOrderProduct2.getQuantity() < 0) {
							throw new Exception("Stock kurang dari 0");
						}
						product.setQty(product.getQty()-salesOrderProduct2.getQuantity());
						prodRepository.save(product);
						
						sop.setAvailableQty(product.getQty()-salesOrderProduct2.getQuantity());
					}
					
					sop.setQuantity(salesOrderProduct2.getQuantity());
					sop.setSalesOrderId(salesOrderProduct2.getSalesOrderId());
					sop.setTotal(salesOrderProduct2.getTotal());
					sop.setUpdatedAt(salesOrderProduct2.getUpdatedAt());
					sop.setUserId(userId);
					
					list.add(sop);
				} else {
					SalesOrderProduct sop = new SalesOrderProduct();
					sop.setCode(jsonRequest.getCode());
					
					sop.setCreatedAt(new Date());
					sop.setPercent1(salesOrderProduct2.getPercent1());
					sop.setPercent2(salesOrderProduct2.getPercent2());
					sop.setPrice(salesOrderProduct2.getPrice());
					sop.setProductId(salesOrderProduct2.getProductId());
					
					Optional<Products> oneByid = prodRepository.findById(salesOrderProduct2.getProductId());
					if (oneByid.isPresent()) {
						Products product = oneByid.get();
						if (product.getQty()-salesOrderProduct2.getQuantity() < 0) {
							throw new Exception("Stock kurang dari 0");
						}
						product.setQty(product.getQty()-salesOrderProduct2.getQuantity());
						prodRepository.save(product);
						
						sop.setAvailableQty(product.getQty()-salesOrderProduct2.getQuantity());
					}
					
					sop.setQuantity(salesOrderProduct2.getQuantity());
					sop.setSalesOrderId(salesOrderProduct2.getSalesOrderId());
					sop.setTotal(salesOrderProduct2.getTotal());
					sop.setUpdatedAt(salesOrderProduct2.getUpdatedAt());
					sop.setUserId(userId);
					
					list.add(sop);
				}
			}
			
			sopRepository.saveAll(list);
		}
		
		Optional<SalesOrder> oneByCode = repository.findByCode(jsonRequest.getCode());
		if (oneByCode.isPresent()) {
			SalesOrder so = oneByCode.get();
			so.setBonusOnlineOrder(jsonRequest.getBonusOnlineOrder());
			so.setUpdatedAt(new Date());
			so.setCustomerId(jsonRequest.getCustomerId());
			so.setEmployeeId(jsonRequest.getEmployeeId());
			so.setGlobalDiscount(jsonRequest.getGlobalDiscount());
			so.setGlobalDiscountFlat(jsonRequest.getGlobalDiscountFlat());
			so.setIsApproved(false);
			so.setIsDelivered(false);
			so.setIsLinked("YES");
			so.setIsOverride(false);
			so.setIsReady(jsonRequest.getIsReady());
			so.setSaleRepresentativeId(jsonRequest.getSaleRepresentativeId());
			so.setTotal(jsonRequest.getTotal());
			so.setTotalBeforeDiscount(jsonRequest.getTotalBeforeDiscount());
			so.setUserId(userId);
			so.setIsLinked("YES");
			
			repository.save(so);
		}
		logService.createLog("editSalesOrder", new Date(), jsonRequest.getCode(), userId);
	}

	
}
