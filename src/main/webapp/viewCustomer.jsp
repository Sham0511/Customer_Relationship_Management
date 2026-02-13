<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Customer Record</title>
</head>
<body>
<form action="MainServlet"mathod ="post">
<input type="hidden" name="operation" value="viewRecord"/>
Name:<input type="text" name="customerName"/> <br><br>
Join Date (yyyy-mm-dd): <input type="text" name="joinDate" /> <br><br>
<input type="submit" value="View"/>
</form>
</body>
</html>