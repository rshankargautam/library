package com.ravi.lms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SeeAll")
public class SeeAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SeeAll() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		
		String calledMethod = request.getParameter("submit");
		  if(calledMethod.equals("seeallbook")) {
		  
		  out.println("seeallbook");
		  
		  }else if(calledMethod.equals("seealluser")) {
		  
		  out.println("seealluser");
		  
		  }
	}
}
