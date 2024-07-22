package com.request_dispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		
		String userNameString = req.getParameter("userName");
		String userPasswordString = req.getParameter("userPass");
		
		// user password should be admin
		if(userPasswordString.equals("admin")) {	// if password is corrent then open welcome servlet
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("servlet2");
			requestDispatcher.forward(req, resp);
		}else {	// if password is wrong then show error msg with login servlet form
			printWriter.println("Sorry, please enter corrent password.");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/home.html");
			requestDispatcher.include(req, resp);
		}
	}
}