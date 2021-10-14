package com.ravi.lms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ravi.lms.dao.LmsDaoImpl;
import com.ravi.lms.model.Book;
import com.ravi.lms.model.Fine;
import com.ravi.lms.model.IssueBook;
import com.ravi.lms.model.User;

@WebServlet("/LoanBook")
public class LoanBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
        public LoanBook() {
        	super();
        }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		LmsDaoImpl dao = new LmsDaoImpl(); 
		  String calledMethod = request.getParameter("submit");
		  if(calledMethod.equals("issuebook")) {
			  
			  IssueBook issueB = new IssueBook();
				Book book = new Book();
				User user = new User();
				SimpleDateFormat sdf = 
					     new SimpleDateFormat("yyyy-MM-dd");
				Calendar cal = Calendar.getInstance();
				issueB.setIbIssueDate(sdf.format(cal.getTime()));
				cal.add(Calendar.DAY_OF_YEAR, 365);
				issueB.setIbReturnDate(sdf.format(cal.getTime()));	
				issueB.setIbBookTitle(request.getParameter("bookTitle"));
				book.setBookTitle(issueB.getIbBookTitle());
				try {
					if(dao.checkBook(book)) {
						issueB.setIbUserName(request.getParameter("userLoginName"));
						user.setUserLoginName(request.getParameter("userLoginName"));
						if(dao.checkUser(user)) {
							out.println("Book is issued!!!!!");
							out.println("--Issue Date is Current Date--");
							dao.issueBook(issueB);
						}else {
							out.println("User not Found!!!!");
						}
					}else {
						out.println("Book not Found!!!!");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		  out.println("Book Issued");
		  
		  }else if(calledMethod.equals("returnbook")) {
			  IssueBook issueB = new IssueBook();

			issueB.setIbUserName(request.getParameter("userLoginName"));
			
			issueB.setIbBookTitle(request.getParameter("bookTitle"));
			SimpleDateFormat sdf = 
				     new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			String todayString = sdf.format(cal.getTime());
			Date today = null;
			try {
				today = new SimpleDateFormat("yyyy-MM-dd").parse(todayString);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Date expiry = null;
			try {
				expiry = new SimpleDateFormat("yyyy-MM-dd").parse(dao.getExpiry(issueB));
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			double fineAmount = 0;
				if(today.compareTo(expiry)>0) {
					long startTime = today.getTime();
					long endTime = expiry.getTime();
					long diffTime = startTime - endTime;
					long diffDays = diffTime / (1000 * 60 * 60 * 24);
					fineAmount = diffDays*5;
					
					out.println("You're returning "+diffDays+" days late you are fined Rs."+fineAmount);
					Fine fn = new Fine();
					fn.setFineDate(todayString);
					fn.setAmount(fineAmount);
					try {
						dao.calculateFine(fn);
						dao.returnBook(issueB);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}else {
					out.println("Returning Early! Loan Again!!!");
				}
				out.println("Book Returned");
		  }
	}
}
