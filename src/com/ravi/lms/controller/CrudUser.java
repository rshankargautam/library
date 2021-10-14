package com.ravi.lms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ravi.lms.dao.LmsDaoImpl;
import com.ravi.lms.model.User;

@WebServlet("/CrudUser")
public class CrudUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
        public CrudUser() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		LmsDaoImpl dao = new LmsDaoImpl();
		User user;
		
		String calledMethod = request.getParameter("submit");
		
		  if(calledMethod.equals("adduser")) {
		  user = new User();
		  user.setUserName(request.getParameter("username"));
		  user.setUserLoginName(request.getParameter("userLoginName"));
		  user.setUserEmail(request.getParameter("userEmail"));
		  user.setUserPassword("userPassword");
		  
		  SimpleDateFormat sdf = 
				     new SimpleDateFormat("yyyy-MM-dd");
				Calendar cal = Calendar.getInstance();
				sdf.format(cal.getTime());
				cal.add(Calendar.DAY_OF_YEAR, 365);
				String expiryDate = sdf.format(cal.getTime());
				user.setUserExpiry(expiryDate);
				user.setUserRole(0);
		  try {
			dao.addUser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  out.println("adduser");
		  
		  }else if(calledMethod.equals("updateuser")) {
			  
			  user = new User();
			  user.setUserLoginName(request.getParameter("userLoginName"));
			  user.setUserName(request.getParameter("userLoginName"));
			  user.setUserEmail(request.getParameter("userEmail"));
			  try {
				dao.editUser(user);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  out.println("updateuser clicked");
		  
		  }else if(calledMethod.equals("deleteuser")) {
			  user = new User();
			  user.setUserLoginName(request.getParameter("userLoginName"));
			  try {
				dao.deleteUser(user);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  out.println("deleteuser clicked"); 
		  }
	}

}
