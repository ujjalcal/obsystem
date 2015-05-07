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
		<h2>Select Company</h2>
		<p>This is under construction. Timesheet with different formats
			can converted from PDF to your desired format</p>
		<br /> <br />
		<%@ page import="java.util.List"%>

		<%!private static class Company {
		private int companyId;
		private String CompanyName;

		public Company(int id, String name) {
			this.companyId = id;
			this.CompanyName = name;
		}

		public String getCompanyName() {
			return CompanyName;
		}

		public int getId() {
			return companyId;
		}
	}%>
		<%
			ArrayList<String> companyList = new ArrayList();
			companyList.add("ESystems 1");
			companyList.add("ESystems 2");
		%>
		<!-- 		<form action="DisplayFile"> -->
		<!-- 			<h4>Please enter a path to display all the PDF files</h4> -->
		<!-- 			<br /> <input type="text" name="sourceDir" size="30px"> <input -->
		<!-- 				type="submit" value="submit"> -->
		<!-- 		</form> -->
		<form action="Home.jsp">
			<h3>Select a Company from the ist</h3>
			Company Name: <select name="Company">
				<option value="" selected>Select a Company from the list </option>
				<%
					String CompanyName = "";
					for (int i = 0; i < companyList.size(); i++) {
						CompanyName = companyList.get(i).toString();
				%>
				<option value="<%=CompanyName%>"><%=CompanyName%></option>
				<%
					}
				%>
			</select>
<br/>
<p></p>
				OutPut File Name: <input type="text" name="outputFile" size="30px"> 
<p></p>
				<input type="submit" value="Go" name="btn_dropdown" size="20px">
		</form>
	</div>
	<br />
	<br />
	<br />
	<br />
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