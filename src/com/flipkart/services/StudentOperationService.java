/**
 * 
 */
package com.flipkart.services;
import com.flipkart.bean.*;
/**
 * @author rahul.kumarsingh
 *
 */
public class StudentOperationService implements StudentServiceInterface{
	
	public void createStudent() {
		// register the new student.
		
		System.out.println("Student is registered.");
	}

	public void addCourse(int studentId, int courseId) {
		// add the course in the student registered courses

		System.out.println("Course is added");
	}

	public void dropCourse(int studentId, int courseId) {
		// remove the course from the student registered courses

		System.out.println("Course is removed");

	}

	public void viewGradeCard(int studentId) {
		// student view his grade card.
		System.out.println("Student Grade Card");
	}

	public void makePayment(int studentId) {
		// make the payment for the registered courses.
		// Create a new payment bean
        Payment payment = new Payment();
        payment.setPaymentId("P12345");
        payment.setAmount(100);
        payment.setStudentName("John Doe");
        payment.setPaymentMode("online"); // Set the payment mode to "online", "offline", or "scholarship"

        // Create a payment service instance
        PaymentOperationService paymentService = new PaymentOperationService();

        // Process the payment
        paymentService.processPayment(payment);
	}

	public void semesterRegistration(int studentId, int semester) {
		// student register in the semester.
		
		System.out.println("Student is registering in a semester.");
	}

}
