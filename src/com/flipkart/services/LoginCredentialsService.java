/**
 * 
 */
package com.flipkart.services;
import com.flipkart.dao.*;

/**
 * @author kartik.garg2
 *
 */
public class LoginCredentialsService implements LoginCredentialsInterface{
	
	LoginCredentialsDaoInterface credential = new LoginCredentialsDaoImplementation();
//	public int getId(int userId,String password,String role)
//	{
//		int id = credential.getId(userId,password,role);
//		
////		if(id==-1)
////			System.out.println("NO USER EXISTS WITH GIVEN CREDENTIALS");
////		else
////			System.out.println("SUCCESSFULL LOGIN");
//		
//		return id;
//	}
	
	public boolean updatePassword(int userId, String username,String oldpassword,String newpassword,String role)
	{
		boolean check = credential.updatePassword(userId,username,oldpassword,newpassword,role);
		
//		if(check == true)
//			System.out.println("PASSWORD UPDATED SUCCESSFULLY");
//		else
//			System.out.println("PASSWORD UPDATION FAILED");
		
		return check;
	}
	
	public boolean checkCredentials(int userId,String password,String role)
	{
		boolean check = credential.checkCredentials(userId,password,role);
		
//		if(check == true)
//			System.out.println("VERIFIED SUCCESSFULLY");
//		else
//			System.out.println("VERIFICATION FAILED");
		
		return check;
	}
}
