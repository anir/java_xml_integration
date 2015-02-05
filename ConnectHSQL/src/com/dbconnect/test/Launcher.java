package com.dbconnect.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Launcher {

	private static final String USERNAME="dbuser";
	private static final String PASSWORD="dbpassword";
	private static final String CONN_STRING="jdbc:hsqldb:data/explorecalifornia";
	
	public static void main(String [] args) throws SQLException{
		// for java 6 and below
		//Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
			System.out.println("connected..");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e);
		}finally{
			if(conn != null){
				conn.close();
			}
		}
		
		
	}
}