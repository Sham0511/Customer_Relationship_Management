<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Customer</title>
</head>
<body>
<h2>Add customer record</h2>
<form action="MainServlet"method="post">
<input type="hidden" name="operation" value="newRecord"/>
Name:<input type="text" name="customerName"/><br><br>
Email:<input type="text" name="email"/><br><br>
Phone:<input type="text" name="phone"/><br><br>
Join Date(yyyy-mm-dd):<input type="text" name="joinDate"/><br><br>
Status :<input type="text" name="status"/><br><br>
Remarks :<input type="text" name="remarks"/> <br><br>
<input type="submit" value="Add"/>
</form>
</body>
</html>