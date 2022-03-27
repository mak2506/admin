<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*, buko.dbtask.*"%>
  <!doctype html>
  <html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    <title>Dashboard</title>
      <!-- Bootstrap core CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
   

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>


    <!-- Custom styles for this template -->
    <link href="dashboard.css" rel="stylesheet">
  </head>

  <body>
  <%
String aid=(String)session.getAttribute("admin");

if(aid==null || session.isNew())
{
	request.setAttribute("message", "Unauthorized Access");
	RequestDispatcher rd=request.getRequestDispatcher("/Admin");
	rd.forward(request, response);
}
else{
	%>

	<jsp:include page="components/header.jsp"></jsp:include>
	<jsp:include page="components/navbar.jsp"></jsp:include>
    <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
      <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h1 class="h2">Dashboard</h1>
        <div class="btn-toolbar mb-2 mb-md-0">
          <div class="btn-group me-2">
            <button type="button" class="btn btn-sm btn-outline-secondary">Share</button>
            <button type="button" class="btn btn-sm btn-outline-secondary">Export</button>
          </div>
          <button type="button" class="btn btn-sm btn-outline-secondary dropdown-toggle">
            <span data-feather="calendar"></span>
            This week
          </button>
        </div>
      </div>

      <h2 id="title">Users</h2>
      <div class="table-responsive" id="section">
        <table class='table table-striped table-sm'>
              <thead>
                <tr>
                  <th scope='col'>User ID</th>
                  <th scope='col'>User Name</th>
                  <th scope='col'>Full Name</th>
                  <th scope='col'>Registeration Date</th>
                  <th scope='col'>Status</th>
                  <th></th>
                  <th></th>
                </tr>
              </thead>
              <tbody>      
            <?php
            foreach ($newCustomers as $customer) {
                ?>
                  <tr>
                    <td><?php echo $customer["user_id"]; ?></td>
                    <td><?php echo $customer["username"]; ?></td>
                    <td><?php echo $customer["fullname"]; ?></td>
                    <td><?php echo $customer["reg_date"]; ?></td>
                    <td><?php echo $customer["status"]; ?></td>
                  </tr>
                <?php 
            }
            ?>
              </tbody>
        </table>
      </div>
    </main>
    </div>
    </div>
<%} %>

   <!-- Latest compiled JavaScript -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <!-- <script src="./assets/js/script.js"></script> -->
  </body>

  </html>
 

