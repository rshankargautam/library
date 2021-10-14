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
<% 
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");	
		if(session.getAttribute("username")==null)
			response.sendRedirect("login.jsp");
	%>
<body>
	<div class="row">
                    <form action="LoanBook" method="post">
                    <label>Loan Book</label>
                      <div class="form-group">
                        <input type="text" class="form-control"  placeholder="Enter Book Title" name="bookTitle">
                      </div>
                      <div class="form-group">
                        <input type="text" class="form-control"  placeholder="Enter User login name" name="userLoginName">
                      </div>
                      <div class="form-check">
                        <button type="submit" class="btn btn-primary" name="submit" value="issuebook">Issue Book</button>
                      </div>
                    </form>
		</div>
		<div class="row">
                    <form action="LoanBook" method="post">
                    <label>Return Book</label>
                    <div class="form-group">
						<input type="text" class="form-control" placeholder="Enter User login name" name="userLoginName">
					</div>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Enter book Title" name="bookTitle">
					</div>
                      <div class="form-check">
                        <button type="submit" class="btn btn-primary" name="submit" value="returnbook">Return Book</button>
                      </div>
                    </form>
		</div>
		
		<form class="form-group" action="Logout" method="get">
			<input type="submit" value="Logout" class="form-control btn btn-success " name="">
		</form>
</body>
</html>