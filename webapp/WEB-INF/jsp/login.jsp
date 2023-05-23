<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Form</title>
<style>
input{
	width: 50%;
	height: 20px;
	justify-content: center;
	display: flex;
	margin: 20px auto;
	padding: 10px;
	border: .5px solid black;
	border-radius: 5px;
}
h2{
justify-content: center;
text-align: center;
margin-top:3em;
font-family: serif;
}
button{
	width: 50%;
	height: 40px;
	margin: 10px auto;
	justify-content: center;
	display: block;
	color: aqua;
	background: green;
	font-size: 1em;
	font-weight: bold;
	margin-top: 20px;
	border-radius: 5px;
	transition: .2s;
	cursor: pointer;
}</style>
</head>
<body><% if(request.getAttribute("success")!=null){out.print(request.getAttribute("success"));} %>
<h2>LoginForm</h2>
<form action="login">
<input type="text" name="name" placeholder="Enter name">
<input type="password" name="password" placeholder="Enter password">
<button type="submit" name="submit">Submit</button>
</form>
</body>
</html>