
package com.flipkart.client;

import java.util.*;

import com.flipkart.bean.Student;
import com.flipkart.services.*;

/**
 * @author LENOVO
 *
 */

public class CRSApplicationClient {

	/**
	 * @param args
	 */



	public static void menuOptions() {
		System.out.println("Welcome to Course Registration System");
		System.out.println("1. Login");
		System.out.println("2. Student Registration");
		System.out.println("3. Update Password");
		System.out.println("4. Logout");

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CRSApplicationClient crsApplication = new CRSApplicationClient();
		Scanner takeInput = new Scanner(System.in);
		menuOptions();
		int choice = takeInput.nextInt();
		while (choice != 4) {

			switch (choice) {
			case 1:
				
				crsApplication.loginUser();
				break;

			case 2:
				crsApplication.registerStudent();
				break;

			case 3:
				crsApplication.updatePassword();
				break;
				
			case 4: 
				System.out.println("*************End************");
            	return;
			default:
				System.out.println("Invalid Input");

			}
			menuOptions();
			choice = takeInput.nextInt();
		}
		takeInput.close();

	}

	public static int getId(String userName, String password, String role) {
		return 1;
	}

	public int registerStudent() {
        StudentServiceInterface stdOperations=new StudentOperationService();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Student Id:");
        int stdId=sc.nextInt();
        System.out.println("Enter the Student Name:");
        String stdName=sc.next();
        System.out.println("Enter the Password:");
        String password=sc.next();
        String role="Student";
        System.out.println("Enter the Branch:");
        String branch=sc.next();
        System.out.println("Enter the Batch:");
        int batch=sc.nextInt();
        
        
        Student student=new Student();
        student.setBatch(batch);
        student.setBranch(branch);
        student.setName(stdName);
        student.setPassword(password);
        student.setRole(role);
        student.setStudentId(stdId);
        stdOperations.registerStudent(student);
       System.out.println("student added");
        return stdId;
    }

	public void loginUser() {
		Scanner takeInput = new Scanner(System.in);
		System.out.println("Enter the userId:");
		int userId = takeInput.nextInt();
		System.out.println("Enter the Password:");
		String password = takeInput.next();
		System.out.println("Enter the Role: Admin, Student, Professor");
		LoginCredentialsInterface loginOperations=new LoginCredentialsService();
		String role = takeInput.next();
		boolean validcredential=loginOperations.checkCredentials(userId,password,role);
		if(!validcredential) {
			System.out.println("Invalid Credentials!");
			return ;
		}
		else
		{
		switch (role) {

		case "Admin":
			System.out.println("Admin with"+userId+" Logged In Successfully");
			CRSAdminMenu.showMenu();
			break;

		case "Student":
			System.out.println("Student with"+userId+" Logged In Successfully");
			CRSStudentMenu.showMenu(userId);
//			CRSStudentMenu.showMenu(getId(userId, password, role));
			break;

		case "Professor":
			System.out.println("Professor with"+userId+" Logged In Successfully");
			CRSProfessorMenu.showMenu(userId);
//			CRSProfessorMenu.showMenu(getId(userId, password, role));
			break;

		default:
			System.out.println("Inavlid Role!");
		}
		}

	}
	

	public void updatePassword() {
		
		Scanner takeInput = new Scanner(System.in);
System.out.println("Enter User Id");
int userId = takeInput.nextInt();
		System.out.println("Enter the username:");
		String userName = takeInput.next();
		
		System.out.println("Enter the Old Password:");
		String oldPassword = takeInput.next();
		
		System.out.println("Enter the new Password:");
		String newPassword = takeInput.next();
		
		System.out.println("Enter the Role:");
		String role = takeInput.next();
		
		LoginCredentialsInterface loginOption = new LoginCredentialsService();
		loginOption.updatePassword(userId,userName, oldPassword, newPassword, role);
		System.out.println("Your password get updated.");
	}

}