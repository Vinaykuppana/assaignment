<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ include file="./navbar.jsp" %>
    <%String msg =(String) request.getAttribute("msg");%>
    <%String err =(String) request.getAttribute("err");%>
    <%int details=(int)request.getAttribute("data"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
			if (msg != null && !msg.isEmpty()) {
			%>
			<h4 style="color: green"><%=msg%></h4>
			<%
			}
			%>
			<%
			if (err != null && !err.isEmpty()) {
			%>
			<h4 style="color: red"><%=err%></h4>
			<%
			}
			%>
<fieldset>
<legend>update data form</legend>
<form action="./update" method="post">
<table>
<tr>
<td>
<label>your id is</label>
</td>
<td>
<input type="number" name="id" value=<%=details %> disabled="disabled"> 
</td>
<td>
<tr>
<td>
<label>enter the product name to update</label>
</td>
<td>
<input type="text" name="name">
</td>
</tr>
<tr>
<td>
<label>enter the product company</label>
</td>
<td>
<input type="text" name="company">
</td>
</tr>
<tr>
<td>
<label>enter the price to update</label>
</td>
<td>
<input type="number" name="price">
</td>
</tr>
</table>
<input type="submit" value="update">
</form>
</fieldset>
</body>
</html>