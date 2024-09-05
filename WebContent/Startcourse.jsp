<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
 body {background-color : lightpink;}
</style>
<body>
<center>
<%!String str=null;%>
<form action="Startcoursecontroller">

<table>

<tr>
<td>Course name</td>
<td><input type="text" name="cname"></td>
</tr>

</table>
</form>
<div>
<%
   str=(String)session.getAttribute("msg");
   session.invalidate();
%>

<h1><%=str %></h1>
<a href="Home.html">Home</a>
<a href="Firstscreen.html">back</a>
</div>
</center>


</body>
</html>