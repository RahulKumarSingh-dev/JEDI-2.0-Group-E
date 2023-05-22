/**
 * 
 */
package com.flipkart.services;

/**
 * @author rahul.kumarsingh
 *
 */
public interface ProfessorOperatioinInterface {
	 public boolean addGrades(int studentId, int courseId, int semester,String grade);
	    public void viewEnrolledStudents(int professorId);
}
