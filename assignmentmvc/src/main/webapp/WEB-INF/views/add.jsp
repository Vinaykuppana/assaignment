<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include  file="./navbar.jsp" %>
    <%String msg= (String)request.getAttribute("msg"); %>
    <%String err= (String)request.getAttribute("err"); %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>add to publish</title>
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
<legend>add your  product to publish</legend>
<form action="./add" method="post">
<table>
<tr>
<td>
<label>enter the product id</label>
</td>
<td>
<input type="number" name="id">
</td>
</tr>

<tr>
<td>
<label>enter the name of the product:</label>
</td>
<td>
<input type="text" name="name">
</td>
</tr>
<tr>
<td>
<label>enter the brand of the product:</label>
</td>
<td>
<input type="text" name="company">
</td>
</tr>
<tr>
<td>
<label>enter the price of the product:</label>
</td>
<td>
<input type="number" name="price">
</td>
</tr>
</table>
<input type="submit" value="add to publish">
</form>
</fieldset>
</body>
</html>