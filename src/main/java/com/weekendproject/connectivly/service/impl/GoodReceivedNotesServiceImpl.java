package com.weekendproject.connectivly.service.impl;

import java.time.LocalDate;
import java.time.ZoneId;
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
		GrnPoProduct grnPo = new GrnPoProduct();
		grnPo.setGoodReceivedNoteId(jsonRequest.getGoodReceivedNoteId());
		grnPo.setPurchaseOrderId(jsonRequest.getPurchaseOrderId());
		grnPo.setProductId(jsonRequest.getProductId());
		grnPo.setPoNumber(jsonRequest.getPoNumber());
		grnPo.setItemCost(jsonRequest.getItemCost());
		grnPo.setPercent1(jsonRequest.getPercent1());
		grnPo.setPercent2(jsonRequest.getPercent2());
		grnPo.setQuantity(jsonRequest.getQuantity());
		grnPo.setReal(jsonRequest.getReal());
		grnPo.setSellingPercent(jsonRequest.getSellingPercent());
		grnPo.setSellingPrice(jsonRequest.getSellingPrice());
		grnPo.setTotal(jsonRequest.getTotal());
		grnPo.setUserId(userName);
		grnPo.setCreatedAt(new Date());
		grnRepository.save(grnPo);
		
		logService.createLog("addGrnPoProduct", new Date(), grnPo.getId().toString(), userName);
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

	
}
