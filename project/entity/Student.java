package com.RabbitTortoise.project.entity;


public class Student {
private int id;
private String name;
private String contact;
private String email;
private String password;

public Student() {
	super();
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getContact() {
	return contact;
}
public void setContact(String contact) {
	this.contact = contact;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "Student [ID="+id + "name=" + name + ", Contact=" + contact + ", email=" + email + ", password=" + password + "]";
}
public Student(int id,String name, String contact, String email, String password) {
	super();
	this.id=id;
	this.name = name;
	this.contact = contact;
	this.email = email;
	this.password = password;
}

}
