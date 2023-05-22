/**
 * 
 */
package com.flipkart.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author kartik.garg2
 *
 */
public class LoginCredentialsDaoImplementation implements LoginCredentialsDaoInterface{
	
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/CRSDatabase";

	  //  Database credentials
	static final String USER = "root";
	static final String PASS = "rahulkumar";
	  
	  
	public int getId(String username,String password,String role)
	{
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try{
			 
				  Class.forName("com.mysql.jdbc.Driver");
				  connection = DriverManager.getConnection(DB_URL,USER,PASS);
				 
				  //STEP 4: Executing the query
				  String sql="select * from user where name = ? and passsword = ? and role = ? " ;
				  statement = connection.prepareStatement(sql);
				  
				  statement.setString(1, username);
				  statement.setString(2, password);
				  statement.setString(3, role);
				
				  ResultSet rs = statement.executeQuery();
				  if(rs.next())
				  {
				     while(rs.next()){
				        //Retrieve by column name
				        int userid  = rs.getInt("Userid");
				        return userid;
				        
				     }
				  }
				  else
				  {
					  return -1;
				  }
			     statement.close();
			     connection.close();
			  }
			  catch(SQLException se){
			     //Handle errors for JDBC
			     se.printStackTrace();
			  }
		      catch(Exception e){
			     //Handle errors for Class.forName
			     e.printStackTrace();
			  }
		      finally{
			     //finally block used to close resources
			     try{
			        if(statement!=null)
			           statement.close();
			     }
			     catch(SQLException se2){
			     }// nothing we can do
			     
			     try{
			        if(connection!=null)
			           connection.close();
			     }
			     catch(SQLException se){
			        se.printStackTrace();
			     }//end finally try
			     
			  }//end try
		
		return -1;
	}
	
	
	public boolean checkCredentials(int userId,String password,String role)
	{
		int flag=0;
        System.out.println("Inside Dao");
        Connection conn = null;
          PreparedStatement stmt = null;
         
          try{
         
          Class.forName("com.mysql.jdbc.Driver");

             System.out.println("Connecting to database...");
             conn = DriverManager.getConnection(DB_URL,USER,PASS);

              String sql="Select userId,password from User";
              stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery(sql);
             
//
             //STEP 5: Extract data from result set
             while(rs.next()){
              
                int uId=rs.getInt("userId");
                String pwd=rs.getString("password");
                
           
                if(userId==uId && password.equals(pwd))
                {
                
                    flag=1;
                }
             }
             stmt.close();
             conn.close();
             
             //STEP 6: Clean-up environment
            // rs.close();
            
          }catch(SQLException se){
             //Handle errors for JDBC
             se.printStackTrace();
          }catch(Exception e){
             //Handle errors for Class.forName
             e.printStackTrace();
          }finally{
             //finally block used to close resources
             try{
                if(stmt!=null)
                   stmt.close();
             }catch(SQLException se2){
             }// nothing we can do
             try{
                if(conn!=null)
                   conn.close();
             }catch(SQLException se){
                se.printStackTrace();
             }//end finally try
          }
          if(flag==0)
          {
              return false;
          }
          return true;
//		Connection connection = null;
//		PreparedStatement statement = null;
//		
//		try{
//			 
//				  Class.forName("com.mysql.jdbc.Driver");
//				  connection = DriverManager.getConnection(DB_URL,USER,PASS);
//				 
//				  //STEP 4: Executing the query
//				  String sql="select * from user where userId = ? and role = ? " ;
//				  statement = connection.prepareStatement(sql);
//				  
//				  statement.setInt(1, userId);
//				  statement.setString(2, role);
//				
//				  ResultSet rs = statement.executeQuery();
////				  if(rs.next())
////				  {
//				     while(rs.next()){
//				        //Retrieve by column name
//				        String userpassword  = rs.getString("password");
//				        if(userpassword.equals(password))
//				        {
//				        	return true;
//				        }
//				        else
//				        {
//				        	return false;
//				        }
//				        
//				     }
////				  }
////				  else
////				  {
////					  return false;
////				  }
//			     statement.close();
//			     connection.close();
//			  }
//			  catch(SQLException se){
//			     //Handle errors for JDBC
//			     se.printStackTrace();
//			  }
//		      catch(Exception e){
//			     //Handle errors for Class.forName
//			     e.printStackTrace();
//			  }
//		      finally{
//			     //finally block used to close resources
//			     try{
//			        if(statement!=null)
//			           statement.close();
//			     }
//			     catch(SQLException se2){
//			     }// nothing we can do
//			     
//			     try{
//			        if(connection!=null)
//			           connection.close();
//			     }
//			     catch(SQLException se){
//			        se.printStackTrace();
//			     }//end finally try
//			     
//			  }//end try
//		
//		return false;
	}
	
	public boolean updatePassword(int userId,String username,String oldpassword,String newpassword,String role)
	{
		Connection connection = null;
		PreparedStatement statement = null;
		
		try{
			 
			  Class.forName("com.mysql.jdbc.Driver");
			  connection = DriverManager.getConnection(DB_URL,USER,PASS);
			 
			  //STEP 4: Executing the query
			  String sql="update user set password = ? where userId = ? and name = ? and password = ? and role = ?";
			  statement = connection.prepareStatement(sql);
			  
			  statement.setString(1, newpassword);
			  statement.setInt(2, userId);
			  statement.setString(3, username);
			  statement.setString(4, oldpassword);
			  statement.setString(5, role);
			
			  int row = statement.executeUpdate();
			  
				  if (row==1 ) {    
					    return true;
				  }
				  else
				  {
					  return false;
				  }
			  
			  }
			  catch(SQLException se){
			     //Handle errors for JDBC
			     se.printStackTrace();
			  }
		      catch(Exception e){
			     //Handle errors for Class.forName
			     e.printStackTrace();
			  }
		      finally{
			     //finally block used to close resources
			     try{
			        if(statement!=null)
			           statement.close();
			     }
			     catch(SQLException se2){
			     }// nothing we can do
			     
			     try{
			        if(connection!=null)
			           connection.close();
			     }
			     catch(SQLException se){
			        se.printStackTrace();
			     }//end finally try
			     
			  }//end try
		
		return false;
	}

}
