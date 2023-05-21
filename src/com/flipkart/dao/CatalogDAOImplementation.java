/**
 * 
 */
package com.flipkart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.flipkart.bean.*;

/**
 * @author rahul.kumarsingh
 *
 */
public class CatalogDAOImplementation implements CatalogDAOInterface {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/CRSDatabase";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "rahulkumar";

	public void addCourse(Course course) {

		Connection conn = null;
		PreparedStatement stmt = null;

		try {

			// Step 3 Regiater Driver here and create connection

			Class.forName("com.mysql.jdbc.Driver");

			// Step 4 make/open a connection

			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			String sql = "insert into catalog values(?,?,?,?)";
			// String sql = "UPDATE Employees set age=? WHERE id=?";
			// String sql1="delete from employee where id=?";
			// stmt.setInt(1, 101);
			stmt = conn.prepareStatement(sql);

			// Hard coded data

			String courseCode = course.getCourseCode();
			String name = course.getName();
			boolean isOffered = course.getIsOffered();
			int instructorId = course.getInstructorId();
			// Bind values into the parameters.
			stmt.setString(1, courseCode); // This would set age
			stmt.setString(2, name);
			stmt.setBoolean(3, isOffered);
			stmt.setInt(4, instructorId);
			stmt.executeUpdate();

			// Let us update age of the record with ID = 102;
//		     int rows = stmt.executeUpdate();
//		     System.out.println("Rows impacted : " + rows );

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
		} // end try
		System.out.println("Goodbye!");
	}

	public void removeCourse(String courseCode) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {

			// Step 3 Regiater Driver here and create connection

			Class.forName("com.mysql.jdbc.Driver");

			// Step 4 make/open a connection

			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			String sql = "delete from catalog where courseCode=courseCode";
			// String sql = "UPDATE Employees set age=? WHERE id=?";
			// String sql1="delete from employee where id=?";
			// stmt.setInt(1, 101);
			stmt = conn.prepareStatement(sql);

			// Hard coded data

			stmt.setString(1, courseCode);

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
		} // end try
		System.out.println("Goodbye!");
	}

	public void updateCourse(String courseCode, String newInstructorId, boolean isOffered, String newCourseName) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {

			// Step 3 Regiater Driver here and create connection

			Class.forName("com.mysql.jdbc.Driver");

			// Step 4 make/open a connection

			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			String sql = "update catalog set instructorId=newInstructorId,ifOffered=isOffered,courseName=newCourseName where courseCode=courseCode";
			// String sql = "UPDATE Employees set age=? WHERE id=?";
			// String sql1="delete from employee where id=?";
			// stmt.setInt(1, 101);
			stmt = conn.prepareStatement(sql);

			// Hard coded data

			stmt.setString(1, courseCode);

			int x = stmt.executeUpdate();

			if (x > 0) {
				System.out.println("Record updated successfully");
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
		} // end try
		System.out.println("Goodbye!");
	}

	public void assignCourseToProfessor(String courseCode, int professorId) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {

			// Step 3 Regiater Driver here and create connection

			Class.forName("com.mysql.jdbc.Driver");

			// Step 4 make/open a connection

			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			String sql = "update catalog set instructorId = professorId where courseCode=courseCode";
			// String sql = "UPDATE Employees set age=? WHERE id=?";
			// String sql1="delete from employee where id=?";
			// stmt.setInt(1, 101);
			stmt = conn.prepareStatement(sql);

			// Hard coded data

			stmt.setString(1, courseCode);

			int x = stmt.executeUpdate();

			if (x > 0) {
				System.out.println("Record updated successfully");
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
		} // end try
		System.out.println("Goodbye!");
	}
}
