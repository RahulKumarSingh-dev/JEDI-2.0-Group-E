/**
 * 
 */
package com.flipkart.client;
import com.flipkart.bean.*;

import com.flipkart.services.*;

import java.util.*;

/**
 * @author sri.vyshnavi
 *
 */
public class CRSStudentMenu {

    
    
    public static void showMenu(int studentId)
    {
    	System.out.println("------Student Menu---------");
        System.out.println("1. Register for semester.");
        System.out.println("2. Add courses.");
        System.out.println("3. Drop courses.");
        System.out.println("4. View grades.");
        System.out.println("5. Pay fees.");
        System.out.println("6. Logout");
        System.out.println("7. Exit");
        
        StudentServiceInterface student = new StudentOperationService();
        
        
        while (true)
        {
        	Scanner takeInput = new Scanner(System.in);
            int option=takeInput.nextInt();
            switch(option)
            {
            case 1:
                student.semesterRegistration(studentId,2);
                break;
            case 2:
                student.addCourse(studentId,1);
                break;
            case 3:
                student.dropCourse(studentId,1);
                break;
            case 4:
                student.viewGradeCard(studentId);
                break;
            case 5:
                student.makePayment(studentId);
                break;
                
            case 6:
            	showMenu(101);
            	break;
                
            case 7: 
            	System.out.println("*************End************");
            	return;
            default:
                System.out.println("Choose a valid optiopn");
            }
        }
//        takeInput.close();
        
    }


}