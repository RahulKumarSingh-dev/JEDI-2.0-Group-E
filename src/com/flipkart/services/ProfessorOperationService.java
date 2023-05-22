/**
 * 
 */
package com.flipkart.services;
import java.util.*;
import com.flipkart.dao.ProfessorDAOImplementation;
import com.flipkart.dao.ProfessorDAOInterface;

/**
 * @author rahul.kumarsingh
 *
 */
public class ProfessorOperationService implements ProfessorOperatioinInterface{
	
	public boolean addGrades(int studentId,int courseId, int semester,String grade) {
		ProfessorDAOInterface profOperations=new ProfessorDAOImplementation();
		boolean done =profOperations.addGrades(studentId, courseId,semester, grade);
		return done;
	}
	public void viewEnrolledStudents(int professorId) {
		ProfessorDAOInterface profOperations=new ProfessorDAOImplementation();;
		List<List<String>>enrolledStudents=profOperations.getEnrolledStudents(professorId);
		
		
		for(List<String>student:enrolledStudents) {
			System.out.println(student);
		}
	}
	public void getProfessorById(int professorId) {
		
	}
}
