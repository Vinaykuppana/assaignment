<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Form</title>
</head>
<body style="background-color:orange ;">
<fieldset>
<legend>Login To Enter</legend>
<form action="./welcome" method="post">
<table>
<tr>
<td>
<label>enter your user id</label>
</td>
<td>
<input type="number" name="id">
</td>
</tr>
<tr>
<td>
<label>enter your password</label>
</td>
<td>
<input type="password" name="password">
</td>
</tr>
</table>
<input type="submit" value="submit">
</form>
</fieldset>
</body>
</html>