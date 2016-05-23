package com.nicksoddsandends.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Set;
/**
 * @author 
 * @version 1.0
 * 
 */
@Entity
@Table(name = "Employees")
public class Employee implements Serializable {
    
    private static final long serialVersionUID = -7988799579036225137L;
    
    private long emp_id;
	private String name;
    private int age;
    private float salary;
    private Set<Complaint> complaints;  
    private Set<CostCenter> costCenters;

	public Employee() {
    }
    
    public Employee(String name) {
    	this.name = name;
    }
    
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    public Set<Complaint> getComplaints() {
		return complaints;
	}

	public void setComplaints(Set<Complaint> complaints) {
		this.complaints = complaints;
	}
       
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(long emp_id) {
		this.emp_id = emp_id;
	}
    @Column
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Column
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Column
    public float getSalary() {
        return salary;
    }
    public void setSalary(float salary) {
        this.salary = salary;
    }
    
    @ManyToMany(mappedBy = "employees")
    public Set<CostCenter> getCostCenters() {
		return costCenters;
	}

	public void setCostCenters(Set<CostCenter> costCenters) {
		this.costCenters = costCenters;
	}

	@Override
    public String toString() {
        return "Employee{" +
                "id=" + emp_id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}