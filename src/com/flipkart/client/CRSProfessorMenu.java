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
    
    public static void showMenu(int studentId)
    {
        System.out.println("----Professor Menu-------");
        System.out.println("1. Add grades.");
        System.out.println("2. View enrolled students.");
        System.out.println("3. Logout");
        System.out.println("4. Exit.");
        
        
//        ProfessorOperationService professor = new ProfessorOperationService();
        ProfessorOperatioinInterface professor=new ProfessorOperationService();
        
        Scanner takeInput = new Scanner(System.in);
        while (true)
        {
            int option=takeInput.nextInt();
            switch(option)
            {
            case 1:
                professor.addGrades(101,"A","b");
                break;
            case 2:
                professor.viewEnrolledStudents("101");
                break;
                
            case 3:
            	showMenu(101);
            	break;
            	
            case 4: 
            	System.out.println("*************End************");
            	return;
            
            default:
                System.out.println("choose a valid optiopn");
            }
        }
//        ÷takeInput.close();
        
    }
}