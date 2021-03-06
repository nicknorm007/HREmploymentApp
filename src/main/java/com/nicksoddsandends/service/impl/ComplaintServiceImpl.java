package com.nicksoddsandends.service.impl;

import java.util.List;

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
	        System.out.println("ComplaintServiceImpl()");
	 }
	    
	 @Autowired
	 private ComplaintDAO complaintDAO;

	 @Override
	 public Complaint createComplaint(Complaint complaint) {
		 return complaintDAO.createComplaint(complaint);
	 }

	@Override
	public List<Complaint> getAllComplaintsByEmployee(Employee employee) {
		List<Complaint> complaints = complaintDAO.getAllComplaintsByEmployee(employee);
		return complaints;
	}

}
