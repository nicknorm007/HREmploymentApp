package com.nicksoddsandends.service.impl.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;  
import org.junit.runner.RunWith;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.test.context.ContextConfiguration;  
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.nicksoddsandends.entity.Employee;
import com.nicksoddsandends.service.EmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations="classpath:test-context.xml")  
@TransactionConfiguration(defaultRollback=true,transactionManager="transactionManager")
public class EmployeeServiceImplTest {
	
	@Autowired
	private EmployeeService employeeService;
	
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
		
		assertEquals(key.longValue(), newEmp.getId());   
	}
	

}
