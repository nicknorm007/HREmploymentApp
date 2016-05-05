package com.nicksoddsandends.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.nicksoddsandends.dao.ComplaintDAO;
import com.nicksoddsandends.entity.Complaint;
import com.nicksoddsandends.entity.Employee;
import com.nicksoddsandends.util.HibernateUtil;

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


}
