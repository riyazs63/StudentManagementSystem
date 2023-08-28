<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.ArrayList" %>
    <%@page import="com.um.model.User" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="a"%>
    <!-- Now iam writing all java codes inside tags with taglib so for that purpose u have to give prefix called "a" here -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>STUDENT MANAGEMENT SYSTEM</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>

<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">STUDENT MANAGEMENT SYSTEM</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="<%=request.getContextPath()%>/list">Users</a>
            </li>
           </ul>
          </div>
         </div>
        </nav>
        
        
<h1 style="color:blue" align="center">STUDENT MANAGEMENT SYSTEM</h1>
<!-- iam using a class container because everything should come in the screen properly --> 
<div class="container">
<hr></hr>
<a href="<%=request.getContextPath()%>/add" class="btn btn-success">ADD STUDENT</a>
 <table class="table table-striped">
 <thead>
 <th>ID</th>
 <th>NAME</th>
 <th>EMAIL</th>
 <th>CITY</th>
 <th>ACTIONS</th>
 
 </thead>
 <tbody>
 
 <a:forEach items="${display }" var="u">
 <tr>
 <td><a:out value="${u.id }"></a:out></td>
 <td><a:out value="${u.name }"></a:out></td>
 <td><a:out value="${u.email }"></a:out></td>
 <td><a:out value="${u.city }"></a:out></td>
 <td><a href="edit?id=<a:out value="${u.id }"></a:out>">EDIT</a>&nbsp;&nbsp;<a href="delete?id=<a:out value="${u.id }"></a:out>">DELETE</a></td>
 
 
 
 </a:forEach>
</tr>
</tbody>
 
 
 </table>
 <br><br>
 </div>
</body>
</html>