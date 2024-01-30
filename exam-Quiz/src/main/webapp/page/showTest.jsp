<%@page import="com.school.pack.Model.Test"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Test preview</h1>

<% Test test = (Test)request.getAttribute("test");%>
<p>
 Test ID :<%=test.getTestId() %><br>
 Test subject : <%= test.getSubject() %><br>
 Test Date: <%=test.getDate() %>

</p>
<form action="update">
Update Test <br>
Test Id<input type="Text" placeholder=<%=test.getTestId() %> name="testId"><br>
Subject <input type ="text" name ="subject">
Date <input type="date" name ="date">
<input type = "submit" value ="Update">
</form>

<br>
<br>
<form action="delete">
Delete Test <br>
<input type="Text" placeholder=<%=test.getTestId() %> name="testId"><br>
<input type = "submit" value ="Delete">
</form>

</body>
</html>