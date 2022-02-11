<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>

body{
background-repeat:no-repeat;
background-size:cover;
background-image:url(https://media.istockphoto.com/photos/abstract-defocused-blue-soft-background-picture-id937026088?b=1&k=20&m=937026088&s=170667a&w=0&h=hvijBNYiaVPRELtNZmVryg-20BROtPkhGKQBBN0z58o=)
}
.loginForm{
background-color:white;
margin:100px 400px 0px 400px;
 border:solid 2px black;
 padding:30px
}
form{

padding:10px
}

h1{
color:white;
text-align:center
}


input[type=submit]{
font-size:15px;
padding:8px;
letter-spacing:1px;
border-radius:5px;
}

input[type=submit]:hover{
  background-color:rgba(245, 41, 41, 0.8);
  border:none;
  transition:0.5s;
  color:white;
}

label{
font-size:24px
}
</style>


<title>Insert title here</title>
</head>
<body >
<h1>EMPLOYEE LOGIN PAGE</h1>
<div class="loginForm">
<form action="./userlogin" >
<label>click here to login as user</label>
<input type="submit" value="login as user">
</form>
<br>
<br>
<form action="./adminlogin" >
<label>click here to login as Admin</label>
<input type="submit"  value="login as admin">
</form>
</div>
</div>
</body>
</html>