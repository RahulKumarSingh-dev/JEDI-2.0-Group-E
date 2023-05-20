/**
 * 
 */
package com.flipkart.bean;

/**
 * @author rahul.kumarsingh
 *
 */
public class Professor extends User{
	private String department;
	private String designation ;
	private String doj;
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDoj() {
		return doj;
	}
	public void setDoj(String doj) {
		this.doj = doj;
	}
	
	
}
