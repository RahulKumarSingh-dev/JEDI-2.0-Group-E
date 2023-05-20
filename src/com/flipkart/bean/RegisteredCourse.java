/**
 * 
 */
package com.flipkart.bean;

/**
 * @author rahul.kumarsingh
 *
 */
public class RegisteredCourse  {
	private String courseCode;
	private int semester;
	private int studentId;
	private int grade;
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
}
