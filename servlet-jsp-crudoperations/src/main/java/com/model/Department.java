package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DepartmentTable")
public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DeptId")
	private Long Id;
	
	private String deptName;
	
	
	@Column(name="EMAIL", unique=true)
	private String deptEmail;
	
	

	public Department() {
		// Do Nothing
	}

	public Department(String deptName, String deptEmail) {
	
		this.deptName = deptName;
		this.deptEmail = deptEmail;
		
	}

	

	

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptEmail() {
		return deptEmail;
	}

	public void setDeptEmail(String deptEmail) {
		this.deptEmail = deptEmail;
	}

	@Override
	public String toString() {
		return "Department [Id=" + Id + ", deptName=" + deptName + ", deptEmail=" + deptEmail + "]";
	}

	
}
