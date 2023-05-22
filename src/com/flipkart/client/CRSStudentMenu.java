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
        StudentServiceInterface student = new StudentOperationService();
        while (true)
        {
            System.out.println("------Student Menu---------");
            System.out.println("1. Register for semester.");
            System.out.println("2. Add courses.");
            System.out.println("3. Drop courses.");
            System.out.println("4. View grades.");
            System.out.println("5. View Courses");
            System.out.println("6. Pay fees.");
            System.out.println("7. Logout");
            System.out.println("8. Exit");


        	Scanner takeInput = new Scanner(System.in);
            int option= Integer.parseInt(takeInput.nextLine());
         
            switch(option)
            {
            case 1:System.out.println("Enter the semester");
            int sem=takeInput.nextInt();
            System.out.println("Enter the registration date");
            String dateOfRegistration=takeInput.next();
            SemesterRegistration semRegistration=new SemesterRegistration();
            semRegistration.setStudentId(studentId);
            semRegistration.setSemester(sem);
            semRegistration.setDateOfRegistration(dateOfRegistration);
                student.semesterRegistration(semRegistration);
                break;
            case 2:System.out.println("Enter the course Code");
        	int courseCode=takeInput.nextInt();
        	System.out.println("Enter the semester");
        	int sem1=takeInput.nextInt();
            student.addCourse(studentId,sem1,courseCode);
            break;
        case 3:
        	System.out.println("Enter the Course Code");
        	courseCode=takeInput.nextInt();
            student.dropCourse(studentId,courseCode);
            break;
        case 4:
        student.viewGradeCard(studentId);
        	break;
        	
        case 5:
        	student.viewCourse();
            break;
            	
            case 6:

                float amount = 10000;
                boolean status = false;
                String paymentModeS = "";

                boolean paymentNotComplete = true;
                while(paymentNotComplete){
                    System.out.println("Please Choose Mode of Payment");
                    System.out.println("Press \n1 for Online");
                    System.out.println("2 for Offline");
                    System.out.println("3 for Scholarship");
                    System.out.println("4 to quit");
                    String paymentMode = takeInput.nextLine();
                    switch (paymentMode) {
                        case "1":
                            paymentModeS = "Online";
                            while(paymentNotComplete) {
                                System.out.println("Press \n1 for Card");
                                System.out.println("2 for NetBanking");
                                System.out.println("3 to quit");
                                String onlineMode = takeInput.nextLine();
                                switch (onlineMode) {
                                    case "1":
                                        System.out.println("Please Enter Card Number");
                                        takeInput.nextLine();
                                        System.out.println("Please Enter Date of Expiry");
                                        takeInput.nextLine();
                                        System.out.println("Please Enter CVV");
                                        takeInput.nextLine();
                                        paymentNotComplete = false;
                                        status =  true;
                                        System.out.println("Fees Paid.");
                                        break;
                                    case "2":
                                        System.out.println("Please Enter User Name");
                                        takeInput.nextLine();
                                        System.out.println("Please Enter Password");
                                        takeInput.nextLine();
                                        paymentNotComplete = false;
                                        status =  true;
                                        System.out.println("Fees Paid.");
                                        break;
                                    case "3":
                                        paymentNotComplete = false;
                                        break;
                                    default:
                                        System.out.println("Please choose Appropriate Mode of Payment");
                                }
                            }
                            break;
                        case "2":
                            paymentModeS = "Offline";
                            while(paymentNotComplete) {
                                System.out.println("Press \n1 for Cash");
                                System.out.println("2 for Cheque");
                                System.out.println("3 to quit");
                                String offlineMode = takeInput.nextLine();
                                switch (offlineMode) {
                                    case "1":
                                        paymentNotComplete = false;
                                        status =  true;
                                        System.out.println("Please Pay your fees at Fee Counter");
                                        break;
                                    case "2":
                                        System.out.println("Please Enter Account Number");
                                        takeInput.nextLine();
                                        System.out.println("Please Enter IFSC Code");
                                        takeInput.nextLine();
                                        System.out.println("Please Submit your Cheque at Fee Counter");
                                        paymentNotComplete = false;
                                        status =  true;
                                        break;
                                    case "3":
                                        paymentNotComplete = false;
                                        break;
                                    default:
                                        System.out.println("Please choose Appropriate Mode of Payment");
                                }
                            }
                            break;
                        case "3":
                            paymentModeS = "Scholarship";
                            paymentNotComplete = false;
                            status =  true;
                            System.out.println("Fees Paid.");
                            break;
                        case "4":
                            paymentNotComplete = false;
                            break;
                        default:
                            System.out.println("Please choose Appropriate Mode of Payment--");
                    }
                }

                if(status){
                	
                    student.makePayment(studentId, amount, status, paymentModeS);
                }
                break;
                
            case 7:
            	showMenu(101);
            	break;
                
            case 8: 
            	System.out.println("*************End************");
            	return;
            default:
                System.out.println("Choose a valid optiopn");
            }
        }
//        takeInput.close();
        
    }


}