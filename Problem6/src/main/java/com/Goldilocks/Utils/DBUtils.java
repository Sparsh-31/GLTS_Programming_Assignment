package com.Goldilocks.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtils {
	
	static public Connection linkBetween() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/db2";
		String user = "root";
		String password = "9966";
 
		
		return DriverManager.getConnection(url,user,password);
		
	}
	
	static public void closeConnection(Connection con) throws SQLException {
		
		if(con != null) con.close();
		
	}
	
	static public boolean checkIsEmptyOrNot(ResultSet rs) throws SQLException {
		
		if(!rs.isBeforeFirst() && rs.getRow()==0) return true;
		
		return false;
		
		
	}
	
}