<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<html>
   <head>
      <title>Products Page</title>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <link rel="stylesheet"
         href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
      <script
         src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
      <script
         src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
   </head>
   <body background="img/uni.jpg">
      <div class="container" style="width: 30%">
         <h3 style="color: Red">Save your product below</h3>
         <hr>
         <span style="color: yellow">${successMessage}</span>
         <form action="saveData" method="post">
            <div class="form-group">
               <label style="color: white" for="name">name</label> <input
                  type="text" class="form-control"
                  placeholder="enter your product name" name="name">
            </div>
            <div class="form-group">
               <label style="color: white" for="name">brand</label> <input
                  type="text" class="form-control"
                  placeholder="enter your product brand" name="brand">
            </div>
            <button type="submit" class="btn btn-primary">Add</button>
           
            <a href="getData" style="color: red"> 
            	<button type="button" class="btn btn-success"> show products list</button>
            </a>
            
            <a id="text" href="${pageContext.request.contextPath}/signInScreen.jsp">
         		<button type="button" class="btn btn-danger" >Log Out</button>
         	</a>
            <hr>
           
            <br>
          


         </form>
      </div>
   </body>
</html>