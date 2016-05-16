package com.nicksoddsandends.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Complaints")
public class Complaint implements Serializable {
	
	private static final long serialVersionUID = -7988799579036225137L;
	private Employee employee;
	private long complaint_id;
    private String complaint_text;

    public Complaint() {
    }
	
	public Complaint(String text) {
		this.complaint_text = text;
    }

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public long getComplaint_id() {
		return complaint_id;
	}

	public void setComplaint_id(long complaint_id) {
		this.complaint_id = complaint_id;
	}

	@Column(name = "complaint_text", nullable = false, length=255)
	public String getComplaint_text() {
		return complaint_text;
	}

	public void setComplaint_text(String complaint_text) {
		this.complaint_text = complaint_text;
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "emp_id")
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	

}
