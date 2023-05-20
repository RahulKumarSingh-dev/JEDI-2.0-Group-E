/**
 * 
 */
package com.flipkart.services;

/**
 * @author rahul.kumarsingh
 *
 */
public interface ProfessorOperatioinInterface {
	 public void addGrades(int studentId, String courseId, String grade);
	    public void viewEnrolledStudents(String courseId);
}
