package com.weekendproject.connectivly.service.impl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weekendproject.connectivly.model.ProductPurchaseOrder;
import com.weekendproject.connectivly.model.PurchaseOrders;
import com.weekendproject.connectivly.model.SalesOrder;
import com.weekendproject.connectivly.model.SeqNumber;
import com.weekendproject.connectivly.payload.PurchaseOrdersRequest;
import com.weekendproject.connectivly.repository.CustomersRepository;
import com.weekendproject.connectivly.repository.MasterRepository;
import com.weekendproject.connectivly.repository.ProductPurchaseOrderRepository;
import com.weekendproject.connectivly.repository.PurchaseOrdersRepository;
import com.weekendproject.connectivly.repository.SalesOrderRepository;
import com.weekendproject.connectivly.repository.SeqNumberRepository;
import com.weekendproject.connectivly.service.LogService;
import com.weekendproject.connectivly.service.PurchaseOrdersService;

@Service
public class PurchaseOrdesServiceImpl implements PurchaseOrdersService{
	@Autowired
    private PurchaseOrdersRepository repository;
	
	@Autowired
	private ProductPurchaseOrderRepository productPurchaseOrderRepository;
	
	@Autowired
	private LogService logService;
	
	@Autowired
	private SeqNumberRepository seqRepository;
	
	@Autowired
	private SalesOrderRepository soRepository;

	@Autowired
	private MasterRepository masterRepository;

	@Autowired
	private CustomersRepository cusRepository;
	
//    public Page<PurchaseOrders> findAllByUserId(Long userId, Pageable pageRequest) {
//        return repository.findAllByUserId(userId, pageRequest);
//
//    }

	@Override
	@Transactional
	public void addPurchaseOrder(@Valid PurchaseOrdersRequest jsonRequest, String userName, int supplierId) {
		System.out.println("jso "+jsonRequest.getTotal());
		PurchaseOrders po = new PurchaseOrders();
		po.setPoNumber(generatePoNumber());
		po.setPoDate(new Date());
		po.setIsApproved(false);
		po.setUserId(userName);
		po.setCreatedAt(new Date());
		
		repository.save(po);
		
		SalesOrder so = new SalesOrder();
		so.setCode(generateSONumber());
		so.setTotal(jsonRequest.getTotal());
		so.setTotalBeforeDiscount(jsonRequest.getTotalBeforeDiscount());
		so.setGlobalDiscount(jsonRequest.getGlobalDiscount());
		so.setGlobalDiscountFlat(jsonRequest.getGlobalDiscountFlat());
		so.setIsLinked("NO");
		so.setPoCode(po.getPoNumber());
		so.setSoDate(new Date());
		so.setIsApproved(false);
		so.setIsDelivered(false);
		so.setIsOverride(false);
		so.setIsReady(false);
//		System.out.println("jsonRequest.getCustomerCategory() "+jsonRequest.getCustomerCategory());
//		Master master = masterRepository.findByCustomerCategory(jsonRequest.getCustomerCategory());
//		Optional<Customers> cus = cusRepository.findById(master.getId());
		Long l = new Long(supplierId);
		so.setCustomerId(l);
		soRepository.save(so);
		
		List<ProductPurchaseOrder> purchasedList = new ArrayList<>();
		if (jsonRequest.getPpoList().size() > 0) {
			List<ProductPurchaseOrder> ppoList = jsonRequest.getPpoList();
			for (ProductPurchaseOrder productPurchaseOrder : ppoList) {
				
				ProductPurchaseOrder ppo = new ProductPurchaseOrder();
				ppo.setUserId(userName);
				ppo.setProductId(productPurchaseOrder.getProductId());
				ppo.setPurchaseOrderId(po.getId());
				ppo.setQuantity(productPurchaseOrder.getQuantity());
				ppo.setQuantityLeft(productPurchaseOrder.getQuantityLeft());
				
				purchasedList.add(ppo);
			}
		}
		
		if (purchasedList.size() > 0) {
			productPurchaseOrderRepository.saveAll(purchasedList);
		}
		
		logService.createLog("addPurchaseOrder", new Date(), po.getPoNumber(), userName);
	}

	private String generatePoNumber() {
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		long num = 0;
		
		StringBuilder sb = new StringBuilder();
		sb.append("PO-");
		sb.append(localDate.getYear());
		sb.append("-");
		if (seqRepository.findTopByCodeOrderByIdDesc("po") != null) {
			
			if (seqRepository.findTopByCodeOrderByIdDesc("po").getSeqId() >= 10) {
				sb.append("00");
			} else {
				sb.append("0");
			}
			num = seqRepository.findTopByCodeOrderByIdDesc("po").getSeqId()+1;
		} else {
			sb.append("000");
			num = 1;
		}
		sb.append(num);
		
		SeqNumber seqNum = new SeqNumber();
		seqNum.setSeqId(num);
		seqNum.setCode("po");
		seqRepository.save(seqNum);
		
		System.out.println("PO Number : " + sb);
		return sb.toString();
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

	@Override
	@Transactional
	public void editPurchaseOrder(@Valid PurchaseOrdersRequest jsonRequest, String userName) {
		PurchaseOrders po = repository.findByPoNumber(jsonRequest.getPoNumber());
		po.setUpdatedAt(new Date());
		po.setIsApproved(false);
		po.setUserId(userName);
		
		repository.save(po);
		
		if (jsonRequest.getPpoList().size() > 0) {
			List<ProductPurchaseOrder> ppoList = jsonRequest.getPpoList();
			for (ProductPurchaseOrder productPurchaseOrder : ppoList) {
				
				Optional<ProductPurchaseOrder> oneById = productPurchaseOrderRepository.findById(productPurchaseOrder.getId());
				if (oneById.isPresent()) {
					ProductPurchaseOrder ppo = oneById.get();
					ppo.setUserId(userName);
					ppo.setProductId(productPurchaseOrder.getProductId());
					ppo.setPurchaseOrderId(po.getId());
					ppo.setQuantity(productPurchaseOrder.getQuantity());
					ppo.setQuantityLeft(productPurchaseOrder.getQuantityLeft());
					productPurchaseOrderRepository.save(ppo);
				}
				
			}
		}
		
		logService.createLog("editPurchaseOrder", new Date(), po.getPoNumber(), userName);
		
	}

	@Override
	@Transactional
	public void approvePurchaseOrder(@Valid PurchaseOrdersRequest jsonRequest, String userName) {
		PurchaseOrders po = repository.findByPoNumber(jsonRequest.getPoNumber());
		
		SalesOrder so = soRepository.findByPoCode(po.getPoNumber());
		so.setIsLinked("YES");
		soRepository.save(so);
		
		po.setApprovedAt(new Date());
		po.setIsApproved(true);
		po.setUserId(userName);
		
		repository.save(po);
		logService.createLog("approvePurchaseOrder", new Date(), po.getPoNumber(), userName);
	}

	public HashMap<String, Object> findApprovedPurchaseOrder(@Valid PurchaseOrdersRequest jsonRequest) {
		List<PurchaseOrders> po = repository.findAllByIsApprovedTrueAndUserId(jsonRequest.getUserId());
		HashMap<String, Object> map = new HashMap<>();
		HashMap<String, Object> map1 = new HashMap<>();
		map.put("result", po);
		map.put("size", po.size());
		map1.put("data",map);
		return map1;
	}


}
