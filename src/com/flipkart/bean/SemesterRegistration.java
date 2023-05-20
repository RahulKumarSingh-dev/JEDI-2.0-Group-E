/**
 * 
 */
package com.flipkart.bean;

/**
 * @author rahul.kumarsingh
 *
 */
public class SemesterRegistration {
	private int studentId;
	/**
	 * @return the studentId
	 */
	public int getStudentId() {
		return studentId;
	}
	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	/**
	 * @return the semester
	 */
	public int getSemester() {
		return semester;
	}
	/**
	 * @param semester the semester to set
	 */
	public void setSemester(int semester) {
		this.semester = semester;
	}
	/**
	 * @return the dateOfRegistration
	 */
	public String getDateOfRegistration() {
		return dateOfRegistration;
	}
	/**
	 * @param dateOfRegistration the dateOfRegistration to set
	 */
	public void setDateOfRegistration(String dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}
	private int semester;
	private String dateOfRegistration;
	

}
