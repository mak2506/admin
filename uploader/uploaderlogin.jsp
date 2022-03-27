<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Buko Login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body style="background-color:#E9A715">

<%
String msg=(String)request.getAttribute("message");
%>

<div style="width:40%;height:300px;background-color: green;margin-top: 150px;margin-left: 300px;border-radius:20px">

<h1 style="text-align: center;color:#F9A825;font-size:10vh;margin-top:50px">Login</h1>
<form method="post"  action="/buko/UploaderLogin">

<table  style="text-align:center; width:15%;height:200px;border-radius:15px;margin-left:50px">
<tbody style="font-family:forte;font-size:150%" >
<tr>
     <th><label>User Email</label></th>
     <th><input type="email" id="email" name="email" style="width:240px;height:35px;border-radius:15px" required></th>     
</tr>
<tr>
     <th><label>password</label></th>
     <th><input type="password" id="password" name="password" style="width:240px;height:35px;border-radius:10px" required></th>
      
</tr>
<tr>
	     <th colspan="2"><button type="submit" style="width:120px;height:40px;border-radius:8px">Login</button></th>
     			
</tr>
</tbody>
</table>
<%if(msg!=null){ %>
			<div class="alert alert-danger alert-dismissible fade show" role="alert">
  <strong>Login Error!</strong> <%=msg %>
  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
</div>
<%} %>
</form>
	
		<div class="mt-4 text-center">
		 <p>Have no account? <a href="uploaderregisteration.jsp"  class="btn btn-light">Register Here</a></p>
		</div>

</div>

 <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>

</body>
</html>
