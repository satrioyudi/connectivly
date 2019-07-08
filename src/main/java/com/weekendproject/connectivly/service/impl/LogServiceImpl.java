package com.weekendproject.connectivly.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weekendproject.connectivly.model.LogProcess;
import com.weekendproject.connectivly.repository.LogRepository;
import com.weekendproject.connectivly.service.LogService;

@Service
public class LogServiceImpl implements LogService{
	@Autowired
	LogRepository repository;
	
	@Override
	public void createLog(String type, Date dateLog, String desc, String name) {
		LogProcess log = new LogProcess();
		log.setActionAt(dateLog);
		log.setDesc(desc);
		log.setAction(type);
		log.setUserId(name);
		
		repository.save(log);
	}
	
	
}
