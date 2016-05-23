package com.nicksoddsandends.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nicksoddsandends.dao.CostCenterDAO;
import com.nicksoddsandends.entity.CostCenter;
import com.nicksoddsandends.entity.Employee;
import com.nicksoddsandends.entitymanager.GenericEntityInterface;

@Repository
public class CostCenterDAOImpl implements CostCenterDAO {

	@Autowired
	protected GenericEntityInterface<CostCenter> genericEntity;
	
	protected EntityManager entityManager;
	
	public CostCenterDAOImpl() {
        System.out.println("CostCenterDAOImpl");
    }
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
    
	@Override
	public CostCenter createCostCenter(CostCenter costCenter) {
		CostCenter c = genericEntity.save(costCenter);
		return c;
	}

	@Override
	public CostCenter updateCostCenter(CostCenter costCenter) {
		return null;
	}

	@Override
	public void deleteCostCenter(long id) {
		
	}

	@Override
	public List<CostCenter> getAllCostCenters() {
		List<CostCenter> centers = genericEntity.findAll(CostCenter.class);      
        return centers;
	}

	@Override
	public CostCenter getCostCenter(long id) {
		CostCenter c = (CostCenter) genericEntity.find(id, CostCenter.class);
		return c;  
	}

	@Override
	public List<CostCenter> getAllCostCenter(String costCenter) {
		return null;
	}

	@Override
	public List<Employee> getAllEmployeesinCostCenter(CostCenter costCenter) {
		Query joinQuery = entityManager.createQuery("Select e " + "from Employee e " + 
													"inner join e.costCenters costcenter " + 
													"where costcenter.cost_id in :costId");
	      
		joinQuery.setParameter("costId", costCenter.getCost_id() );
		@SuppressWarnings("unchecked")
		List<Employee> emps = joinQuery.getResultList();
		
		return emps;
	}

}
