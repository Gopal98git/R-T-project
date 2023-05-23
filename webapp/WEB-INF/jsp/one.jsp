<%@page import="com.RabbitTortoise.project.entity.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="ok">
<input type="email" name="email" placeholder="Enter Email">
hello browser
<button type="submit" name="submit">Submit</button>
</form><% List<Student> list=(List<Student>)request.getAttribute("StudList"); %>
<% out.print(request.getAttribute("StudList")); %>
<table>
  <tr>
    <th>Name</th>
    <th>Contact</th>
    <th>Email</th>
    <th>Password</th>
  </tr>
<% for(Student l: list){ %>
  <tr>
    <td><%out.print(l.getName()); %></td>
    <td><%out.print(l.getContact()); %></td>
    <td><%out.print(l.getEmail()); %></td>
    <td><%out.print(l.getPassword()); %></td>
  </tr>
  <% } %>
</table>

hello
</body>
</html>