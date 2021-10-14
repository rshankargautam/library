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
<div class="login-box" >
	<div class="login-header">Login</div>
	<div class="login-body">
		<form class="form-group" action="Login" method="post">
			<label>Username</label>
			<input type="text" class="form-control" name="uname">
			<label>Password</label>
			<input type="password" class="form-control" name="pass" style="margin-bottom:20px;">
			<input type="submit" value="Login" class="form-control btn btn-success " name="">
		</form>
		<a href="Guest.jsp">Login as Guest</a>
	</div>
</div>
</body>
</html>