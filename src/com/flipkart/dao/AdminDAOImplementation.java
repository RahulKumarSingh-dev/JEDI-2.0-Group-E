/**
 * 
 */
package com.flipkart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.flipkart.bean.*;

/**
 * @author rahul.kumarsingh
 *
 */
public class AdminDAOImplementation implements AdminDAOInterface {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/CRSDatabase";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "rahulkumar";
	
	
	
	public void addProfessor(Professor professor) {
		
		User user= new User();
		user.setName(professor.getName());
		user.setPassword(professor.getPassword());
		user.setRole("Professor");
		user.setUserId(professor.getUserId());
		
		UserDAOInterface userOperations = new UserDAOImplementation();
		userOperations.addUser(user);
		
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
			String sql = "insert into professor values(?,?,?)";
			// String sql = "UPDATE Employees set age=? WHERE id=?";
			// String sql1="delete from employee where id=?";
			// stmt.setInt(1, 101);
			stmt = conn.prepareStatement(sql);

			// Hard coded data

			int id = professor.getUserId();
			String department = professor.getDepartment();
			String doj = professor.getDoj();
			// Bind values into the parameters.
			stmt.setInt(1, id); // This would set age
			stmt.setString(2, department);
			stmt.setString(3, doj);
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
	}// end main

}
