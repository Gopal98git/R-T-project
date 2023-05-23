<%@page import="com.RabbitTortoise.project.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your Details Table</title>
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

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: center;
  background-color: gray;
  color: white;
}
button{
	width: 10%;
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
	width: 10%;
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
<% Student s=(Student)request.getAttribute("student"); %>
<form action="edit">

<h1>Your Details</h1>

<table id="customers">
  <tr>
  <th>Student Id</th>
    <th>Name</th>
    <th>Contact</th>
    <th>Email Id</th>
    <th>password</th>
  </tr>
  <tr>
  <td><%out.print(session.getAttribute("id")); %></td>
   <td><%out.print(s.getName());%></td>
    <td><%out.print(s.getContact()); %></td>
    <td><%out.print(s.getEmail()); %></td>
    <td><%out.print(s.getPassword()); %></td>
  </tr></table>
  <button type="submit" name="submit" value="submit">Edit</button>
    </form>
    <form action="delete">
    <button type="submit" name="delete" id="delete">Delete</button>
    </form>
</body>
</html>