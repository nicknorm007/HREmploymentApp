package com.nicksoddsandends.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nicksoddsandends.dao.ComplaintDAO;
import com.nicksoddsandends.entity.Complaint;
import com.nicksoddsandends.entity.CostCenter;
import com.nicksoddsandends.entity.Employee;
import com.nicksoddsandends.entitymanager.GenericEntityInterface;


@Repository
public class ComplaintDAOImpl implements ComplaintDAO {

	protected EntityManager entityManager;
	
	public ComplaintDAOImpl() {
        System.out.println("ComplaintDAOImpl");
    }
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Autowired
	protected GenericEntityInterface<Complaint> genericEntity;

	@Override
	public Complaint createComplaint(Complaint complaint) {
		Complaint c = (Complaint) genericEntity.save(complaint);  
		return c;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Complaint> getAllComplaintsByEmployee(Employee employee) {
		List<Complaint> complaints = new ArrayList<Complaint>();
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Complaint> query = builder.createQuery(Complaint.class);
		Root<Employee> e = query.from(Employee.class);
		Join<Employee, Complaint> cmplts = e.join("complaints");
		query.select(cmplts).where(builder.equal(cmplts.get("complaint_id"), employee.getEmp_id()));
		
		complaints = entityManager.createQuery(query).getResultList();
		return complaints;
	}

	@Override
	public Complaint getComplaint(long id) {
		Complaint c = (Complaint) genericEntity.find(id, Complaint.class);
		return c; 
	}

	@Override
	public List<Complaint> findAllComplaints() {
		List<Complaint> cmplts = genericEntity.findAll(Complaint.class);
		return cmplts;
	}


}