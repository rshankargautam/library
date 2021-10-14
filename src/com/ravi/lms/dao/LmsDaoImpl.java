package com.ravi.lms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ravi.lms.db.DBUtility;
import com.ravi.lms.model.Book;
import com.ravi.lms.model.Fine;
import com.ravi.lms.model.IssueBook;
import com.ravi.lms.model.User;

public class LmsDaoImpl implements LmsDao {
	DBUtility dcon = DBUtility.getDBUtilityObject(); 
	PreparedStatement pst;
	ResultSet rs;
	@Override
	public int addBook(Book ab) throws SQLException {
		String query = "insert into book(book_id, book_title, book_pubyear, book_isbn, book_available) values(?,?,?,?,?)";
		pst = dcon.createPst(query);
		pst.setInt(1, ab.getBookId());
		pst.setString(2, ab.getBookTitle());
		pst.setString(3, ab.getBookYear());
		pst.setString(4, ab.getBookIsbn());
		pst.setInt(5, ab.getBookAvailable());
		dcon.update(pst);
		
		query = "insert into author(author_name, author_id) values(?,?)";
		pst = dcon.createPst(query);
		pst.setString(1, ab.getAuthor());
		pst.setInt(2, ab.getBookId());
		dcon.update(pst);
		
		query = "insert into publisher(publisher_name, publisher_id) values(?,?)";
		pst = dcon.createPst(query);
		pst.setString(1, ab.getPublisherName());
		pst.setInt(2, ab.getBookId());
		
		return dcon.update(pst);
	}

	@Override
	public int deleteBook(Book db) throws SQLException {
		String query = "delete from book where book_id=?";
		pst = dcon.createPst(query);
		pst.setInt(1, db.getBookId());
		dcon.update(pst);
		
		query = "update book set book_available=?";
		pst = dcon.createPst(query);
		pst.setInt(1, db.getBookAvailable());
		dcon.update(pst);
		
		query = "delete from publisher where publisher_id=?";
		pst = dcon.createPst(query);
		pst.setInt(1,db.getBookId());
		dcon.update(pst);
		
		query = "delete from author where author_id=?";
		pst = dcon.createPst(query);
		pst.setInt(1,db.getBookId());
		return dcon.update(pst);
	}

	@Override
	public int editBook(Book eb) throws SQLException {
		String sql = "update book set book_title=?, book_pubyear=?, book_isbn=? where book_id=?";
		pst = dcon.createPst(sql);
		pst.setString(1, eb.getBookTitle());
		pst.setString(2, eb.getBookYear());
		pst.setString(3, eb.getBookIsbn());
		pst.setInt(4, eb.getBookId());
		return dcon.update(pst);
	}

	@Override
	public int addUser(User au) throws SQLException {
		String query = "insert into user(user_name, user_loginname, user_email, user_expiry, user_password, user_role) values(?,?,?,?,?,?)";
		pst = dcon.createPst(query);
		pst.setString(1, au.getUserName());
		pst.setString(2, au.getUserLoginName());
		pst.setString(3, au.getUserEmail());
		pst.setString(4, au.getUserExpiry());
		pst.setString(5, au.getUserPassword());
		pst.setInt(6, au.getUserRole());
		return dcon.update(pst);
	}

	@Override
	public int deleteUser(User du) throws SQLException {
		String query = "delete from user where user_loginname=?";
		pst = dcon.createPst(query);
		pst.setString(1, du.getUserLoginName());
		return dcon.update(pst);
	}

	@Override
	public int editUser(User eu) throws SQLException {
		String sql = "update user set user_name=?, user_email=? where user_loginname=?";
		pst = dcon.createPst(sql);
		pst.setString(1, eu.getUserName());
		pst.setString(2, eu.getUserEmail());
		pst.setString(3, eu.getUserLoginName());
		return dcon.update(pst);
	}

	@Override
	public int issueBook(IssueBook ib) throws SQLException {
		String query = "insert into issuedBook(ib_booktitle, ib_username, ib_issuedate, ib_expirydate) values(?,?,?,?)";
		pst = dcon.createPst(query);
		pst.setString(1, ib.getIbBookTitle());
		pst.setString(2, ib.getIbUserName());
		pst.setString(3, ib.getIbIssueDate());
		pst.setString(4, ib.getIbReturnDate());
		return dcon.update(pst);
	}

	@Override
	public int returnBook(IssueBook rb) throws SQLException {
		String query = "delete from issuedBook where ib_username=? and ib_booktitle=?";
		pst = dcon.createPst(query);
		pst.setString(1, rb.getIbUserName());
		pst.setString(2, rb.getIbBookTitle());
		dcon.update(pst);
		
		query = "update book set book_available=?";
		pst = dcon.createPst(query);
		pst.setInt(1, rb.getAvailableBook());
		return dcon.update(pst);
	}
	
	@Override
	public int calculateFine(Fine fn) throws SQLException{
		String query  = "insert into fine(fine_date, amount) values(?,?)";
		pst = dcon.createPst(query);
		pst.setString(1, fn.getFineDate());
		pst.setDouble(2, fn.getAmount());
		return dcon.update(pst);
	}
	public String getExpiry(IssueBook ib) throws SQLException{
		String query = "select ib_expirydate from issuedBook where ib_booktitle=? and ib_username=? ";
		pst = dcon.createPst(query);
		pst.setString(1, ib.getIbBookTitle());
		pst.setString(2, ib.getIbUserName());
		rs = dcon.query(pst);
		if(rs.next())
		return rs.getString("ib_expirydate");
		else
			return null;
	}
	
	public int getAval() throws SQLException{
		String query = "select  book_available from book";
		pst = dcon.createPst(query);
		rs = dcon.query(pst);
		int avalBook = 0;
		while(rs.last())
			avalBook = rs.getInt("book_available");
		return avalBook;
	}
	
	public boolean checkBook(Book b) throws SQLException{
		String query = "select * from book where book_title=?";
		pst = dcon.createPst(query);
		pst.setString(1, b.getBookTitle());
		rs = dcon.query(pst);
		while(rs.next())
			return true;

		return false;
	}
	public boolean checkUser(User u)  throws SQLException{
		String query = "select * from user where user_loginname=?";
		pst = dcon.createPst(query);
		pst.setString(1, u.getUserLoginName());
		rs = dcon.query(pst);
		while(rs.next()) 
			return true;
		return false;
		}

	public boolean checkBookUser(IssueBook ib) throws SQLException{
		String query = "select * from issuedBook where ib_username=? and ib_booktitle=?";
		pst = dcon.createPst(query);
		pst.setString(1, ib.getIbUserName());
		pst.setString(2, ib.getIbBookTitle());
		rs = dcon.query(pst);
		if(rs.next())
			return true;
		else 
			return false;
	}

	@Override
	public List<User> getAllUser() throws SQLException {
		String sql = "select * from User";
		pst = dcon.createPst(sql);

		rs = dcon.query(pst);
		List<User> users = new ArrayList<User>();
		while (rs.next()) {
			User user = new User();
			user.setUserId(rs.getInt("id"));
			user.setUserName(rs.getString("user_name"));
			user.setUserLoginName(rs.getString("user_loginname"));
			user.setUserEmail(rs.getString("user_email"));
			user.setUserExpiry(rs.getString("user_expiry"));
			users.add(user);
		}
		return users;
	}

	@Override
	public List<Book> getAllBook() throws SQLException {
		String query = "select * from book";
		pst = dcon.createPst(query);
		
		rs = dcon.query(pst);
		List<Book> books = new ArrayList<Book>();
		while(rs.next()) {
			Book book = new Book();
			book.setBookId(rs.getInt("book_id"));
			book.setBookTitle(rs.getString("book_title"));
			book.setBookYear(rs.getString("book_pubyear"));
			book.setBookIsbn(rs.getString("book_isbn"));
			if(rs.last()) {
			book.setBookAvailable(rs.getInt("book_available"));
			}
			books.add(book);
		}
		return books;
	}

	@Override
	public List<IssueBook> getIssuedBookByUser(IssueBook ib) throws SQLException {
		String query = "select * from issuedBook where ib_username=?";
		pst = dcon.createPst(query);
		pst.setString(1, ib.getIbUserName());
		
		rs = dcon.query(pst);
		List<IssueBook> getIbs = new ArrayList<IssueBook>();
		while(rs.next()) {
			IssueBook getIb = new IssueBook();
			getIb.setIbBookTitle(rs.getString("ib_booktitle"));
			getIb.setIbUserName(rs.getString("ib_username"));
			getIb.setIbIssueDate(rs.getString("ib_issuedate"));
			getIb.setIbExpiryDate(rs.getString("ib_expirydate"));
			getIbs.add(getIb);
		}
		return getIbs;
	}

	@Override
	public List<IssueBook> getUserIssuedBook(IssueBook ib) throws SQLException {
		String query = "select * from issuedBook where ib_booktitle=?";
		pst = dcon.createPst(query);
		pst.setString(1, ib.getIbBookTitle());
		
		rs = dcon.query(pst);
		List<IssueBook> getIbs = new ArrayList<IssueBook>();
		while(rs.next()) {
			IssueBook getIb = new IssueBook();
			getIb.setIbBookTitle(rs.getString("ib_booktitle"));
			getIb.setIbUserName(rs.getString("ib_username"));
			getIb.setIbIssueDate(rs.getString("ib_issuedate"));
			getIb.setIbExpiryDate(rs.getString("ib_expirydate"));
			getIbs.add(getIb);
		}
		return getIbs;
	}

	@Override
	public User authenticateUser(User user) throws SQLException {
		
		String query = "select * from user where user_loginname=? and user_password=?";
		pst = dcon.createPst(query);
		
		pst.setString(1, user.getUserLoginName());
		pst.setString(2, user.getUserPassword());
		
		rs = pst.executeQuery();
		if(rs.next()) {
			User u = new User();
			u.setUserName(rs.getString("user_name"));
			u.setUserRole(rs.getInt("user_role"));
			return u;
		}else {
			System.out.println("record not found");
			return null;
		}
	}
}
