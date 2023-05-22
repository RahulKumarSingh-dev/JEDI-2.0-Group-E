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
    public void removeCourse(int courseCode);
    public void updateCourse(int courseCode,String newInstructorId,boolean isOffered,String newCourseName) ;
    public void assignCourseToProfessor(int courseCode,int professorId);

}
