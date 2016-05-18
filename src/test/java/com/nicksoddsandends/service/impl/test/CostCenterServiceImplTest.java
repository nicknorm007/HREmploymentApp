package com.nicksoddsandends.service.impl.test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;  
import org.junit.runner.RunWith;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.test.context.ContextConfiguration;  
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.nicksoddsandends.entity.Complaint;
import com.nicksoddsandends.entity.CostCenter;
import com.nicksoddsandends.entity.Employee;
import com.nicksoddsandends.service.ComplaintService;
import com.nicksoddsandends.service.CostCenterService;
import com.nicksoddsandends.service.EmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations="classpath:test-context.xml")  
@TransactionConfiguration(defaultRollback=true,transactionManager="transactionManager")
public class CostCenterServiceImplTest {
	
	@Autowired
	private CostCenterService costCenterService;
	
	
	@Test
	public void testCostCenter()
	{
		CostCenter center = new CostCenter();
		center.setName("TestCenter");
		center.setCreatedDate(LocalDate.of(2015, 12, 31));
		
		CostCenter c = costCenterService.createCostCenter(center);
		CostCenter newCenter = costCenterService.getCostCenter(center.getCost_id());
		
		assertNotNull(newCenter);
		assertNotNull(newCenter.getCost_id());   
	}
	

}
