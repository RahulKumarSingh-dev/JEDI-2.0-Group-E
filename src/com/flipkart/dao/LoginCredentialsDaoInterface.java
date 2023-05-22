/**
 * 
 */
package com.flipkart.dao;

/**
 * @author kartik.garg2
 *
 */
public interface LoginCredentialsDaoInterface {
	
	public int getId(String username,String password,String role);
				  
	
	
	public boolean checkCredentials(int userId,String password,String role);
				  
	
	
	public boolean updatePassword(int userId,String username,String oldpassword,String newpassword,String role);
		

}
