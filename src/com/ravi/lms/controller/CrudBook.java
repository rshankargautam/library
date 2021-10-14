package com.ravi.lms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ravi.lms.dao.LmsDaoImpl;
import com.ravi.lms.model.Book;


@WebServlet("/CrudBook")
public class CrudBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CrudBook() {}
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		LmsDaoImpl dao = new LmsDaoImpl();
		Book book;
		

		  String calledMethod = request.getParameter("submit");
		  if(calledMethod.equals("addbook")) {
			  book = new Book();
			  String book_isbn = request.getParameter("isbn");
				book.setBookTitle(request.getParameter("bookTitle"));
				book.setBookYear(request.getParameter("pubYear"));
				book.setBookIsbn(request.getParameter("isbn"));
				book.setAuthor(request.getParameter("author"));
				book.setPublisherName(request.getParameter("publisher"));
				int aval = 0;
				try {
					aval = dao.getAval();
				} catch (SQLException e1) {
	
					e1.printStackTrace();
				}
				book.setBookAvailable(++aval);
				int book_id =book_isbn.charAt(0)*100+book_isbn.charAt(1)*10+book_isbn.charAt(0);
				book.setBookId((book_id));
				try {
					dao.addBook(book);
				} catch (SQLException e) {
					e.getMessage();
				}
		  out.println("addbook clicked");
		  
		  }else if(calledMethod.equals("updatebook")) {
			  	
			  book = new Book();
			  	book.setBookTitle(request.getParameter("bookId"));
			  	book.setBookTitle(request.getParameter("bookTitle"));
				book.setBookYear(request.getParameter("pubYear"));
				book.setBookIsbn(request.getParameter("isbn"));
				try {
					dao.editBook(book);
				} catch (SQLException e) {
					e.getMessage();
				}
		  out.println("updatebook clicked");
		  
		  }else if(calledMethod.equals("deletebook")) {
			  
			  book = new Book();
			  	
			  	book.setBookTitle(request.getParameter("bookId"));
				try {
					dao.deleteBook(book);
				} catch (SQLException e) {
					e.getMessage();
				}
		  out.println("deletebook clicked"); 
		  }
	}
}
