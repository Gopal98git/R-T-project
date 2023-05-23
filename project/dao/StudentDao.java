package com.RabbitTortoise.project.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.RabbitTortoise.project.entity.Student;

@Repository
public class StudentDao {
	int id=0;
	@Autowired
	HttpSession session; 
    HttpServletRequest request;
	public Connection conn() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb?useSSL=false", "root",
				"Gopal@98");
		return conn;
	}

	public List<Student> get() throws ClassNotFoundException, SQLException {
		PreparedStatement pr = conn().prepareStatement("select name,contact,email,password from student");
		ResultSet rs = pr.executeQuery();
		List<Student> list = new ArrayList<Student>();
		while (rs.next()) {
			Student stud = new Student();
			stud.setName(rs.getString(1));
			stud.setContact(rs.getString(2));
			stud.setEmail(rs.getString(3));
			stud.setPassword(rs.getString(4));
			list.add(stud);
		}

		return list;
	}

	public boolean register(Student student2) throws ClassNotFoundException, SQLException {
		boolean isTrue=false;
		String name=student2.getName();
		if(name!=null) {
		PreparedStatement pr = conn()
				.prepareStatement("insert into student(name,contact,email,password) values(?,?,?,?)");
		pr.setString(1, student2.getName());
		pr.setString(2, student2.getContact());
		pr.setString(3, student2.getEmail());
		pr.setString(4, student2.getPassword());
			pr.executeUpdate();
			isTrue=true;
		}else {
			isTrue=false;
		}
		return isTrue;
	}

	public boolean loginCheck(String name,String pass) throws ClassNotFoundException, SQLException {
		PreparedStatement pr = conn().prepareStatement("select * from student");
		ResultSet rs = pr.executeQuery();
		String namee=name;
		String passs=pass;
		boolean isQual = false;
		while (rs.next()) {
			if(namee!=null && passs!=null) {
			if(rs.getString(2).equals(namee) && rs.getString(5).equals(passs)) {
				isQual=true;
				id=rs.getInt(1);
				break;
			} else
				isQual=false;
		} }
		return isQual;
	}
	
	public Student stu() throws ClassNotFoundException, SQLException {
		PreparedStatement pr = conn().prepareStatement("select * from student where Stud_Id=?");
		pr.setInt(1,id);
		ResultSet rs = pr.executeQuery();
		Student stu=new Student();
		while(rs.next()) {
			session.setAttribute("id", id);
			stu.setName(rs.getString(2));
			stu.setContact(rs.getString(3));
			stu.setEmail(rs.getString(4));
			stu.setPassword(rs.getString(5));
           }
			return stu;
	      }

	public String upadtestudent(Student s) throws ClassNotFoundException, SQLException {
		PreparedStatement pr = conn().prepareStatement("update student set name=?,contact=?,email=?,password=? where Stud_Id=?");
		pr.setInt(5,id);pr.setString(1, s.getName());
		pr.setString(2, s.getContact());
		pr.setString(3, s.getEmail());
		pr.setString(4, s.getPassword());
		pr.executeUpdate();
		return "Updated";
	}
	public boolean delete() throws ClassNotFoundException, SQLException {
		boolean isDeleted=false;
		PreparedStatement pr = conn().prepareStatement("delete from student where Stud_Id=?");
		pr.setInt(1, id);
		int a=pr.executeUpdate();
		if(a>0) {
			isDeleted=true;
			}
		return isDeleted;
	}

	public List<Student> loginCheckAdmin() throws SQLException, ClassNotFoundException {
		PreparedStatement pr = conn().prepareStatement("select * from student");
		ResultSet rs = pr.executeQuery();
		List<Student> list=new ArrayList<Student>();
		while (rs.next()) {
			Student s=new Student();
			s.setId(rs.getInt(1));
			s.setName(rs.getString(2));
			s.setContact(rs.getString(3));
			s.setEmail(rs.getString(4));
			s.setPassword(rs.getString(5));
			list.add(s);
			}
		return list;
	}
}