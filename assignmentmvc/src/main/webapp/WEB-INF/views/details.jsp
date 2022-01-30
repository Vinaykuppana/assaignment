<%@page import="com.te.assignmentmvc.base.dto.ProductDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%String msg=(String)request.getAttribute("err"); %>
    <%ProductDetails details=(ProductDetails)request.getAttribute("data"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%if(msg!=null && !msg.isEmpty()){ %>
<%=msg %>
<%} %>
<form action="./details" method="post">
<label>enter the id to get product details</label>
<input type="number" name="id">
<input type="submit" value="get data">

<%if(details != null) {%>
<h2>your product id is:</h2><%details.getId(); %>
<h2>your product name is:</h2><%details.getName(); %>
<h2>your product brand is:</h2><%details.getCompany(); %>
<h2> product price is is:</h2><%details.getPrice(); %>
<%}%>

</form>

</body>
</html>