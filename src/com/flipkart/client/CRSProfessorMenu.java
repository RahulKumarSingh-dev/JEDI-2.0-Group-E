/**
 * 
 */
package com.flipkart.client;

//import com.flipkart.bean.*;
import com.flipkart.services.*;

import java.util.*;

/**
 * @author sri.vyshnavi
 *
 */
public class CRSProfessorMenu {
public static void showOptions() {
	System.out.println("----Professor Menu-------");
	System.out.println("1. Add grades.");
	System.out.println("2. View enrolled students.");
	System.out.println("3. Logout");
}
	public static void showMenu(int professorId) {
		

//        ProfessorOperationService professor = new ProfessorOperationService();
		ProfessorOperatioinInterface professor = new ProfessorOperationService();

		Scanner takeInput = new Scanner(System.in);
		while (true) {
			showOptions();
			int option = takeInput.nextInt();
			switch (option) {
			case 1:
				System.out.println("Enter student id");
				int studentId = takeInput.nextInt();
				System.out.println("Enter course id");
				int courseId = takeInput.nextInt();
				System.out.println("Enter semester");
				int semester = takeInput.nextInt();
				System.out.println("Enter grade ");
				String grade = takeInput.next();
				boolean done = professor.addGrades(studentId, courseId, semester, grade);
				if (done) {
					System.out.println("Grade added successfully");
				} else {
					System.out.println("Grade not added..");

				}
				break;
			case 2:
				System.out.println("Enter course Id to view enrolled students");
				courseId = takeInput.nextInt();
				professor.viewEnrolledStudents(courseId);
				break;

			case 3:
				return;

			default:
				System.out.println("choose a valid optiopn");
			}
		}
//        ÷takeInput.close();

	}
}