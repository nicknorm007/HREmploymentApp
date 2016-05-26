package com.nicksoddsandends.dao;

import java.util.List;

import com.nicksoddsandends.entity.Employee;

/**
 * @author
 * @version 1.0
 */
public interface EmployeeDAO {
    public Employee createEmployee(Employee employee);
    public Employee updateEmployee(Employee employee);
    public boolean deleteEmployee(long id);
    public List<Employee> getAllEmployees();
    public Employee getEmployee(long id);   
    public List<Employee> getAllEmployees(String employeeName);
}