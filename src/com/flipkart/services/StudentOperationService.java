/**
 * 
 */
package com.flipkart.services;
import com.flipkart.bean.*;

import com.flipkart.dao.*;
/**
 * @author rahul.kumarsingh
 *
 */
public class StudentOperationService implements StudentServiceInterface{

	public void registerStudent(Student student) {
		StudentDAOInterface stdOperations= new StudentDAOImplementation();
		stdOperations.registerStudent(student);
		
		
//		StudentDAOInterface stdDaoOperations=new StudentDAOImplementation();
//		stdDaoOperations.registerStudent(newStudent);
//	
	}

	
	public void viewGradeCard(int studentId) {
		// student view his grade card.
		System.out.println("Student Grade Card");
		StudentDAOInterface stdDaoOperations=new StudentDAOImplementation();
		stdDaoOperations.viewGradeCard(studentId);	
	}

	public void addCourse(int studentId,int sem,int courseCode)
	{
		StudentDAOInterface stdDaoOperations=new StudentDAOImplementation();
		stdDaoOperations.addCourse(studentId,sem,courseCode);
	}
	
	public void dropCourse(int sudentId,int courseCode)
	{
		StudentDAOInterface stdDaoOperations=new StudentDAOImplementation();
		stdDaoOperations.dropCourse(sudentId,courseCode);
	}
	public void viewCourse()
	{
		StudentDAOInterface stdDaoOperations=new StudentDAOImplementation();
		stdDaoOperations.viewCourse();

	}
	public void semesterRegistration(SemesterRegistration semRegistration)
	{
		StudentDAOInterface stdDaoOperations=new StudentDAOImplementation();
		stdDaoOperations.semesterRegisteration(semRegistration);
	}



	@Override
	public void makePayment(int studentId, float amount, boolean status, String paymentMode) {
		// TODO Auto-generated method stub
		Payment payment=new Payment();
		payment.setAmount(amount);
		payment.setPaymentMode(paymentMode);
		payment.setStudentId(studentId);
		payment.setStatus(status);
		
		PaymentDAOInterface paymentDAOOperations = new PaymentDAOImplementation();
		paymentDAOOperations.storePayment(payment);
		
	}
	

}
