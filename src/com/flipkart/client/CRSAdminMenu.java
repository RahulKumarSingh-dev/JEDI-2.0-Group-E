/**
 * 
 */
package com.flipkart.client;
import com.flipkart.bean.Course;

import com.flipkart.bean.Professor;
//import com.flipkart.bean.*;
import com.flipkart.services.*;

import java.util.*;

/**
 * @author sri.vyshnavi
 *
 */
public class CRSAdminMenu {
	public static void showOptions() {
		System.out.println("-------Admin Menu----------------");
//      System.out.println("1. genearte report card");
      System.out.println("1. add professor");
      System.out.println("2. assign course to professor");
      System.out.println("3. add course");
      System.out.println("4. remove course");
      System.out.println("5. Logout");
	}
        public static void showMenu()
        {
        	
            
            
//            AdminOperationService admin = new AdminOperationService();
            
            AdminServiceInterface admin =new AdminOperationService();
           
            Scanner takeInput = new Scanner(System.in);
            while (true)
            {
            	showOptions();
                int option=takeInput.nextInt();
                switch(option)
                {
                case 1:
                	System.out.println("Enter the name");
                	String name=takeInput.next();
                	System.out.println("Enter the Id");
                	int id=takeInput.nextInt();
                	System.out.println("Enter the password");
                	String password=takeInput.next();
                	System.out.println("Enter the doj");
                	String doj=takeInput.next();
                	System.out.println("Enter the department");
                	String department = takeInput.next();
                	String role = "Professor";
                	Professor professor =new Professor();
                	professor.setDepartment(department);
                	professor.setDoj(doj);
                	professor.setName(name);
                	professor.setPassword(password);;
                	professor.setRole(role);
                	professor.setUserId(id);
                	
                	admin.addProfessor(professor);
                	System.out.println("Professor added successfully");
                    break;
                case 2:
                	System.out.println("Enter course code");
                	int courseCode=takeInput.nextInt();
                	System.out.println("Enter professor Id");
                	int professorId=takeInput.nextInt();
                	admin.assignCourseToProfessor(courseCode, professorId);
                	System.out.println("Course added in professor profile successfully.");
                    break;
//                case 3:
//                	
//                    System.out.println("------Select One Option-------");
//                    System.out.println("1. Approve All Students");
//                    System.out.println("2. Approve by Student ID ");
//                    
//                    int selectedOption=input.nextInt();
//                    
//                    switch(selectedOption) {
//                    
//                    case 1: 
//                    	System.out.println("Approved All Student!!");  
//                        break;
//                        
//                    case 2: 
//                    	System.out.println("Enter the Student Id:");
//                            int stdId=input.nextInt();
//                            System.out.println(stdId+" Approved!!");
//                    
//                    admin.approveStudentRegistration();
//                    
//                    break;
                case 3:
                	System.out.println("Enter course code");
                	courseCode=takeInput.nextInt();
                	System.out.println("Enter course name");
                	String courseName=takeInput.next();
                	System.out.println("1. Offered \n 2. Not offered");
                	int type=takeInput.nextInt();
                	System.out.println("Enter instructor id");
                	int instructorId = takeInput.nextInt();
                	boolean isOffered = false;
                	if(type==1)isOffered=true;
                	Course course=new Course();
                	course.setCourseCode(courseCode);
                	course.setInstructorId(instructorId);
                	course.setName(courseName);
                	course.setIsOffered(isOffered);
                    admin.addCourse(course);
                    System.out.println("Course is added");
                
                    break;
                case 4:
                	System.out.println("Enter course code");
                	courseCode=takeInput.nextInt();
                    admin.removeCourse(courseCode);
                    System.out.println("Course deleted.");
                	
                    break;
                case 5 :
                	                    return;
                    
                default:
                    System.out.println("choose a valid optiopn");
                }
            }
            
        }
}