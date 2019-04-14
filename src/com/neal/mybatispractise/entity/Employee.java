package com.neal.mybatispractise.entity;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

@Alias("Employee")
public class Employee implements Serializable{
	private Integer id;
	private String lastName;
	private String gender;
	private String email;
	private Integer deptId;
	private EmpStatus empStatus;
	private Department dept;

	public Employee() {
		super();
	}
	
	public Employee(Integer id, String lastName, String gender, String email, Integer deptId, EmpStatus empStatus) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
		this.deptId = deptId;
		this.empStatus = empStatus;
	}

	public Employee(Integer id, String lastName, String gender, String email,  Department dept) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
		this.dept = dept;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}
	
	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public EmpStatus getEmpStatus() {
		return empStatus;
	}

	public void setEmpStatus(EmpStatus empStatus) {
		this.empStatus = empStatus;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", lastName=" + lastName + ", gender=" + gender + ", email=" + email + ", deptId="
				+ deptId + ", empStatus=" + empStatus + ", dept=" + dept + "]";
	}

	



}
