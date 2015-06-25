package com.haoqianji.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.haoqianji.model.BookType;

public class BookTypeDao {
	/**
	 * 添加书类型
	 * @param con
	 * @param bookType
	 * @return i
	 * @throws SQLException
	 */
	public int bookTypeAdd(Connection con, BookType bookType)
			throws SQLException {
		String sql = "insert into t_booktype(bookTypeName,bookTypeDesc) values(?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, bookType.getBookTypeName());
		pstmt.setString(2, bookType.getBookTypeDesc());
		int i = pstmt.executeUpdate();
		pstmt.close();
		return i;
	}
	/**
	 * 搜索书类型
	 * @param con
	 * @param bookType
	 * @return bookTypes
	 * @throws SQLException
	 */
	public ArrayList<BookType> bookTypeSearch(Connection con, BookType bookType)
			throws SQLException {
		ArrayList<BookType> bookTypes = new ArrayList<BookType>();
		String sql = "select * from t_booktype where bookTypeName like ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		String s = "%" + bookType.getBookTypeName() + "%";
		pstmt.setString(1, s);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			BookType e = new BookType();
			e.setBookTypeName(rs.getString("bookTypeName"));
			e.setBookTypeDesc(rs.getString("bookTypeDesc"));
			e.setId(rs.getInt("ID"));
			bookTypes.add(e);
		}
		rs.close();
		pstmt.close();
		return bookTypes;
	}
	/**
	 * 修改书类型
	 * @param con
	 * @param bookType
	 * @return i
	 * @throws SQLException
	 */
	public int bookTypeModify(Connection con, BookType bookType)
			throws SQLException {
		String sql = "update t_booktype set bookTypeName = ?, bookTypeDesc = ? where id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, bookType.getBookTypeName());
		pstmt.setString(2, bookType.getBookTypeDesc());
		pstmt.setInt(3, bookType.getId());
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
		String sql = "delete from t_booktype where id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, ID);
		int i = pstmt.executeUpdate();
		pstmt.close();
		return i;
	}
}
