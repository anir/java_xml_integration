package com.dbconnect.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Launcher {

	private static final String USERNAME="dbuser";
	private static final String PASSWORD="dbpassword";
	private static final String CONN_STRING="jdbc:mysql://localhost/explorecalifornia";
	
	public static void main(String [] args) throws SQLException{
		// for java 6 and below
		//Class.forName("com.mysql.jdbc.Driver");
		 
		Connection conn = null;
		ResultSet rs= null;
		Statement smt = null;
		
		try {
			conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
			smt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = smt.executeQuery("select * from states");
			rs.last();
			System.out.println(rs.getRow());
			System.out.println("connected..");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e);
		}finally{
			if(rs != null){
				rs.close();
			}
			
			if(smt != null){
				smt.close();
			}
			
			if(conn != null){
				conn.close();
			}
		}
		
		
	}
}
