
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
        <a href="crudbook.jsp" class="list-group-item">
            <i class="fa fa-comment-o"></i> Add Book
        </a>
        <a href="crudbook.jsp" class="list-group-item">
            <i class="fa fa-search"></i> Edit Book
        </a>
        <a href="crudbook.jsp" class="list-group-item">
            <i class="fa fa-user"></i> Delete Book
        </a>
        <a href="cruduser.jsp" class="list-group-item">
            <i class="fa fa-folder-open-o"></i> Add User
        </a>
        <a href="cruduser.jsp" class="list-group-item">
            <i class="fa fa-bar-chart-o"></i> Edit User 
        </a>
        <a href="cruduser.jsp" class="list-group-item">
            <i class="fa fa-envelope"></i> Delete User
        </a>
        <a href="seeall.jsp" class="list-group-item">
            <i class="fa fa-envelope"></i> See All Book
        </a>
        <a href="seeall.jsp" class="list-group-item">
            <i class="fa fa-envelope"></i> See All User
        </a>
		<form class="form-group" action="Logout" method="post">
			<input type="submit" value="Logout" class="form-control btn btn-success " name="">
		</form>
	</div>     
</body>
</html>