package com.nicksoddsandends.dao;

import java.util.List;

import com.nicksoddsandends.entity.Complaint;
import com.nicksoddsandends.entity.Employee;

public interface ComplaintDAO {
	 public Complaint createComplaint(Complaint complaint);
	 public List<Complaint> getAllComplaintsByEmployee(Employee employee);
}
