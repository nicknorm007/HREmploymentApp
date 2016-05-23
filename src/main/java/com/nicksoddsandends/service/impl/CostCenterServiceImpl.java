package com.nicksoddsandends.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nicksoddsandends.dao.CostCenterDAO;
import com.nicksoddsandends.entity.CostCenter;
import com.nicksoddsandends.entity.Employee;
import com.nicksoddsandends.service.CostCenterService;

@Service
@Transactional
public class CostCenterServiceImpl implements CostCenterService {
	
	public CostCenterServiceImpl() {
		System.out.println("CostCenterServiceImpl()");
	}
	
	@Autowired
    private CostCenterDAO costCenterDAO;

	@Override
	public CostCenter createCostCenter(CostCenter costCenter) {
		return costCenterDAO.createCostCenter(costCenter);
	}

	@Override
	public CostCenter updateCostCenter(CostCenter costCenter) {
		return costCenterDAO.updateCostCenter(costCenter);
	}

	@Override
	public void deleteCostCenter(long id) {
		costCenterDAO.deleteCostCenter(id);
		
	}

	@Override
	public List<CostCenter> getAllCostCenters() {
		
		return costCenterDAO.getAllCostCenters();
	}

	@Override
	public CostCenter getCostCenter(long id) {
		
		return costCenterDAO.getCostCenter(id);
	}

	@Override
	public List<CostCenter> getAllCostCenter(String costCenter) {
		
		return null;
	}

	@Override
	public List<Employee> getAllEmployeesinCostCenter(CostCenter center) {
		
		return costCenterDAO.getAllEmployeesinCostCenter(center);
	}

}
