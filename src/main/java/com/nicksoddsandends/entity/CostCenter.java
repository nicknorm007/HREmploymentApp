package com.nicksoddsandends.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CostCenter")
public class CostCenter implements Serializable {
	
	private static final long serialVersionUID = -7988799579036225137L;
	private long cost_id;
	private String name;
	private java.time.LocalDate createdDate;
	private Set<Employee> employees;
	
	public CostCenter() {
    }
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public long getCost_id() {
		return cost_id;
	}

	public void setCost_id(long cost_id) {
			this.cost_id = cost_id;
	}
	
	@Column(name = "name", nullable = false, length=255)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public java.time.LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(java.time.LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_center", joinColumns = @JoinColumn(name = "cost_id", referencedColumnName = "cost_id"), inverseJoinColumns = @JoinColumn(name = "emp_id", referencedColumnName = "emp_id"))
	public Set<Employee> getEmployees() {
		return employees;
	}


	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

}