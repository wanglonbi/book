package com.haoqianji.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.haoqianji.model.Book;
import com.haoqianji.model.Borrower;
import com.haoqianji.util.StringUtil;

public class BookDao {
	
	/**
	 * 图书添加
	 * @param con
	 * @param book
	 * @return i
	 * @throws SQLException
	 */
	public int bookAdd(Connection con, Book book)
			throws SQLException {
		String sql = "insert into t_book(bookName,bookDesc,author,gender,price,booktypeid) "
				+ "values(?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, book.getBookName());
		pstmt.setString(2, book.getBookDesc());
		pstmt.setString(3, book.getAuthor());
		pstmt.setString(4, book.getGender());
		pstmt.setFloat(5, book.getPrice());
		pstmt.setInt(6, book.getBookTypeId());	
		int i = pstmt.executeUpdate();
		pstmt.close();
		return i;
	}
	
	/**
	 * 借书
	 * @param con
	 * @param book
	 * @param borrower
	 * @return i
	 * @throws SQLException
	 */
	public int bookBorrow(Connection con, Book book, Borrower borrower) throws SQLException{
		String sql = "update t_book"
				+ "set (borrowerId,borrowerDate) = (?,?)"
				+ "where id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, book.getBorrowerId());
		pstmt.setDate(2, book.getBorrowerDate());
		pstmt.setInt(3, book.getId());
		int i = pstmt.executeUpdate();
		pstmt.close();
		return i;
	}
	
	/**
	 * 还书
	 * @param con
	 * @param book
	 * @param borrower
	 * @return i
	 * @throws SQLException
	 */
	public int bookBorrow(Connection con, Book book) throws SQLException{
		String sql = "update t_book"
				+ "set (borrowerId,borrowerDate) = (?,?)"
				+ "where id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, -1);
		pstmt.setDate(2, null);
		pstmt.setInt(3, book.getId());
		int i = pstmt.executeUpdate();
		pstmt.close();
		return i;
	}	
	
	/**
	 * 搜索所属类别是否有书
	 * @param con
	 * @param bookTypeId
	 * @return flag
	 * @throws SQLException
	 */
	public boolean getBookByBookTypeId(Connection con, int bookTypeId) throws SQLException{
		String sql = "select * from t_book where bookTypeId = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, bookTypeId);
		ResultSet rs = pstmt.executeQuery();
		int i = 0;
		while (rs.next()) {
			i++;
		}
		boolean flag = true;
		if(i==0)
			flag = false;
		return flag;
	}
	
	/**
	 * 搜索被某人是否有借了未还的书
	 * @param con
	 * @param BorrowerId
	 * @return
	 * @throws SQLException
	 */
	public boolean getBookByBorrowerId(Connection con, int BorrowerId) throws SQLException{
		String sql = "select * from t_book where BorrowerId = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, BorrowerId);
		ResultSet rs = pstmt.executeQuery();
		int i = 0;
		while (rs.next()) {
			i++;
		}
		boolean flag = true;
		if(i==0)
			flag = false;
		return flag;
	}
	
	/**
	 * 搜索书
	 * @param con
	 * @param book
	 * @return books
	 * @throws SQLException
	 */
	public ArrayList<Book> bookSearch(Connection con, Book book)
			throws SQLException{
		ArrayList<Book> books = new ArrayList<Book>();
		StringBuffer sqlSB = new StringBuffer("select * from t_book,t_booktype where t_book.bookTypeId = t_bookType.id");
		if (!StringUtil.isEmpty(book.getBookName())){
			sqlSB.append( "and bookName like %"+book.getBookName()+"%");
		}
		if(!StringUtil.isEmpty(book.getGender()))
			sqlSB.append("and gender = ?"+book.getGender()) ;
		if(!StringUtil.isEmpty(book.getAuthor()))
			sqlSB.append("and author = like %"+book.getAuthor()+"%");
		if(book.getBookTypeId()!=-1)
			sqlSB.append("and bookTypeId = ?");

		PreparedStatement pstmt = con.prepareStatement(sqlSB.toString());		
		String s = "%" + book.getBookName() + "%";
		pstmt.setString(1, s);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Book e = new Book();
			e.setBookName(rs.getString("bookName"));
			e.setBookDesc(rs.getString("bookDesc"));
			e.setId(rs.getInt("id"));
			e.setBookTypeId(rs.getInt("bookTypeId"));
			e.setAuthor(rs.getString("author"));
			e.setGender(rs.getString("gender"));
			e.setPrice(rs.getFloat("price"));
			e.setBorrowerDate(rs.getDate("borrowerDate"));
			e.setBorrowerId(rs.getInt("borrowerId"));
			books.add(e);
		}
		rs.close();
		pstmt.close();
		return books;
		
	}

	/**
	 * 修改书信息
	 * @param con
	 * @param book
	 * @return i
	 * @throws SQLException
	 */
	public int bookModify(Connection con, Book book)
			throws SQLException {
		String sql = "update t_book set bookName = ?, bookDesc = ?, bookTypeId = ?,"
				+ " author = ? gender = ?, price = ? where id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, book.getBookName());
		pstmt.setString(2, book.getBookDesc());
		pstmt.setInt(3, book.getBookTypeId());
		pstmt.setString(4, book.getAuthor());
		pstmt.setString(5,book.getGender());
		pstmt.setFloat(6, book.getPrice());
		int i = pstmt.executeUpdate();
		pstmt.close();
		return i;
	}

	/**
	 * 删除书
	 * @param con
	 * @param id
	 * @return i
	 * @throws SQLException
	 */
	public int bookTypeDelete(Connection con, String id) throws SQLException {
		int ID = Integer.parseInt(id);
		;
		String sql = "delete from t_book where id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, ID);
		int i = pstmt.executeUpdate();
		pstmt.close();
		return i;
	}

}
