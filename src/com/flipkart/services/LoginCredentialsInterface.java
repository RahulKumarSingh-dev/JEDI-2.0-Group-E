/**
 * 
 */
package com.flipkart.services;

/**
 * @author kartik.garg2
 *
 */
public interface LoginCredentialsInterface {
	
//	public int getId(int userId,String password,String role);
//	
	public boolean updatePassword(int userId,String username,String oldpassword,String newpassword,String role);
	
	public boolean checkCredentials(int userId,String password,String role);

}
