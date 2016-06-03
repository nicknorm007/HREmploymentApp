package com.nicksoddsandends.service.impl.test;

import static org.junit.Assert.*;

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
	public void testCreateEmployee()
	{
		Employee emp = new Employee();
		emp.setName("NickN");
		emp.setAge(99);
		emp.setSalary(100);
		
		Employee e = employeeService.createEmployee(emp);
		Employee newEmp = employeeService.getEmployee(e.getEmp_id());
		
		assertNotNull(newEmp);
		assertNotNull(newEmp.getEmp_id());   
	}
	@Test  
    public void testGetAllEmployees() { 
		Employee emp = new Employee();
		emp.setName("AllEmps");
		emp.setAge(99);
		emp.setSalary(100);
		
		Employee e = employeeService.createEmployee(emp);
		List<Employee> emps = employeeService.getAllEmployees();
		
		assertEquals(true, emps.get(0).getName().length() > 0);
      
    }
	@Test  
    public void testGetAllEmployeesByName() { 
		Employee emp = new Employee();
		emp.setName("AllByName");
		emp.setAge(99);
		emp.setSalary(100);
		
		Employee e = employeeService.createEmployee(emp);
		List<Employee> emps = employeeService.getAllEmployees("AllByName");
		
		assertEquals(true, emps.get(0).getName().equals("AllByName"));
      
    }
	@Test
	public void testCreateEmployeeComplaint()
	{
		
		Employee emp = new Employee();
		emp.setName("MikeTestThis");
		emp.setAge(99);
		emp.setSalary(100);
		
		Complaint complaint = new Complaint("I want joined vacation.");
		complaint.setEmployee(emp);
		
		Complaint c = complaintService.createComplaint(complaint);
		
		Complaint newComplaint = complaintService.getComplaint(c.getComplaint_id());
		
		assertEquals(true, newComplaint.getEmployee().getName().equals("MikeTestThis"));
	}
	

}
