package com.haoqianji.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.haoqianji.model.Borrower;

public class BorrowerDao {
	/**
	 * 增加借书者
	 */
	/**
	 * 增加借书者
	 * @param con
	 * @param borrower
	 * @return i
	 * @throws SQLException
	 */
	public int bookAdd(Connection con, Borrower borrower)
			throws SQLException {
		String sql = "insert into t_borrower(borrowerName, telephonenumber) "
				+ "values(?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, borrower.getBorrowerName());
		pstmt.setString(2, borrower.getTelephonenumber());
		int i = pstmt.executeUpdate();
		pstmt.close();
		return i;
	}

	/**
	 * 查找借书者
	 * @param con
	 * @param borrower
	 * @return borrowers
	 * @throws SQLException
	 */
	public ArrayList<Borrower> borrowerSearch(Connection con, Borrower borrower)
			throws SQLException {
		ArrayList<Borrower> borrowers = new ArrayList<Borrower>();
		String sql = "select * from t_borrower where borrowerName like ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		String s = "%" + borrower.getBorrowerName() + "%";
		pstmt.setString(1, s);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Borrower e = new Borrower();
			e.setBorrowerName(rs.getString("bookTypeName"));
			e.setTelephonenumber(rs.getString("telephonenumber"));
			e.setBorrowerId(rs.getInt("id"));
			borrowers.add(e);
		}
		rs.close();
		pstmt.close();
		return borrowers;
	}
	

	/**
	 * 修改借书者
	 * @param con
	 * @param borrower
	 * @return i
	 * @throws SQLException
	 */
	public int borrowerModify(Connection con, Borrower borrower)
			throws SQLException {
		String sql = "update t_borrower set borrowerName = ?, telephonenumber = ? where id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, borrower.getBorrowerName());
		pstmt.setString(2, borrower.getTelephonenumber());
		int i = pstmt.executeUpdate();
		pstmt.close();
		return i;
	}
	
	
	/**
	 * 删除借书者
	 * @param con
	 * @param id
	 * @return 
	 * @throws SQLException
	 */
	public int bookTypeDelete(Connection con, String id) throws SQLException {
		int ID = Integer.parseInt(id);
		;
		String sql = "delete from t_borrower where id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, ID);
		int i = pstmt.executeUpdate();
		pstmt.close();
		return i;
	}

}
