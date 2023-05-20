/**
 * 
 */
package com.flipkart.bean;
import java.util.*;
/**
 * @author rahul.kumarsingh
 *
 */
public class CourseCatalogue {
    private List<Course> courses;
    private String semester;
    // Additional attributes and methods as per your requirements
    
    // Getters and setters
    
    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
}
