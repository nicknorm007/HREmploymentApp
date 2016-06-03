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
public class ComplaintServiceImplTest {
	
	@Autowired
	private ComplaintService complaintService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Test
	public void testCreateComplaint()
	{
		Employee emp = new Employee();
		emp.setName("NickComplain");
		emp.setAge(33);
		emp.setSalary(3000);
		
		Complaint complaint = new Complaint();
		complaint.setComplaint_text("More time off");
		complaint.setEmployee(emp);
		
		Complaint c = complaintService.createComplaint(complaint);
		
		Complaint newComplaint = complaintService.getComplaint(c.getComplaint_id());
		
		assertNotNull(newComplaint);
		assertNotNull(newComplaint.getComplaint_id());   
	}
	

}
