<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="registerTest">
Register test<br>
Subject <input type="text" name ="subject">
Date <input type ="date" name ="date">
<input type ="submit">
</form><br>

<br>

<form action="getIndi">
Get Individual Test info<br>
Test Id <input type="text" name ="testId"><br>
<input type ="submit">
</form> 

<br>
<br>

<form action="getAll">
Get Information of All test
<input type ="submit">
</form>

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