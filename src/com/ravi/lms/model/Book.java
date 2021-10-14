package com.ravi.lms.model;

public class Book {
	private int bookId;
	private String bookTitle;
	private String bookYear;
	private String bookIsbn;
	private int bookAvailable;
	private String publisherName;
	private String author;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getBookYear() {
		return bookYear;
	}
	public void setBookYear(String bookYear) {
		this.bookYear = bookYear;
	}
	public String getBookIsbn() {
		return bookIsbn;
	}
	public void setBookIsbn(String bookIsbn) {
		this.bookIsbn = bookIsbn;
	}
	public int getBookAvailable() {
		return bookAvailable;
	}
	public void setBookAvailable(int bookAvailable) {
		this.bookAvailable = bookAvailable;
	}
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
}
