/**
 * 
 */
package com.flipkart.services;

/**
 * @author rahul.kumarsingh
 *
 */
public interface AdminServiceInterface {
	public void generateReportCard();
    public void addProfessor() ;
    public void approveStudentRegistration();
    public void cancelStudentRegistration() ;
    public void addCourse() ;
    public void removeCourse();
    public void updateCourse() ;
    public boolean validateCourseCapacity();

}
