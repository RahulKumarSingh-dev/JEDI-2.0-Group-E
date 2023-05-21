/**
 * 
 */
package com.flipkart.constants;

/**
 * @author rahul.kumarsingh
 *
 */
public class SQLQueriesConstant {
	
	//AdminDao Queries
			public static final String DELETE_COURSE_QUERY = "delete from Course where courseCode = ?";
			public static final String ADD_COURSE_QUERY = "insert into Course(courseCode, courseName, seats, professorId) values (?, ?, ?, ?)";
			public static final String VIEW_PENDING_ADMISSION_QUERY = "select userId,name, password, role, gender, address, studentId from student, user where isApproved = 0 and studentId = userId";
			public static final String APPROVE_STUDENT_QUERY = "update Student set isApproved = 1 where studentId = ?";
			public static final String ADD_USER_QUERY = "insert into User(userId, name, password, role, gender, address) values (?, ?, ?, ?, ?, ?)";
			public static final String ADD_PROFESSOR_QUERY = "insert into Professor(professorId, department, designation) values (?, ?, ?)";
			public static final String ASSIGN_COURSE_QUERY = "update Course set professorId = ? where courseCode = ?";
			public static final String VIEW_COURSE_QUERY = "select courseCode, courseName, professorId from Course";
			public static final String VIEW_PROFESSOR_QUERY = "select userId, name, gender, department, designation, address from Professor natural join User where userId = professorId";
			public static final String SET_GENERATED_REPORT_CARD_TRUE = "update student set isReportGenerated = 1 where studentId = ?";
			public static final String GET_GENERATED_REPORT_CARD_TRUE = "select isReportGenerated from student where studentId = ?";
			public static final String ADD_STUDENT="insert into student (studentId,department,gradYear,isApproved,isRegistered,isReportGenerated,isPaid) values (?,?,?,0,0,0,0)";
			public static final String IS_APPROVED="select isApproved from student where studentId = ? ";
			public static final String GET_STUDENT_ID="select studentId from student where userId = ? ";

}
