package com.flipkart.dao;

import java.sql.*;
import com.flipkart.bean.Payment;

public class PaymentDAOImplementation implements PaymentDAOInterface {

    // Step 1
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/CRSDatabase";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "rahulkumar";
    public boolean storePayment( Payment payment){

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(DB_URL, USER, PASS);

            
            String sql = "select name from user where userId=" + payment.getStudentId() +";";
            System.out.println(sql);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
//            	System.out.println(rs.getString("name"));
                payment.setStudentName(rs.getString("name"));
            }

            sql="insert into payment values(?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);

            
          
            stmt.setInt(1, payment.getStudentId());
            stmt.setString(2, payment.getReferenceId());
            stmt.setFloat(3, payment.getAmount());
            stmt.setBoolean(4, payment.getStatus());
            stmt.setString(5, payment.getPaymentMode());
            stmt.executeUpdate();

            st.close();
            stmt.close();
            con.close();

        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
            return false;
        }
        catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
