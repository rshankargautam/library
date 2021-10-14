<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.ravi.lms.model.Book" %>
<%@ page import="com.ravi.lms.model.User" %>
<%@ page import="com.ravi.lms.dao.LmsDaoImpl" %>
		<%
		LmsDaoImpl dao = new LmsDaoImpl();
		List<Book> bookList;
		%>
<!DOCTYPE html>
<html>
<head>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style><%@include file="/WEB-INF/css/style.css"%></style>
</head>
<body>
<div class="form-check">
		<button type="submit" class="btn btn-primary" name="submit" value="seeallbook">See All Book</button>
	</div>
	<form class="form-group" action="Logout" method="post">
			<input type="submit" value="Logout" class="form-control btn btn-success " name="">
		</form>
		<%
		if(request.getParameter("submit") == "seeallbook"){
			bookList = dao.getAllBook();	
		%>
		<table border="1">
<tr>
<td>Books Id</td>
<td>Books Title</td>
<td>Books Year</td>
<td>Books ISBN</td>
</tr>
<%for(Book book : bookList){
%>
<tr>
<td><%= book.getBookId() %></td>
<td><%= book.getBookTitle() %></td>
<td><%= book.getBookYear() %></td>
<td><%= book.getBookIsbn() %></td>
</tr>
<%
}
}
%>
</table>
</body>
</html>