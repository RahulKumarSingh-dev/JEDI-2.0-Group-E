/**
 * 
 */
package com.flipkart.services;

import com.flipkart.bean.*;

/**
 * @author rahul.kumarsingh
 *
 */
public interface AdminServiceInterface {
	public void addProfessor(Professor professor);
	
    public void approveStudentRegistration();
	public void addCourse(Course course);
    public void removeCourse(String courseId);
    public void updateCourse(String courseCode,String newInstructorId,boolean isOffered,String newCourseName) ;
  

}
