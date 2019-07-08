package com.weekendproject.connectivly.service;

import java.util.Date;

public interface LogService {

	void createLog(String type, Date date, String desc, String name);

}
