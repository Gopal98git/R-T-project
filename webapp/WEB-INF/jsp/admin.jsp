<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.RabbitTortoise.project.entity.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Page</title>
<style>
h1{
justify-content: center;
text-align: center;
}
#customers {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 60%;
  margin-left:10rem;
  justify-content: center;
  text-align: center;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: center;
  background-color: gray;
  color: white;
}
button{
	width: 100%;
	height: 40px;
	margin: 10px auto;
	display: block;
	color: aqua;
	background: green;
	font-size: 1.1em;
	font-weight: bold;
	margin-top: 20px;
	border-radius: 5px;
	transition: .2s;
	cursor: pointer;
}
#delete{
	width: 100%;
	height: 40px;
	margin: 10px auto;
	display: block;
	color: black;
	background: red;
	font-size: 1.1em;
	font-weight: bold;
	margin-top: 20px;
	border-radius: 5px;
	transition: .2s;
	cursor: pointer;
}
</style>
</head>
<body>
<% List<Student>list=(List<Student>) request.getAttribute("students"); %>
<form action="edit">

<h1>Admin Panel</h1>

<table id="customers">
  <tr>
  <th>Student Id</th>
    <th>Name</th>
    <th>Contact</th>
    <th>Email Id</th>
    <th>password</th>
    <th>Action</th>
  </tr><c:forEach items="${students}" var="ss">
  <tr>
  <td>${ss.id}</td>
   <td>${ss.name}</td>
    <td>${ss.contact}</td>
    <td>${ss.email}</td>
    <td>${ss.password}</td>
    <td><button type="submit" name="submit" value="submit">Edit</button>
    </form>
    <form action="delete">
    <button type="submit" name="delete" id="delete">Delete</button>
    </form></td> </tr></c:forEach>
  </table>
</body>
</html>