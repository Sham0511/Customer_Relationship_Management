<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.wipro.crm.bean.CrmBean" %>

<html>
<body>

<%
String message = (String) request.getAttribute("message");
List<CrmBean> list = (List<CrmBean>) request.getAttribute("records");

if (message != null) {
%>
    <h3><%= message %></h3>
<%
} else if (list != null) {
%>
    <h3>All Customers</h3>
    <table border="1">
        <tr>
            <th>ID</th><th>Name</th><th>Email</th>
            <th>Phone</th><th>Join Date</th>
            <th>Status</th><th>Remarks</th>
        </tr>
<%
        for (CrmBean b : list) {
%>
        <tr>
            <td><%= b.getRecordId() %></td>
            <td><%= b.getCustomerName() %></td>
            <td><%= b.getEmail() %></td>
            <td><%= b.getPhone() %></td>
            <td><%= b.getJoinDate() %></td>
            <td><%= b.getStatus() %></td>
            <td><%= b.getRemarks() %></td>
        </tr>
<%
        }
%>
    </table>
<%
}
%>

<br><a href="menu.html">Back to Menu</a>

</body>
</html>
