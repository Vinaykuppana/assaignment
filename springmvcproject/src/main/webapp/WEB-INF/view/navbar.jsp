<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>nav bar</title>
<style>
.nav-item{
margin-right:50px;
letter-spacing:0.5px;
}

nav{
background-color:lightblue;
}



</style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light nav ">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse nav2" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link disable" aria-current="page" href="#">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="./getdata">getdata</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="./delete details ">deletedata</a>
        </li>
        <li class="nav-item">
          <a class="nav-link " href="./logout">logout</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
</body>
</html>