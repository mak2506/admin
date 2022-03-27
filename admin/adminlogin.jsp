<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:lightgreen">
<div style="width:30%;height:400px;background-color: seagreen;margin-top: 100px;margin-left: 350px;border-radius:20px">
<a href="/buko" style="text-decoration:none;"><h1 style="text-decoration:none;color:#F9A825;font-size:10vh;font-family:forte;text-shadow:2px 2px #784212;text-align:center">Buko</h1></a>
<h1 style="text-align: center;color:#F9A825;font-size:7vh">Login</h1>
<form method="post" action="/buko/AdminLogin" onsubmit=" return check()">

<table  style="text-align:center; width:20%;height:200px;border-radius:15px;margin-left:50px">
<tbody style="font-family:forte;font-size:150%" >
<tr>
     <th><label>userid</label></th>
     <th><input type="text" id="userid" name="id" style="width:150px;height:35px;border-radius:15px"></th>
     
</tr>
<tr>
     <th><label>password</label></th>
     <th><input type="password" id="password" name="password" style="width:150px;height:35px;border-radius:10px"></th>
      
</tr>
<tr>
     <th colspan="2"><button type="submit" style="width:100px;height:40px;border-radius:8px">login</button></th>
</tr>
</tbody>
</table>
</form>
</div>

</body>
</html>