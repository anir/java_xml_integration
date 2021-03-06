package com.dbconnect.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dbconnect.tables.States;
import com.dbconnect.tables.Tours;

public class main {

	public static void main(String [] args) throws SQLException{
		// for java 6 and below
		//Class.forName("com.mysql.jdbc.Driver");
		 
		try (
				Connection conn = DBUtil.getConnection(DB_TYPE.MYSQL);
				Statement smt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = smt.executeQuery("select stateId, stateName from states");
				){
			States.displayData(rs);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			DBUtil.processException(e);
		}
		
		
	}
}
