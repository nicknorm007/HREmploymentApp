package com.nicksoddsandends.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nicksoddsandends.dao.ComplaintDAO;
import com.nicksoddsandends.entity.Complaint;
import com.nicksoddsandends.entity.Employee;
import com.nicksoddsandends.util.HibernateUtil;

@Repository
public class ComplaintDAOImpl implements ComplaintDAO {

	public ComplaintDAOImpl() {
        System.out.println("ComplaintDAOImpl");
    }
    
    @Autowired
    private HibernateUtil hibernateUtil;

	@Override
	public long createComplaint(Complaint complaint) {
		return (Long) hibernateUtil.create(complaint);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Complaint> getAllComplaintsByEmployee(Employee employee) {
		List<Complaint> complaints = new ArrayList<Complaint>();
		List<Complaint> complaintObjects = hibernateUtil.fetchAllHql("select c from Complaint c, Employee e"
				+ " WHERE c.complaint_id=e.emp_id");
	
		for(Complaint c: complaintObjects) {
            complaints.add(c);
        }
		
		return complaints;
	}


}
