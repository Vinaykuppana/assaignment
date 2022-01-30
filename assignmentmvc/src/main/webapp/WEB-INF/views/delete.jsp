<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%String msg= (String)request.getAttribute("msg"); %>
     <%String err= (String)request.getAttribute("err"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>delete products</title>
</head>
<body>
  <%
			if (msg != null && !msg.isEmpty()) {
			%>
			<h4 style="color: green"><%=msg%></h4>
			<%
			}
			%>
		
<fieldset>
<legend>delete product form</legend>
<form action="./delete">
<label>enter the product id that to be deleted</label>
 <input type="number"name="id" />
 <input type="submit" value="delete data"/>
</form>
</fieldset>
</body>
</html>