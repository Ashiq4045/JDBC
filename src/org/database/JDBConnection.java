package org.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.checkerframework.common.reflection.qual.ForName;

public class JDBConnection {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","12345");
		String sql="select * from instagramlogin";
	
		PreparedStatement prepareStatement = con.prepareStatement(sql);
		
	     ResultSet resultSet = prepareStatement.executeQuery();
	    
	     
		while(resultSet.next()) {
			
			String string = resultSet.getString("username");
			System.out.print(string+" \t ");
			String string2 = resultSet.getString("password");
			System.out.print(string2+"\t");
			System.out.println();
		}
		con.close();
	}
	
	

}
