package com.nicksoddsandends.dao.impl;

import com.nicksoddsandends.dao.EmployeeDAO;
import com.nicksoddsandends.entity.Employee;
import com.nicksoddsandends.entitymanager.GenericEntityInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @version 1.0
 */

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    
	@Autowired
	protected GenericEntityInterface<Employee> genericEntity;
	
	public EmployeeDAOImpl() {
        System.out.println("EmployeeDAOImpl");
    }
    
    
    @Override
    public Employee createEmployee(Employee employee) {
		Employee emp = (Employee) genericEntity.save(employee);  
		return emp;
        
    }
    
    @Override
    public Employee updateEmployee(Employee employee) {
		return employee;        
        
    }
    
    @Override
    public void deleteEmployee(long id) {
        Employee employee = new Employee();
        employee.setEmp_id(id);
        
    }
    
    @Override
    public List<Employee> getAllEmployees() {
		List<Employee> emps = genericEntity.findAll(Employee.class);      
        return emps;
    }
    
    @Override
    public Employee getEmployee(long id) {
    	Employee emp = (Employee) genericEntity.find(id, Employee.class);
		return emp;     
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Employee> getAllEmployees(String employeeName) {
		return null; 
    	
    }
        
}
