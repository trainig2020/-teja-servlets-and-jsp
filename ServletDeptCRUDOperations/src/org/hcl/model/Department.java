package org.hcl.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Department {
	@Id@GeneratedValue(strategy = GenerationType.AUTO)
	private int deptId;
	private String deptName;
	private String deptEmail;
	
	
	public Department(int deptId, String deptName, String deptEmail) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptEmail = deptEmail;
	}
	public Department(String deptName2, String deptEmail2) {
		// TODO Auto-generated constructor stub
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
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
	
	

}
