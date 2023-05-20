
package com.flipkart.client;

import java.util.*;


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
		Scanner takeInput = new Scanner(System.in);
		System.out.println("Enter the username:");
		String userName = takeInput.next();
		System.out.println("Enter the Password:");
		String password = takeInput.next();
		int id = 0;
		System.out.println("Student is registered with id " + id);
		return id;
	}

	public void loginUser() {
		Scanner takeInput = new Scanner(System.in);
		System.out.println("Enter the username:");
		String userName = takeInput.nextLine();
		System.out.println("Enter the Password:");
		String password = takeInput.nextLine();
		System.out.println("Enter the Role: Admin, Student, Professor");
		
		String role = takeInput.nextLine();
		switch (role) {

		case "Admin":
			System.out.println("Admin "+userName+" Logged In Successfully");
			CRSAdminMenu.showMenu();
			break;

		case "Student":
			System.out.println("Student "+userName+" Logged In Successfully");

			CRSStudentMenu.showMenu(getId(userName, password, role));
			break;

		case "Professor":
			System.out.println("Professor "+userName+" Logged In Successfully");
			CRSProfessorMenu.showMenu(getId(userName, password, role));
			break;

		default:
			System.out.println("Inavlid Role!");
		}

	}
	

	public void updatePassword() {
		
		Scanner takeInput = new Scanner(System.in);
		System.out.println("Enter the username:");
		String userName = takeInput.next();
		
		System.out.println("Enter the Old Password:");
		String oldPassword = takeInput.next();
		
		System.out.println("Enter the new Password:");
		String newPassword = takeInput.next();
		
		System.out.println("Enter the Role:");
		String role = takeInput.next();
		
		
		System.out.println("Your password get updated.");
	}

}