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
                    <form action="CrudBook" method="post">
                    <label>Add Book</label>
                      <div class="form-group">
                        <input type="text" class="form-control"  placeholder="Enter Book Title" name="bookTitle">
                      </div>
                      <div class="form-group">
                        <input type="text" class="form-control"  placeholder="Enter Published Year" name="pubYear">
                      </div>
                      <div class="form-group">
                        <input type="text" class="form-control"  placeholder="Enter ISBN" name="isbn">
                      </div>
                      <div class="form-group">
                        <input type="text" class="form-control"  placeholder="Enter Author" name="author">
                      </div>
                      <div class="form-group">
                        <input type="text" class="form-control"  placeholder="Enter Publisher" name="publisher">
                      </div>
                      <div class="form-check">
                        <button type="submit" class="btn btn-primary" name="submit" value="addbook">Submit</button>
                      </div>
                    </form>
		</div>
		<div class="row">
                    <form action="CrudBook" method="post">
                    <label>Edit Book</label>
                    <div class="form-group">
						<input type="text" class="form-control" placeholder="Enter Book Id To Update" name="bookId">
					</div>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Enter updated Title" name="bookTitle">
					</div>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Enter updated Year" name="pubYear">
					</div>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Enter updated ISBN" name="isbn">
					</div>
                      <div class="form-check">
                        <button type="submit" class="btn btn-primary" name="submit" value="updatebook">Update</button>
                      </div>
                    </form>
		</div>
		<div class="row">
                    <form action="CrudBook" method="post">
                    <label>Delete Book</label>
                      <div class="form-group">
                        <input type="text" class="form-control" placeholder="Enter BookId To Delete" name="bookId">
                      </div>
                      <div class="form-check">
                        <button type="submit" class="btn btn-primary" name="submit" value="deletebook">Delete</button>
                      </div>
                    </form>
		</div>
	</div>
	<form class="form-group" action="Logout" method="get">
			<input type="submit" value="Logout" class="form-control btn btn-success " name="">
		</form>
</body>
</html>