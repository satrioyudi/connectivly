package com.weekendproject.connectivly.service.impl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.weekendproject.connectivly.model.ProductPurchaseOrder;
import com.weekendproject.connectivly.model.PurchaseOrders;
import com.weekendproject.connectivly.model.SeqNumber;
import com.weekendproject.connectivly.payload.PurchaseOrdersRequest;
import com.weekendproject.connectivly.repository.ProductPurchaseOrderRepository;
import com.weekendproject.connectivly.repository.PurchaseOrdersRepository;
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
	
    public Page<PurchaseOrders> findAllByUserId(Long userId, Pageable pageRequest) {
        return repository.findAllByUserId(userId, pageRequest);

    }

	@Override
	public void addPurchaseOrder(@Valid PurchaseOrdersRequest jsonRequest, String userName) {
		PurchaseOrders po = new PurchaseOrders();
		po.setPoNumber(generatePoNumber());
		po.setPoDate(new Date());
		po.setIsApproved(false);
		po.setUserId(userName);
		po.setCreatedAt(new Date());
		
		repository.save(po);
		
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
//		AtomicInteger seq = new AtomicInteger();
//		int nextVal = seq.incrementAndGet();
		
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		long num = 0;
		
		StringBuilder sb = new StringBuilder();
		sb.append("PO-");
		sb.append(localDate.getYear());
		sb.append("-");
		if (seqRepository.findTopByCodeOrderByIdDesc("po") != null) {
			
			if (seqRepository.findTopByCodeOrderByIdDesc("po").getSeqId() >= 10) {
				sb.append("000");
			} else {
				sb.append("00");
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

	@Override
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
	public void approvePurchaseOrder(@Valid PurchaseOrdersRequest jsonRequest, String userName) {
		PurchaseOrders po = repository.findByPoNumber(jsonRequest.getPoNumber());
		po.setApprovedAt(new Date());
		po.setIsApproved(true);
		po.setUserId(userName);
		
		repository.save(po);
		logService.createLog("approvePurchaseOrder", new Date(), po.getPoNumber(), userName);
	}
	
}
