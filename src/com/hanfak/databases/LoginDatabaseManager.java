package com.hanfak.databases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hanfak.models.User;

public class LoginDatabaseManager {

	public static boolean checkUser(User userLoggingIn) throws SQLException {
		Connection connection = DatabaseConnectionManager.getInstance().getConnection();
		
		String queryUserExists ="SELECT COUNT(1) FROM clients WHERE email=? AND password=?";
		PreparedStatement pstmt	=	connection.prepareStatement(queryUserExists);
		pstmt.setString(1, userLoggingIn.getEmail());
		pstmt.setString(2, userLoggingIn.getPassword());
		ResultSet rs	=	pstmt.executeQuery();
		
		rs.next();
		int res = rs.getInt(1);
//		System.out.println(rs.getInt(1));
		rs.close();
		DatabaseConnectionManager.getInstance().close();
		return res==1;
	}
}
