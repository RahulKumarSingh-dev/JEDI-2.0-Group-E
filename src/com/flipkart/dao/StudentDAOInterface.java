package com.flipkart.dao;
import com.flipkart.bean.*;

public interface StudentDAOInterface {
	public void registerStudent(Student std);
	public void semesterRegisteration(SemesterRegistration semRegistration);
	public void viewGradeCard(int studentId);
	public void addCourse(int studentId,int sem,int courseCode);
	public void dropCourse(int studentId,int courseCode);
	public void viewCourse();

}
