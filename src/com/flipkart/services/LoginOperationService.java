/**
 * 
 */
package com.flipkart.services;

/**
 * @author rahul.kumarsingh
 *
 */
public class LoginOperationService {
	
	
	public boolean checkCredentials(String userName,String password,String role) {
		return true;
	}
	
	public boolean updatePassword(String userName,String oldpassword,String role, String newpassword) {
		if(!checkCredentials(userName, oldpassword, role)) {
			return false;
		}
		// update password
		return true;
	}
}
