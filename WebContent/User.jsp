<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.ravi.lms.dao.LmsDaoImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ravi.lms.model.IssueBook" %>
		<%
		LmsDaoImpl dao = new LmsDaoImpl();
		List<IssueBook> list;
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
<% 
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");	
		if(session.getAttribute("username")==null)
			response.sendRedirect("login.jsp");
	%>
	Welcome ${username}
	<div class="list-group">
        <a href="loanreturnbook.jsp" class="list-group-item">
            <i class="fa fa-comment-o"></i> Loan Book
        </a>
        <a href="loanreturnbook.jsp" class="list-group-item">
            <i class="fa fa-search"></i> Return Book
        </a>
        <div class="form-group">
						<input type="text" class="form-control" placeholder="Enter user login name" name="userLoginName">
		</div>
		<div class="form-check">
                        <button type="submit" class="btn btn-primary" name="submit" value="seeissuedbook">See Issued Book</button>
		</div>
				<div class="form-check">
                        <button type="submit" class="btn btn-primary" name="submit" value="logout">Logout</button>
		</div>
        <form class="form-group" action="Logout" method="get">
			<input type="submit" value="Logout" class="form-control btn btn-success " name="">
		</form>
		<%
		if(request.getParameter("submit") == "seeissuedbook"){
			IssueBook ib = new IssueBook();
			ib.setIbUserName(request.getParameter("userLoginName"));
			list = dao.getUserIssuedBook(ib);	
		%>
		<table border="1">
<tr>
<td>Books</td>

</tr>
<%for(IssueBook is : list){
%>
<tr>
<td><%=is.getIbBookTitle()%></td>
</tr>
<%
}
}
%>
</table>
     </div>
</body>
</html>