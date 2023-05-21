/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.bean.Course;

/**
 * @author rahul.kumarsingh
 *
 */
public interface CatalogDAOInterface {
	public void addCourse(Course course);
	
	public void removeCourse(String courseCode);
	
	public void assignCourseToProfessor(String courseCode,int professorId);

	
	public void updateCourse(String courseCode,String newInstructorId,boolean isOffered,String newCourseName) ;
}
