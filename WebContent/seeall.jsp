<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.ravi.lms.dao.LmsDaoImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ravi.lms.model.Book" %>
<%@ page import="com.ravi.lms.model.User" %>
		<%
		LmsDaoImpl dao = new LmsDaoImpl();
		List<Book> bookList;
		List<User> userList;
		%>
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
	<div class="form-check">
		<button type="submit" class="btn btn-primary" name="submit" value="seeallbook">See All Book</button>
	</div>
	<div class="form-check">
		<button type="submit" class="btn btn-primary" name="submit" value="seealluser">See All User</button>
	</div>
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
<%
		if(request.getParameter("submit") == "seealluser"){
			userList = dao.getAllUser();	
		%>
		<table border="1">
<tr>
<td>User Id</td>
<td>User Name</td>
<td>User Login Name</td>
<td>User Email</td>
<td>User Expiry</td>
</tr>
<%for(User user : userList){
%>
<tr>
<td><%= user.getUserId() %></td>
<td><%= user.getUserName() %></td>
<td><%= user.getUserLoginName() %></td>
<td><%= user.getUserEmail() %></td>
<td><%= user.getUserExpiry() %></td>
</tr>
<%
}
}
%>
</table>
</body>
</html>