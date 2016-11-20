package com.hanfak.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanfak.databases.LoginDatabaseManager;
import com.hanfak.models.User;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private User userLoggingIn;

	public Login() {
        super();
        userLoggingIn = new User();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email	=	request.getParameter("email");
		String password	=	request.getParameter("password");
		
//		User userLoggingIn = new User();
		userLoggingIn.setEmail(email);
		userLoggingIn.setPassword(password);
		boolean checkUser = false;
		try {
			checkUser = LoginDatabaseManager.checkUser(userLoggingIn);
			System.out.println(checkUser);
			response.sendRedirect("welcome.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	

	}

}
