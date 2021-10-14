<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style><%@include file="/WEB-INF/css/style.css"%></style>
</head>
<body>
<% 
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");	
		if(session.getAttribute("username")==null)
			response.sendRedirect("login.jsp");
	%>
<div class="container">	
	<div class="row">
                    <form action="CrudUser" method="post">
                    <label>Add User</label>
                      <div class="form-group">
                        <input type="text" class="form-control"  placeholder="Enter User FullName" name="username">
                      </div>
                      <div class="form-group">
                        <input type="text" class="form-control"  placeholder="Enter User Login name" name="userLoginName">
                      </div>
                      <div class="form-group">
                        <input type="text" class="form-control"  placeholder="Enter User Email" name="userEmail">
                      </div>
                      <div class="form-group">
                        <input type="text" class="form-control"  placeholder="Enter Password" name="userPassword">
                      </div>
                      <div class="form-check">
                        <button type="submit" class="btn btn-primary" name="submit" value="adduser">Submit</button>
                      </div>
                    </form>
		</div>
		<div class="row">
                    <form action="CrudUser" method="post">
                    <label>Edit User</label>
                    <div class="form-group">
						<input type="text" class="form-control" placeholder="Enter user login name" name="userLoginName">
					</div>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Enter updated username" name="username">
					</div>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Enter updated email" name="userEmail">
					</div>
                      <div class="form-check">
                        <button type="submit" class="btn btn-primary" name="submit" value="updateuser">Update</button>
                      </div>
                    </form>
		</div>
		<div class="row">
                    <form action="CrudUser" method="post">
                    <label>Delete User</label>
                      <div class="form-group">
                        <input type="text" class="form-control" placeholder="Enter user login name" name="userLoginName">
                      </div>
                      <div class="form-check">
                        <button type="submit" class="btn btn-primary" name="submit" value="deleteuser">Delete</button>
                      </div>
                    </form>
		</div>
	</div>
<form class="form-group" action="Logout" method="get">
			<input type="submit" value="Logout" class="form-control btn btn-success " name="">
		</form>
</body>
</html>