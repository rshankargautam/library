package com.ravi.lms.model;

public class IssueBook {
	private String ibBookTitle;
	private String ibUserName;
	private String ibIssueDate;
	private String ibExpiryDate;
	private int availableBook;
	public String getIbExpiryDate() {
		return ibExpiryDate;
	}
	public void setIbExpiryDate(String ibExpiryDate) {
		this.ibExpiryDate = ibExpiryDate;
	}
	public int getAvailableBook() {
		return availableBook;
	}
	public void setAvailableBook(int availableBook) {
		this.availableBook = availableBook;
	}
	public String getIbBookTitle() {
		return ibBookTitle;
	}
	public void setIbBookTitle(String ibBookTitle) {
		this.ibBookTitle = ibBookTitle;
	}
	public String getIbUserName() {
		return ibUserName;
	}
	public void setIbUserName(String ibUserName) {
		this.ibUserName = ibUserName;
	}
	public String getIbIssueDate() {
		return ibIssueDate;
	}
	public void setIbIssueDate(String ibIssueDate) {
		this.ibIssueDate = ibIssueDate;
	}
	public String getIbReturnDate() {
		return ibExpiryDate;
	}
	public void setIbReturnDate(String ibReturnDate) {
		this.ibExpiryDate = ibReturnDate;
	}
}
