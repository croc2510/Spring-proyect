package com.softtek.academia.conf;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class MyConnection {
	
	private static BasicDataSource ds;
	
	static {
		ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUsername("root");
		ds.setPassword(null);
		ds.setUrl("jdbc:mysql://localhost:3306/mydb?useLegacyDatetimeCode=false&serverTimezone=UTC");
	}
	
	private MyConnection() {
		
	}
	
	public static Connection getConnection() {
		
		Connection connection = null;
		
		try {
			connection = ds.getConnection();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return connection;
	}

}
