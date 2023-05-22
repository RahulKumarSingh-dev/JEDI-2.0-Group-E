/**
 * 
 */
package com.flipkart.dao;

import java.util.*;

import java.sql.*;

/**
 * @author sri.vyshnavi
 *
 */
public class ProfessorDAOImplementation implements ProfessorDAOInterface {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/CRSDatabase";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "rahulkumar";

	public List<List<String>> getEnrolledStudents(int profId) {

		List<List<String>> enrolledStudents = new ArrayList<>();
		Connection conn = null;
		try {
			// Step 3 Register Driver here and create connection

			Class.forName("com.mysql.jdbc.Driver");

			// Step 4 make/open a connection

			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			
			String sql="Select registeredCourse.userId,semester from registeredCourse join student where registeredCourse.userId=student.studentId";
//			String sql="select registeredCourse.courseCode,registeredcourse.userId from registeredCourse inner join registeredcourse on course.courseCode = registeredcourse.courseCode where course.professorId = ? order by course.courseCode";;
//			String sql = "select course.courseCode as courseCode, course.name as courseName, registeredCourse.studentId as studentId from course innerjoin registeredCourse on course.courseCode=RegisteredCourse.courseCode where course.instructor=?";
			PreparedStatement statement = conn.prepareStatement(sql);
//			statement.setInt(1, profId);
			ResultSet rs = statement.executeQuery();

			while(rs.next())
			{
				System.out.println("Student Id = "+rs.getString("registeredCourse.userId"));
				System.out.println("Semester = "+rs.getString("semester"));
			}
//			while (rs.next()) {
//				List<String> eachStudentList = new ArrayList<>();
//				eachStudentList.add(rs.getString("courseCode"));
//				eachStudentList.add(rs.getString("courseName"));
//				eachStudentList.add(rs.getString("studentId"));
//				enrolledStudents.add(eachStudentList);
//
//			}
			statement.close();
			conn.close();
			return enrolledStudents;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return enrolledStudents;
	}

	public boolean addGrades(int userId, int courseCode, int semester, String grade) {
		Connection conn = null;
		try

		{
			Class.forName("com.mysql.jdbc.Driver");

			// Step 4 make/open a connection

			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			String sql = "update registeredCourse set courseCode= ? where semester=? and userId = ? and grade = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, courseCode);
			statement.setInt(2, semester);
			statement.setInt(3, userId);
			statement.setString(4, grade);
			int rowsAffected = statement.executeUpdate();
			System.out.println("something happens");
			if (rowsAffected == 1) {
				statement.close();
				conn.close();
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public String getProfessorById(String profId) {
		String profName = null;
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// Step 4 make/open a connection

			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			String sql = "select name from user where userId=?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, profId);
			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				profName = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return profName;
	}

}
