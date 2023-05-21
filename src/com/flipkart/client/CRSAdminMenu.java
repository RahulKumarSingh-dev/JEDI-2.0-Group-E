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
public class CRSAdminMenu {
        public static void showMenu()
        {
        	Scanner input=new Scanner(System.in);
            System.out.println("-------Admin Menu----------------");
            System.out.println("1. genearte report card");
            System.out.println("2. add prof");
            System.out.println("3. approve student registration");
            System.out.println("4. add course");
            System.out.println("5. remove course");
            System.out.println("6. Logout");
            
//            AdminOperationService admin = new AdminOperationService();
            
            AdminServiceInterface admin =new AdminOperationService();
           
            Scanner takeInput = new Scanner(System.in);
            while (true)
            {
                int option=takeInput.nextInt();
                switch(option)
                {
                case 1:
//                	admin.generateReportCard();
                    break;
                case 2:
//                    admin.addProfessor();
                    break;
                case 3:
                	
                    System.out.println("------Select One Option-------");
                    System.out.println("1. Approve All Students");
                    System.out.println("2. Approve by Student ID ");
                    
                    int selectedOption=input.nextInt();
                    
                    switch(selectedOption) {
                    
                    case 1: 
                    	System.out.println("Approved All Student!!");  
                        break;
                        
                    case 2: 
                    	System.out.println("Enter the Student Id:");
                            int stdId=input.nextInt();
                            System.out.println(stdId+" Approved!!");
                        break;
                        
                    default: System.out.println("Invalid Choice!!");
                        
                        
                    }
                    admin.approveStudentRegistration();
                    
                    break;
                case 4:
//                    admin.addCourse();
                    break;
                case 5:
//                    admin.removeCourse();
                    break;
                case 6 :
                    showMenu();
                    break;
                    
                default:
                    System.out.println("choose a valid optiopn");
                }
            }
            
        }
}