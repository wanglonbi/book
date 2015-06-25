package com.haoqianji.model;

import java.sql.Date;

public class Book {
	
	private int id;
	private String bookName;
	private String bookDesc;
	private String author;
	private String gender;
	private Float price;
	private int bookTypeId;
	private int borrowerId;
	private Date borrowerDate;
	
	
	public Book() {
		super();
	}
	public Book(String bookName, String bookDesc, String author, String gender,
			Float price, int bookTypeId) {
		super();
		this.bookName = bookName;
		this.bookDesc = bookDesc;
		this.author = author;
		this.gender = gender;
		this.price = price;
		this.bookTypeId = bookTypeId;
	}
	public Date getBorrowerDate() {
		return borrowerDate;
	}
	public void setBorrowerDate(Date borrowerDate) {
		this.borrowerDate = borrowerDate;
	}
	public void setBookTypeId(int bookTypeId) {
		this.bookTypeId = bookTypeId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookDesc() {
		return bookDesc;
	}
	public void setBookDesc(String bookDesc) {
		this.bookDesc = bookDesc;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public int getBookTypeId() {
		return bookTypeId;
	}
	public void setBooktypeId(int booktypeId) {
		this.bookTypeId = booktypeId;
	}
	public int getBorrowerId() {
		return borrowerId;
	}
	public void setBorrowerId(int borrowerId) {
		this.borrowerId = borrowerId;
	}

}
