/**
 * 
 */
package com.flipkart.services;

import java.util.List;
import com.flipkart.dao.*;
import com.flipkart.bean.*;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

/**
 * @author rahul.kumarsingh
 *
 */
public class AdminOperationService implements AdminServiceInterface{
	
	
	public void addProfessor(Professor professor){ //done
		// Logic to add professor.
		
		
		AdminDAOInterface adminDAOOperation= new AdminDAOImplementation();
		
		adminDAOOperation.addProfessor(professor);
		
	}
	public void approveStudentRegistration() {
		// Logic to approveStudentRegistration
		
		System.out.println("Student Registration is approved");
	}
	
	
	public void addCourse(Course course) { //done
		// Logic to add new course in the catalogue 
		
		
	CatalogDAOInterface catalogOperations=new CatalogDAOImplementation();
	catalogOperations.addCourse(course);
	
		
		
	}
	public void removeCourse(String courseCode) { //done
		// Logic to remove the course from the catalogue
		CatalogDAOInterface catalogOperations=new CatalogDAOImplementation();
		catalogOperations.removeCourse(courseCode);
	}
	
	public void updateCourse(String courseCode,String newInstructorId,boolean isOffered,String newCourseName) { //done
		// Logic to update the course from the catalogue
		
		CatalogDAOInterface catalogOperations=new CatalogDAOImplementation();
		catalogOperations.updateCourse(courseCode,newInstructorId,isOffered,newCourseName);
	}
	
	public void assignCourseToProfessor(String courseCode,int professorId) {
		CatalogDAOInterface catalogOperations=new CatalogDAOImplementation();
		catalogOperations.assignCourseToProfessor(courseCode,professorId);
	}
	
	

}
