package com.haoqianji.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {

	private String dbUrl = "jdbc:postgresql://localhost:5432/db_book";
	private String dbUserName = "postgres";
	private String dbPassword = "123456";
	private String jdbcName = "org.postgresql.Driver";
	
	/**
	 * get database connection
	 * @return
	 * @throws Exception
	 */
	public Connection getCon() throws /*Exception*/ ClassNotFoundException, SQLException {
		Class.forName(jdbcName);
		Connection con = DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
		return con;
	}
	
	/**
	 * close database connection
	 * @param con
	 * @throws SQLException
	 */
	public void closeCon(Connection con) throws SQLException{
		if (con!=null){
			con.close();
			}
	}
	public static void main(String[] args){
		DbUtil dbUtil = new DbUtil();
		try {
			dbUtil.getCon();
			System.out.println("数据库连接成功");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
