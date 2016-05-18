package com.nicksoddsandends.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nicksoddsandends.dao.CostCenterDAO;
import com.nicksoddsandends.entity.CostCenter;
import com.nicksoddsandends.entitymanager.GenericEntityInterface;

@Repository
public class CostCenterDAOImpl implements CostCenterDAO {

	@Autowired
	protected GenericEntityInterface<CostCenter> genericEntity;
	
	public CostCenterDAOImpl() {
        System.out.println("CostCenterDAOImpl");
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

}
