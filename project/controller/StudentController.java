package com.RabbitTortoise.project.controller;

import java.sql.SQLException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.RabbitTortoise.project.dao.StudentDao;
import com.RabbitTortoise.project.entity.Student;

@Controller
public class StudentController {

	@Autowired
	StudentDao dao;

	@GetMapping("ok")
	public ModelAndView ok() throws ClassNotFoundException, SQLException {
		ModelAndView view = new ModelAndView();
		view.setViewName("one");
		try {
			List<Student> list = dao.get();
			view.addObject("StudList", list);
		} catch (Exception e) {
			System.out.print("error");
		}
		return view;
	}

	@RequestMapping("register")
	public ModelAndView reg(@ModelAttribute Student student) throws ClassNotFoundException, SQLException {
//		String name=(String) student.getAttribute("name");
//		String contact=(String)student.getAttribute("contact");
//		String email=(String) student.getAttribute("email");
//		String password= (String) student.getAttribute("password");
//		Student student2=new Student(name,contact,email,password);
		ModelAndView view = new ModelAndView();
		if (dao.register(student)) {
			view.addObject("success", "Registered Successfull ");
			view.setViewName("login");
		} else {
			System.out.print(student.getContact());
		}
		return view;
	}

	@RequestMapping("login")
	public ModelAndView login(@ModelAttribute Student student) throws ClassNotFoundException, SQLException {
		ModelAndView view = new ModelAndView();
		Student student2 = new Student();
		student2.setName(student.getName());
		student2.setPassword(student.getPassword());
		String name = student2.getName();
		String pass = student2.getPassword();
		if (dao.loginCheck(name, pass)) {
			Student ss = dao.stu();
			view.addObject("student", ss);
			view.setViewName("table");
		} else {
			if (name != null && pass != null) {
				if (name.equals("admin") && pass.equals("admin")) {
					List<Student> ss = dao.loginCheckAdmin();
					view.addObject("students", ss);
					view.setViewName("admin");
				} else {
					System.err.println("Enter Valid Credentials");
				}
			}
		}
		return view;
	}

	@RequestMapping("edit")
	public ModelAndView edit() {
		ModelAndView view = new ModelAndView();
		view.setViewName("edit");
		return view;
	}
	@RequestMapping("update")
	public ModelAndView update(@ModelAttribute Student student) throws ClassNotFoundException, SQLException {
		ModelAndView view = new ModelAndView();
		Student s = new Student();
		s.setName(student.getName());
		s.setContact(student.getContact());
		s.setEmail(student.getEmail());
		s.setPassword(student.getPassword());
		String msg = dao.upadtestudent(s);
		view.addObject("msg", msg);
		view.setViewName("register");
		return view;
	}

	@RequestMapping("delete")
	public ModelAndView delete() throws ClassNotFoundException, SQLException {
		ModelAndView view = new ModelAndView();
		if (dao.delete()) {
			view.addObject("delete", "your credentials deleted");
		} else {
			System.err.println("can not delete");
		}
		view.setViewName("register");
		return view;
	}
}
