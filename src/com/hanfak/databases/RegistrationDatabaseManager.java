package com.hanfak.databases;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import com.hanfak.models.User;

public class RegistrationDatabaseManager {
	
	public static void Insert(User newUser) throws ClassNotFoundException, SQLException{
		Connection connection = DatabaseConnectionManager.getInstance().getConnection();
		
		String insertNewUser	= "INSERT INTO clients (username, email, password, mobile) VALUES(?,?,?,?)";
		PreparedStatement pstmt = connection.prepareStatement(insertNewUser);
		pstmt.setString(1, newUser.getUsername());
		pstmt.setString(2, newUser.getEmail());
		pstmt.setString(3, newUser.getPassword());
		pstmt.setString(4, newUser.getMobile());
		pstmt.executeUpdate();
		
		pstmt.close();
		DatabaseConnectionManager.getInstance().close();	
	}
}
