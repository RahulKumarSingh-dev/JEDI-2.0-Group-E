/**
 * 
 */
package com.flipkart.services;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

/**
 * @author rahul.kumarsingh
 *
 */
public class AdminOperationService implements AdminServiceInterface{
	
	
	public void generateReportCard() {
		// Logic to generate the report card for the given student
		System.out.println("Report Card is generated");
	}
	
	public void addProfessor() {
		// Logic to add professor.
		System.out.println("Professor is added");
	}
	public void approveStudentRegistration() {
		// Logic to approveStudentRegistration
		
		System.out.println("Student Registration is approved");
	}
	
	public void cancelStudentRegistration() {
		// Logic to cancel Student Registration
		
		System.out.println("Student Registration is canceled.");
	}
	
	public void addCourse() {
		// Logic to add new course in the catalogue  
		System.out.println("Course is added.");
		
	}
	public void removeCourse() {
		// Logic to remove the course from the catalogue
		
		System.out.println("Course is removed.");
	}
	
	public void updateCourse() {
		// Logic to update the course from the catalogue
		
		System.out.println("Course is updated.");
	}
	
	public boolean validateCourseCapacity() {
		
		System.out.println("Validating the course capacity");
		
		return true;
	}
	

}
