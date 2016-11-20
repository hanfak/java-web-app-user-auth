package com.hanfak.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanfak.databases.RegistrationDatabaseManager;
import com.hanfak.models.User;

@WebServlet("/register")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private User newUser;
       
    public Registration() {
        super();
        newUser = new User();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("register.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String email 	= request.getParameter("email");
		String mobile 	= request.getParameter("mobile");
		String password = request.getParameter("password");
		
		storeParamsInUser(username, email, mobile, password);
		
		insertNewUserInDB(request, response, newUser );
	}
	
	private void storeParamsInUser(String username, String email, String mobile, String password){
		newUser.setUsername(username);
		newUser.setEmail(email);
		newUser.setPassword(password);
		newUser.setMobile(mobile);
	}
	
	private void insertNewUserInDB(HttpServletRequest request, HttpServletResponse response, User newUser) throws IOException{
		String page = "";
		try {
			if (newUser.allFieldsNotNull()){
				RegistrationDatabaseManager.Insert(newUser);
				page = "/login";
			} else {
				page = "/register";
			}
		} catch (ClassNotFoundException | SQLException e) {
			page = "/register";
			e.printStackTrace();
		} 
		response.sendRedirect(request.getContextPath() + page);	
	}
}
