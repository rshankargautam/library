package com.ravi.lms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ravi.lms.dao.LmsDaoImpl;
import com.ravi.lms.model.User;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LmsDaoImpl dao = new LmsDaoImpl();
		User user = new User();
		user.setUserLoginName(request.getParameter("uname")); 
		user.setUserPassword(request.getParameter("pass"));
		
		User userAccepted = new User();
		PrintWriter out = response.getWriter();
		
		  try { 
			  userAccepted = dao.authenticateUser(user); 
		  } catch (SQLException e) {
		  
		  e.getMessage(); }
		  if(userAccepted != null){
		  HttpSession session = request.getSession(); 
		  session.setAttribute("username", user.getUserName());
		  if(userAccepted.getUserRole()==1) { 
			  response.sendRedirect("admin.jsp"); 
			  }else if(userAccepted.getUserRole()==0){
				  response.sendRedirect("user.jsp"); 
				  }
		  
		  }else { response.sendRedirect("login.jsp"); }
	}
}
