package com.ravi.lms.dao;

import java.sql.SQLException;
import java.util.List;

import com.ravi.lms.model.Book;
import com.ravi.lms.model.Fine;
import com.ravi.lms.model.IssueBook;
import com.ravi.lms.model.User;

public interface LmsDao {
	
	public User authenticateUser(User user) throws SQLException;
	
	public int addBook(Book ab) throws SQLException;
	public int deleteBook(Book db) throws SQLException;
	public int editBook(Book eb) throws SQLException;
	
	public int addUser(User au) throws SQLException;
	public int deleteUser(User du) throws SQLException;
	public int editUser(User eu) throws SQLException;
	
	public int issueBook(IssueBook ib) throws SQLException;
	
	public int returnBook(IssueBook rb) throws SQLException;
	public int calculateFine(Fine fn) throws SQLException;
	public String getExpiry(IssueBook ib) throws SQLException;
	public int getAval() throws SQLException;
	public boolean checkBook(Book b) throws SQLException;
	public boolean checkUser(User u)  throws SQLException;
	public boolean checkBookUser(IssueBook ib) throws SQLException;
	
	public List<User> getAllUser() throws SQLException;
	public List<Book> getAllBook() throws SQLException;
	
	public List<IssueBook> getIssuedBookByUser(IssueBook ib) throws SQLException;
	public List<IssueBook> getUserIssuedBook(IssueBook ib) throws SQLException;
}