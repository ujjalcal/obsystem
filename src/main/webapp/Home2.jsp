<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TS Management</title>
<meta name="author" content="your name" />
<meta name="description" content="" />
<link rel="stylesheet" href="css/style7.css" type="text/css" />
</head>
<body bgcolor="cadetBlue">
<html>




<div id="container">
	<div id="header">
		<h1>
			<a href="/" id="logoLink"><p align="center">
					<font color="white">TimeSheet Management Website</font>
				</p></a>
		</h1>
	</div>
	<div id="sidebar">
		<ul>
			<li><a href="/hello/"><font color="white">Home</font></a></li>
			<li><a href="#/about.html"><font color="white">About</font></a></li>
			<li><a href="#/contact.html"><font color="white">Contact
						Us</font></a></li>
		</ul>
	</div>
	<div id="content">
		<h2>Extracted TimeSheet</h2>
		<br />
		<%
			String output = (String) request.getAttribute("Output");
		%>
		<h3><%=output%></h3>

	</div>

	<div id="footer">
		<h3>
			<p align="center">
				<font color="white">Webpage made by</font>
			</p>
		</h3>
		<a href="/" target="_blank"><p align="center">
				<font color="white">ABC Inc.</font>
			</p></a>
		</p>
	</div>
</div>
</body>
</html>