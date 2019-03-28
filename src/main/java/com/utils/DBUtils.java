package com.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.beans.Student;
import com.beans.Subject;

public class DBUtils {
	
	public static List<Student> listStudent(Connection conn)throws SQLException {
		String sql = "Select * from Student WHERE useradmin=0 ";
		PreparedStatement pstm= conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<Student> list = new ArrayList<Student>();
		 while (rs.next()) {
			 String gender = rs.getString("gender");
			 String student_id = rs.getString("student_id");
			 String password = rs.getString("password");
			 Date birthday = rs.getDate("birthday");
			 boolean useradmin = rs.getBoolean("useradmin");
			 String student_name = rs.getString("student_name");
			 Student student = new Student();
			 student.setStudent_name(student_name);
			 student.setGender(gender);
			 student.setBirthday(birthday);
			 student.setPassword(password);
			 student.setStudent_id(student_id);
			 student.setUseradmin(useradmin);
	         list.add(student);
	        }
		return list;
	}
	
	public static Student findStudent(Connection conn,//
			String student_id, String password) throws SQLException {
		String sql = "Select a.student_id,a.student_name, a.password, a.gender,a.birthday, a.useradmin, a.avatar from student a "
				+"where a.student_id=? and a.password=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, student_id);
		pstm.setString(2, password);
		ResultSet rs = pstm.executeQuery();
		
		if(rs.next()) {
			String gender = rs.getString("gender");
			Date birthday = rs.getDate("birthday");
			boolean useradmin = rs.getBoolean("useradmin");
			String student_name = rs.getString("student_name");
			byte[]avatar = rs.getBytes("avatar");
			Student student = new Student();
			student.setStudent_name(student_name);
			student.setGender(gender);
			student.setBirthday(birthday);
			student.setPassword(password);
			student.setStudent_id(student_id);
			student.setUseradmin(useradmin);
			student.setAvatar(avatar);
			return student;
		}
		return null;
	}
	
	public static Student findStudent(Connection conn,//
			String student_id) throws SQLException {
		String sql = "Select a.student_id,a.student_name, a.password, a.gender,a.birthday, a.useradmin, a.avatar from student a "//
				+"where a.student_id=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, student_id);
		ResultSet rs = pstm.executeQuery();
		
		if(rs.next()) {
			String password = rs.getString("password");
			String gender = rs.getString("gender");
			Date birthday = rs.getDate("birthday");
			boolean useradmin = rs.getBoolean("useradmin");
			String student_name = rs.getString("student_name");
			byte[]avatar = rs.getBytes("avatar");
			Student student = new Student();
			student.setStudent_name(student_name);
			student.setGender(gender);
			student.setBirthday(birthday);
			student.setPassword(password);
			student.setUseradmin(useradmin);
			student.setStudent_id(student_id);
			student.setAvatar(avatar);
			return student;
		}
		return null;
	}
	
	public static byte[] avatarStudent(Connection conn,//
			String student_id) throws SQLException {
		String sql = "Select a.student_id,a.student_name, a.password, a.gender,a.birthday, a.useradmin, a.avatar from student a "//
				+"where a.student_id=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, student_id);
		ResultSet rs = pstm.executeQuery();
		
		if(rs.next()) {
			String password = rs.getString("password");
			String gender = rs.getString("gender");
			Date birthday = rs.getDate("birthday");
			boolean useradmin = rs.getBoolean("useradmin");
			String student_name = rs.getString("student_name");
			byte[]avatar = rs.getBytes("avatar");
			Student student = new Student();
			student.setStudent_name(student_name);
			student.setGender(gender);
			student.setBirthday(birthday);
			student.setPassword(password);
			student.setUseradmin(useradmin);
			student.setStudent_id(student_id);
			student.setAvatar(avatar);
			return student.getAvatar();
		}
		return null;
	}
	
	public static void createStudent(Connection conn, Student student, InputStream avatar) throws SQLException{
		String sql = "Insert into student (student_id, student_name, birthday, gender, password, avatar) values (?,?,?,?,?,?)";
   	 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, student.getStudent_id());
        pstm.setString(2, student.getStudent_name());
        pstm.setDate(3, student.getBirthday());
        pstm.setString(4, student.getGender() );
        pstm.setString(5, student.getPassword());
        pstm.setBytes(6, student.getAvatar());
        pstm.executeUpdate();
	}
	
	public static List<Subject> querySubject(Connection conn)throws SQLException {
		String sql = "Select * from subject ";
		PreparedStatement pstm= conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<Subject> list = new ArrayList<Subject>();
		 while (rs.next()) {
			 String subject_id = rs.getString("subject_id");
	            String subject_name = rs.getString("subject_name");
	            String time1 = rs.getString("time1");
	            String time2 = rs.getString("time2");
	            String place = rs.getString("place");
	            Subject subject = new Subject();
	            subject.setSubject_id(subject_id);
	            subject.setSubject_name(subject_name);
	            subject.setTime1(time1);
	            subject.setTime2(time2);
	            subject.setPlace(place);
	            list.add(subject);
	        }
		return list;
	}
	
	 public static Subject findSubject(Connection conn, String subject_id) throws SQLException {
	        String sql = "Select a.subject_id, a.subject_name, a.time1,a.time2,"
	        		+ "a.place from subject a where a.subject_id=?";
	 
	        PreparedStatement pstm = conn.prepareStatement(sql);
	        pstm.setString(1, subject_id);
	 
	        ResultSet rs = pstm.executeQuery();
	 
	        while (rs.next()) {
	            String subject_name = rs.getString("subject_name");
	            String time1 = rs.getString("time1");
	            String time2 = rs.getString("time2");
	            String place = rs.getString("place");
	            Subject Subject = new Subject(subject_id, subject_name, time1,time2, place);
	            return Subject;
	        }
	        return null;
	    }
	 
	    public static void updateSubject(Connection conn, Subject Subject) throws SQLException {
	        String sql = "Update subject set subject_name =?, time1=?, time2=?, place=?  where subject_id=? ";
	 
	        PreparedStatement pstm = conn.prepareStatement(sql);
	 
	        pstm.setString(1, Subject.getSubject_name());
	        pstm.setString(2, Subject.getTime1());
	        pstm.setString(3, Subject.getTime2());
	        pstm.setString(4, Subject.getPlace());
	        pstm.setString(5, Subject.getSubject_id());
	        
	        pstm.executeUpdate();
	    }
	 
	    public static void insertSubject(Connection conn, Subject Subject) throws SQLException {
	        String sql = "Insert into subject(subject_id,subject_name, time1,time2, place) values (?,?,?,?,?)";
	 
	        PreparedStatement pstm = conn.prepareStatement(sql);
	 
	        pstm.setString(1, Subject.getSubject_id());
	        pstm.setString(2, Subject.getSubject_name());
	        pstm.setString(3, Subject.getTime1());
	        pstm.setString(4, Subject.getTime2());
	        pstm.setString(5, Subject.getPlace());
	 
	        pstm.executeUpdate();
	    }
	 
	    public static void deleteSubject(Connection conn, String subject_id) throws SQLException {
	        String sql = "Delete From Subject where subject_id= ?";
	 
	        PreparedStatement pstm = conn.prepareStatement(sql);
	 
	        pstm.setString(1, subject_id);
	 
	        pstm.executeUpdate();
	    }
	    
	    //Timetable
	    public static List<Subject> timeTable(Connection conn, String student_id)throws SQLException {
			String sql = "Select s.subject_id,s.subject_name, s.subject_name, s.time1, s.time2, s.place from subject s, timetable t, student stu "
					+"where t.subject_id = s.subject_id AND t.student_id = stu.student_id AND stu.student_id = ? ";
			PreparedStatement pstm= conn.prepareStatement(sql);
			pstm.setString(1, student_id);
			ResultSet rs = pstm.executeQuery();
			List<Subject> list = new ArrayList<Subject>();
			 while (rs.next()) {
				 	String subject_id = rs.getString("subject_id");
		            String subject_name = rs.getString("subject_name");
		            String time1 = rs.getString("time1");
		            String time2 = rs.getString("time2");
		            String place = rs.getString("place");
		            Subject subject = new Subject();
		            subject.setSubject_id(subject_id);
		            subject.setSubject_name(subject_name);
		            subject.setTime1(time1);
		            subject.setTime2(time2);
		            subject.setPlace(place);
		            list.add(subject);
		        }
			return list;
		}
}
