package com.nicksoddsandends.service;

import java.util.List;

import com.nicksoddsandends.entity.CostCenter;
import com.nicksoddsandends.entity.Employee;

public interface CostCenterService {
	public CostCenter createCostCenter(CostCenter costCenter);
	public CostCenter updateCostCenter(CostCenter costCenter);
    public void deleteCostCenter(long id);
    public List<CostCenter> getAllCostCenters();
    public CostCenter getCostCenter(long id);   
    public List<CostCenter> getAllCostCenter(String costCenter);
    public List<Employee> getAllEmployeesinCostCenter(CostCenter center);

}
