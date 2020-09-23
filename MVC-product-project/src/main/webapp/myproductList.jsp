 <%@page import="com.spring.mvc.products.entity.Products"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<!DOCTYPE html>
<html>
   <head>
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <link rel="stylesheet"
         href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
      <script
         src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
      <script
         src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
      <script
         src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
      <meta charset="ISO-8859-1">
      <title>Insert title here</title>
      <style type="text/css">
      .table table-bordered{
      color:white;
      border-color: white;
      }
      
      #text{
      color:white;
      }
      </style>
      
   </head>
   <body background="img/data1.jpg">
      <div class="container" style="width: 90%">
         <h1 id="text"> PRODUCTS LIST</h1>
         <hr>
         <div >
            <table  class="table table-bordered">
            <span style="color:red">${deletemessage}</span>
             
               <thead>
                  <tr id="text">
                     <th>ID</th>
                     <th>Name</th>
                     <th>BRAND</th>
                     <th>DOE</th>
                     <th>PHOTO</th>
                     <th>ACTION</th>
                  </tr>
               </thead>
               <tbody>
                  <%
                     List<Products> theProductsList =(List<Products>)request.getAttribute("products");
                     
                     for(Products myProducts:theProductsList){
                     	
                     %>
                  <tr id="text">
                     <td><%=myProducts.getId() %></td>
                     <td><%=myProducts.getName() %></td>
                     <td><%=myProducts.getBrand() %></td>
                     <td><%=myProducts.getDoe() %></td>
                      
                        <td>
                        <img alt="No image" src="loadphoto?dbid=<%=myProducts.getId()%>" style="height: 120px;">
                        
                        </td>
                      
                      
                     <td > 
                     
                        <a href="removeProduct?name=<%=myProducts.getName() %>" >
                        <img alt="there is no img" src="img/delete.png" style="height: 40px"  > 
                        
                         <button type="button" class="btn btn-danger">delete</button>
                        </a>
                        
                          <a href="updateProduct?did=<%=myProducts.getId()%>" >
                        <img alt="there is no img" src="img/edit.png" style="height: 40px"> 
                        <button type="button" class="btn btn-primary">update</button>
                        </a>
                        
                         
                     </td>
                  </tr>
                  
                  <% } %>
               </tbody>
            </table>
         </div>
         <a id="text" href="${pageContext.request.contextPath}/addproductScreen.jsp">
         <button type="button" class="btn btn-primary" >Back to add product</button>
         </a>
         
         <a id="text" href="${pageContext.request.contextPath}/signInScreen.jsp">
         <button type="button" class="btn btn-danger" >Log Out</button>
         </a>
      </div>
   </body>
</html>