<%@page import="com.springmvcproject.base.dto.MyEmployeeDetails"%>
<%@page import="org.springframework.security.core.userdetails.UserDetails"%>
<%@page import="com.springmvcproject.base.dto.EmployeeDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="./navbar.jsp" %>
    <%UserDetails details=(UserDetails)request.getAttribute("key"); %>
    <%String err=(String)request.getAttribute("err"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>welcome user</title>
<style>
body{
background-repeat:no-repeat;
background-size:cover;
background-image:url(https://images.unsplash.com/photo-1540800458874-73e6a5eed8ac?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=871&q=80);
}
h1{
text-align:center;
margin-top:50px;
color:white;
}
</style>
</head>
<body>
<%if(err != null && !err.isEmpty()){ %>
<h1 style="color: red;"></h1>
<%=err %>
<%} %>
<h1 >WELCOME USER TO HOME PAGE</h1>
</body>
</html>