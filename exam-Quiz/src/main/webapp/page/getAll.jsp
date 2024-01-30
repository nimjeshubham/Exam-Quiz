<%@page import="com.school.pack.Model.Test"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% List<Test> list =(List<Test>) request.getAttribute("list"); %>
<table border="1">
<thead><td> Test ID </td><td> Subject </td> <td> Date </td>  </thead>
<%for (Test test: list){ %>

<tr><td><%=test.getTestId()%> </td>  <td><%=test.getSubject() %> </td> <td><%= test.getDate()%> </td>  </tr>


<%} %>
</table>

<br>
<br>

<form action="update">
Update Test <br>
Test Id<input type="Text"  name="testId"><br>
Subject <input type ="text" name ="subject">
Date <input type="date" name ="date">
<input type = "submit" value ="Update">
</form>

<br>
<br>
<form action="delete">
Delete Test <br>
<input type="Text" name="testId"><br>
<input type = "submit" value ="Delete">
</form>
</body>
</html>