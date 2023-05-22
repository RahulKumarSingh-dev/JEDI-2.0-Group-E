package com.flipkart.dao;

import com.flipkart.bean.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAOImplementation implements StudentDAOInterface{
	// Step 1
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/CRSDatabase";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "rahulkumar";

	public void registerStudent(Student std) {
		System.out.println("Inside Dao");
		Connection conn = null;
		PreparedStatement stmt = null;

		User user= new User();
		user.setName(std.getName());
		user.setPassword(std.getPassword());
		user.setRole("Student");
		user.setUserId(std.getStudentId());
		
		UserDAOInterface userOperations = new UserDAOImplementation();
		userOperations.addUser(user);
		try {

			// Step 3 Register Driver here and create connection

			Class.forName("com.mysql.jdbc.Driver");

			// Step 4 make/open a connection

			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			String sql = "insert into student values(?,?,?)";
			// String sql = "UPDATE Employees set age=? WHERE id=?";
			// String sql1="delete from employee where id=?";
			// stmt.setInt(1, 101);
			stmt = conn.prepareStatement(sql);

			// Hard coded data

			// Bind values into the parameters.
			stmt.setInt(1, std.getStudentId()); // This would set age
//			stmt.setString(2, std.getName());
//			stmt.setString(3, std.getPassword());
//			stmt.setString(4, std.getRole());
			stmt.setString(2, std.getBranch());
			stmt.setInt(3, std.getBatch());
			stmt.executeUpdate();

			// Let us update age of the record with ID = 102;
//			     int rows = stmt.executeUpdate();
//			     System.out.println("Rows impacted : " + rows );

//			      Let us select all the records and display them.
//			sql = "SELECT studentId, name  FROM student";
//			ResultSet rs = stmt.executeQuery(sql);
//			//
//			// STEP 5: Extract data from result set
//			while (rs.next()) {
//				// Retrieve by column name
//				int stdId = rs.getInt("studentId");
//				String stdName = rs.getString("name");
//
//				// Display values
//				System.out.print("ID: " + stdId);
//				System.out.print(", Age: " + stdName);
//
//			}
			// STEP 6: Clean-up environment
			// rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		}
	}

	public void viewGradeCard(int studentId) {
		System.out.println("Inside Dao");
		Connection conn = null;
		PreparedStatement stmt = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");

			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			String sql = "SELECT gradeCard.userId,gradeCard.semester,cpi,courseCode,grade FROM gradeCard join registeredCourse where gradeCard.userId=registeredCourse.userId";
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			//
			// STEP 5: Extract data from result set
			while (rs.next()) {

				int stdId = rs.getInt("gradeCard.userId");
				int sem = rs.getInt("gradeCard.semester");
				Float cpi = rs.getFloat("cpi");
				int courseCode = rs.getInt("courseCode");
				String grade = rs.getString("grade");
				if (studentId == stdId) {
					System.out.println("Student Id: " + stdId);
					System.out.println("Semester: " + sem);
					System.out.println("CPI: " + cpi);
					System.out.println("Course Code: " + courseCode);
					System.out.println("Grade: " + grade);
				}
			}
			// STEP 6: Clean-up environment
			// rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		}
	}

	public void addCourse(int studentId, int sem, int courseCode) {
		System.out.println("Inside Dao");
		Connection conn = null;
		PreparedStatement stmt = null;

		try {

			// Step 3 Register Driver here and create connection

			Class.forName("com.mysql.jdbc.Driver");

			// Step 4 make/open a connection

			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			String sql = "insert into registeredCourse values(?,?,?,?)";
			
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, courseCode);
			stmt.setInt(2, sem);
			stmt.setInt(3, studentId);
			stmt.setString(4, "not Alloted");
			stmt.executeUpdate();

			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		}

	}

	public void dropCourse(int studentId, int courseCode) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");

			// Step 4 make/open a connection

			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			String sql = "delete from registeredCourse where courseCode=? and userId=?";
			// String sql = "UPDATE Employees set age=? WHERE id=?";
			// String sql1="delete from employee where id=?";

			stmt = conn.prepareStatement(sql);

			// Hard coded data

			stmt.setInt(1, courseCode);
			stmt.setInt(2, studentId);

			int x = stmt.executeUpdate();

			if (x > 0) {
				System.out.println("Record deleted successfully");
				stmt.close();
				conn.close();
			} else {
				System.out.println("Record not found");
			}

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		}
	}

	public void semesterRegisteration(SemesterRegistration semRegistration)
	{
		Connection conn = null;
		PreparedStatement stmt = null;

		try {

			// Step 3 Register Driver here and create connection

			Class.forName("com.mysql.jdbc.Driver");

			// Step 4 make/open a connection

			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			String sql = "insert into semesterRegistration values(?,?,?)";
			
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1,semRegistration.getStudentId());
			stmt.setInt(2, semRegistration.getSemester());
			stmt.setString(3, semRegistration.getDateOfRegistration());
			stmt.executeUpdate();

			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		}
	}
	
	public void viewCourse() {
		System.out.println("Inside Dao");
		Connection conn = null;
		PreparedStatement stmt = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");

			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			String sql = "select courseCode, courseName from course";
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			//
			// STEP 5: Extract data from result set
			while (rs.next()) {
				int courseCode = rs.getInt("courseCode");
				String name = rs.getString("courseName");

				System.out.println("Course Code: " + courseCode);
				System.out.println("Name: " + name);

			}
			// STEP 6: Clean-up environment
			// rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		}
	}

}
