package com.hanfak.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionManager {
	private static DatabaseConnectionManager instance = null;
	private Connection connection = null;

	private final String CONN_STRING 	= "jdbc:mysql://localhost/";
	private final String DBNAME 		= "fonix_users";
	private final String USERNAME		= "root";
	private final String PASSWORD 		= "password";

	private DatabaseConnectionManager(){}
	
	public static DatabaseConnectionManager getInstance(){
		if(instance == null){
			instance = new DatabaseConnectionManager();
		}
		return instance;
	}
	
	public Connection getConnection(){
		if(connection == null){
			if(openConnection()) {
				System.out.println("Connection Opened");
				return connection;
			} else{
				return null;
			}
		}
		return connection;
	}
	
	public void close(){
		System.out.println("Closing Connection");
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		connection = null;
	}
	
	private boolean openConnection(){
		try {
			System.out.println("Opening Connection");
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(CONN_STRING + DBNAME, USERNAME, PASSWORD);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("error");
			e.printStackTrace();
		}
		return true;
	}
}
