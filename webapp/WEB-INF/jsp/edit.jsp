<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Details Form</title>
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
	background: blue;
	font-size: 1em;
	font-weight: bold;
	margin-top: 20px;
	border-radius: 5px;
	transition: .2s;
	cursor: pointer;
}</style>
</head>
<body>
<h2>Edit Your Details</h2>>
<div class="main">  	
				<form action="update">
					<input type="text" name="name" placeholder="User name" required="">
					<input type="number" name="contact" placeholder="Contact Number" required="">
					<input type="email" name="email" placeholder="Email" required="">
					<input type="password" name="password" placeholder="Password" required="">
					<button type="submit" name=submit>Update</button>
				</form>
			</div>
</body>
</html>