package com.weekendproject.connectivly.service.impl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weekendproject.connectivly.model.GoodReceivedNotes;
import com.weekendproject.connectivly.model.GrnPoProduct;
import com.weekendproject.connectivly.model.SeqNumber;
import com.weekendproject.connectivly.payload.GoodReceivedNotesRequest;
import com.weekendproject.connectivly.payload.GrnPoProductRequest;
import com.weekendproject.connectivly.repository.GoodReceivedNotesRepository;
import com.weekendproject.connectivly.repository.GoodReceivedNotesRepository.GrnPoProduct2;
import com.weekendproject.connectivly.repository.GrnPoProductRepository;
import com.weekendproject.connectivly.repository.SeqNumberRepository;
import com.weekendproject.connectivly.service.GoodReceivedNotesService;
import com.weekendproject.connectivly.service.LogService;

@Service
public class GoodReceivedNotesServiceImpl implements GoodReceivedNotesService{
	@Autowired
    private GoodReceivedNotesRepository repository;
	
	@Autowired
	private GrnPoProductRepository grnRepository;
	
	@Autowired
	private LogService logService;
	
	@Autowired
	private SeqNumberRepository seqRepository;
	
	@Override
	public void addGrnPoProduct(@Valid GrnPoProductRequest jsonRequest, String userName) {
		List<GrnPoProduct> grnPayloadList = jsonRequest.getGrnPoList();
		List<GrnPoProduct> list = new ArrayList<GrnPoProduct>();
		if (grnPayloadList.size() > 0) {
			for (GrnPoProduct grnPoProduct : grnPayloadList) {
				GrnPoProduct grnPo = new GrnPoProduct();
				grnPo.setGoodReceivedNoteId(grnPoProduct.getGoodReceivedNoteId());
				grnPo.setPurchaseOrderId(grnPoProduct.getPurchaseOrderId());
				grnPo.setProductId(grnPoProduct.getProductId());
				grnPo.setPoNumber(grnPoProduct.getPoNumber());
				grnPo.setItemCost(grnPoProduct.getItemCost());
				grnPo.setPercent1(grnPoProduct.getPercent1());
				grnPo.setPercent2(grnPoProduct.getPercent2());
				grnPo.setQuantity(grnPoProduct.getQuantity());
				grnPo.setReal(grnPoProduct.getReal());
				grnPo.setSellingPercent(grnPoProduct.getSellingPercent());
				grnPo.setSellingPrice(grnPoProduct.getSellingPrice());
				grnPo.setTotal(grnPoProduct.getTotal());
				grnPo.setUserId(userName);
				grnPo.setCreatedAt(new Date());
				list.add(grnPo);
			}
		}
		
		if (list.size() > 0) {
			grnRepository.saveAll(list);
			logService.createLog("addGrnPoProduct", new Date(), list.get(0).getId().toString(), userName);
		}
		
	}
	
	@Override
	public void addGoodReceivedNotes(@Valid GoodReceivedNotesRequest jsonRequest, String userName) {
		GoodReceivedNotes grn = new GoodReceivedNotes();
		grn.setCode(generateGrnNumber());
		grn.setGrnDate(new Date());
		grn.setGlobalDiscount(jsonRequest.getGlobalDiscount());
		grn.setSalesOrderSupplier(jsonRequest.getSalesOrderSupplier());
		grn.setIsApproved(false);
		grn.setIsPaid(false);
		grn.setUserId(userName);
		
		repository.save(grn);
		logService.createLog("addGoodReceivedNotes", new Date(), jsonRequest.getCode(), userName);
	}
	
	private String generateGrnNumber() {
//		AtomicInteger seq = new AtomicInteger();
//		int nextVal = seq.incrementAndGet();
		
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		long num = 0;
		
		StringBuilder sb = new StringBuilder();
		sb.append("GRN-");
		sb.append(localDate.getYear());
		sb.append("-");
		if (seqRepository.findTopByCodeOrderByIdDesc("grn") != null) {
			
			if (seqRepository.findTopByCodeOrderByIdDesc("grn").getSeqId() >= 10) {
				sb.append("000");
			} else if (seqRepository.findTopByCodeOrderByIdDesc("grn").getSeqId() >= 100) {
				sb.append("00");
			} else {
				sb.append("0");
			}
			num = seqRepository.findTopByCodeOrderByIdDesc("grn").getSeqId()+1;
		} else {
			sb.append("000");
			num = 1;
		}
		sb.append(num);
		
		SeqNumber seqNum = new SeqNumber();
		seqNum.setSeqId(num);
		seqNum.setCode("grn");
		seqRepository.save(seqNum);
		
		System.out.println("GRN Number : " + sb);
		return sb.toString();
	}


	@Override
	public void approveGoodReceivedNotes(@Valid GoodReceivedNotesRequest jsonRequest, String userName) {
		GoodReceivedNotes grn = repository.findByCode(jsonRequest.getCode());
		grn.setApprovedAt(new Date());
		grn.setIsApproved(true);
		grn.setUserId(userName);
		
		repository.save(grn);
		logService.createLog("approveGoodReceivedNotes", new Date(), grn.getCode(), userName);
	}

	@Override
	public List<GrnPoProduct> findGrnPoProductByPO(@Valid GrnPoProductRequest jsonRequest, String decodeJwt) {
		List<GrnPoProduct> gppList = grnRepository.findAllByPoNumber(jsonRequest.getPoNumber());
		return gppList;
	}
	
	@Override
	public List<GrnPoProduct2> findGrnPoProductByCode(@Valid GoodReceivedNotesRequest jsonRequest, String decodeJwt) {
		List<GrnPoProduct2> list = repository.findGrnPoProductByCode(jsonRequest.getCode());
		return list;
	}
	
}
