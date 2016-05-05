package com.nicksoddsandends.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nicksoddsandends.dao.ComplaintDAO;
import com.nicksoddsandends.dao.EmployeeDAO;
import com.nicksoddsandends.entity.Complaint;
import com.nicksoddsandends.entity.Employee;
import com.nicksoddsandends.service.ComplaintService;

@Service
@Transactional
public class ComplaintServiceImpl implements ComplaintService {

	
	 public ComplaintServiceImpl() {
	        System.out.println("EmployeeServiceImpl()");
	    }
	    
	 @Autowired
	 private ComplaintDAO complaintDAO;

	 @Override
	 public long createComplaint(Complaint complaint) {
		 return complaintDAO.createComplaint(complaint);
	 }

}
