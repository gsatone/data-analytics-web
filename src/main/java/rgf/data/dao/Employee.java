package main.java.rgf.data.dao;

import java.util.Date;


public class Employee {
	private Integer empNo;
	private Date birthDate;
	private String firstName;
	private String lastName;
	private String gender;
	private Date hireDate;
	private Integer rowNum;

	
	public Integer getRowNum() {
		return rowNum;
	}
	public void setRowNum(Integer rowNum) {
		this.rowNum = rowNum;
	}
	public Integer getEmpNo() {
		return empNo;
	}
	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String string) {
		this.gender = string;
	}
	
	@Override
	public String toString() {
		return "Employees [empNo=" + empNo + ", birthDate=" + birthDate + ", firstName=" + firstName + ", lastName="
				+ lastName + ", gender=" + gender + ", hireDate=" + hireDate + ", rowNum=" + rowNum + "]";
	}	

}
