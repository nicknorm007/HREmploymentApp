package com.nicksoddsandends.service.impl.test;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.junit.Test;  
import org.junit.runner.RunWith;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.test.context.ContextConfiguration;  
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.nicksoddsandends.entity.Complaint;
import com.nicksoddsandends.entity.Employee;
import com.nicksoddsandends.service.ComplaintService;
import com.nicksoddsandends.service.EmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations="classpath:test-context.xml")  
@TransactionConfiguration(defaultRollback=true,transactionManager="transactionManager")
public class EmployeeServiceImplTest {
	
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private ComplaintService complaintService;
	
	@Test  
    public void testGetAllEmployees() {  
     List<Employee> emps = employeeService.getAllEmployees();
       
     assertNotNull(emps);  
    }  
	
	@Test
	public void testCreateEmployee()
	{
		Employee emp = new Employee();
		emp.setName("Mike");
		emp.setAge(99);
		emp.setSalary(100);
		
		Long key = employeeService.createEmployee(emp);
		Employee newEmp = employeeService.getEmployee(key);
		
		assertEquals(key.longValue(), newEmp.getEmp_id());   
	}
	@Test
	public void testCreateEmployeeComplaint()
	{
		Employee emp = new Employee();
		emp.setName("MikeCompl");
		emp.setAge(99);
		emp.setSalary(100);
		
		Set<Complaint> complaints = new HashSet<Complaint>();
		
		Complaint complaint = new Complaint("I want more vacation");
		complaint.setEmployee(emp);
		complaints.add(complaint);
		emp.setComplaints(complaints);
		
		Long key = employeeService.createEmployee(emp);
		Employee newEmp = employeeService.getEmployee(key);
		List<Complaint> complaintsByEmp = complaintService.getAllComplaintsByEmployee(newEmp);
	
		Complaint c  = complaintsByEmp.get(0);
		String text = c.getComplaint_text();
		
		assertEquals(true, text.equals("I want more vacation"));
	}
	

}
