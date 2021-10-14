package com.ravi.lms.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtility {
	private static  Connection con;
	private static DBUtility dbu = new DBUtility();
	private DBUtility() {}
	public static DBUtility getDBUtilityObject() {
		return dbu;
	}
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?user=ravi&password=12345678");
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	public PreparedStatement createPst(String query) throws SQLException {
		return con.prepareStatement(query);
	}
	public int update(PreparedStatement pst) throws SQLException {
		return pst.executeUpdate();
	}
	public ResultSet query(PreparedStatement pst) throws SQLException {
		return pst.executeQuery();
	}
	public boolean testCon() {
		if(con!=null) {
			return true;
		}else 
			return false;
	}
}
