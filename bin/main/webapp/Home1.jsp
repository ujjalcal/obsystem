<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TS Management</title>
<meta name="author" content="your name" />
<meta name="description" content="" />
<link rel="css/stylesheet" href="style.css" type="text/css" />


<style type="text/css">
  body {
    padding-left: 11em;
    font-family: Georgia, "Times New Roman",
          Times, serif;
    color: purple;
    background-color: #da8e3d }
  ul.navbar {
    list-style-type: none;
    padding: 0;
    margin: 0;
    position: absolute;
    top: 2em;
    left: 1em;
    width: 9em }
  h1 {
    font-family: Helvetica, Geneva, Arial,
          SunSans-Regular, sans-serif }
  ul.navbar li {
    background: white;
    margin: 0.5em 0;
    padding: 0.3em;
    border-right: 1em solid black }
  ul.navbar a {
    text-decoration: none }
  a:link {
    color: blue }
  a:visited {
    color: purple }
  </style>
  
  
</head>
<body bgcolor="cadetBlue">




	<div id="page">
		<div id="logo">
			<h1>
				<a href="/" id="logoLink">TimeSheet Management Website</a>
			</h1>
		</div>
		<div id="nav">
			<ul>
				<li><a href="#/home.html">Home</a></li>
				<li><a href="#/about.html">About</a></li>
				<li><a href="#/contact.html">Contact</a></li>
			</ul>
		</div>
		<div id="content">
			<h2>Home</h2>
			<p>This is under construction. Through Timesheet can converted
				from PDF to your desired format</p>

		</div>



		<form action="DisplayFile">
			<h4>Please enter a path to display all the PDF files</h4>
			<br /> <input type="text" name="sourceDir" size="30px"> <input
				type="submit" value="submit">
		</form>
		<h3>File Upload:</h3>
		<br /> <br />
		<form action="UploadServlet" method="post"
			enctype="multipart/form-data">
			<input type="file" name="file" size="50" /> <br /> <br /> <input
				type="submit" value="Upload File" />
		</form>
<br/><br/><br/><br/>
		<div id="footer">
			<p>
				Webpage made by <a href="/" target="_blank">[your name]</a>
			</p>
		</div>
	</div>
</body>
</html>