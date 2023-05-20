/**
 * 
 */
package com.flipkart.services;

/**
 * @author rahul.kumarsingh
 *
 */
public interface StudentServiceInterface {
	  public void addCourse(int studentId, int courseId);
	    public void dropCourse(int studentId, int courseId);
	    public void viewGradeCard(int studentId);
	    public void makePayment(int studentId);
	    public void semesterRegistration(int studentId, int semester);

}
