/**
 * 
 */
package com.flipkart.services;

import com.flipkart.bean.SemesterRegistration;
import com.flipkart.bean.Student;

/**
 * @author rahul.kumarsingh
 *
 */
public interface StudentServiceInterface {
//		public void registerStudent(int stdId,String stdName,String pwd,String role,String branch,int batch);
//	    public void viewGradeCard(int studentId);
	public void semesterRegistration(SemesterRegistration semRegistration);
	public void registerStudent(Student student);

	public void viewGradeCard(int studentId);

	public void addCourse(int studentId, int sem, int courseCode);

	public void dropCourse(int sudentId, int courseCode);

	public void viewCourse();

	public void makePayment(int studentId, float amount, boolean status, String paymentMode);
}
