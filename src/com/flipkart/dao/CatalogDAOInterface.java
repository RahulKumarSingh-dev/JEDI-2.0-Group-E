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
	
	public void removeCourse(int courseCode);
	
	public void assignCourseToProfessor(int courseCode,int professorId);

	
	public void updateCourse(int courseCode,String newInstructorId,boolean isOffered,String newCourseName) ;
}
