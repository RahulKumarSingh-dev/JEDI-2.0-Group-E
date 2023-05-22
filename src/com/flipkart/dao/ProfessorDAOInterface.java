/**
 * 
 */
package com.flipkart.dao;

import java.util.List;

/**
 * @author sri.vyshnavi
 *
 */
public interface ProfessorDAOInterface {
	
	public List<List<String>> getEnrolledStudents(int profId);

	public boolean addGrades(int studentId, int courseCode, int semester, String grade);

	public String getProfessorById(String profId);

}
