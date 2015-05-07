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
		<h2>Home</h2>
		<p>This is under construction. Timesheet with different formats
			can converted from PDF to your desired format</p>
		<br /> <br />
		<!-- 		<form action="DisplayFile"> -->
		<!-- 			<h4>Please enter a path to display all the PDF files</h4> -->
		<!-- 			<br /> <input type="text" name="sourceDir" size="30px"> <input -->
		<!-- 				type="submit" value="submit"> -->
		<!-- 		</form> -->
		<%
			String companyName = request.getParameter("Company");
		    String outputFileName = request.getParameter("outputFile");
			System.out.println("......" + outputFileName);
			session.setAttribute("CompanyName", companyName);
			session.setAttribute("outputFile", outputFileName);
			
		%>
		<h3>File Upload:</h3>
		<br />
		<form action="UploadServlet" method="post"
			enctype="multipart/form-data">

			<br /> <input type="file" name="file" size="50" /> <br /> <br />
			<input type="submit" value="Upload File" />

		</form>

	</div>
	<br /> <br /> <br /> <br />
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