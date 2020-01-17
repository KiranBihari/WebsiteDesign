package com.technoevans.sendingFormData;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendMail extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String to = "biharikiranranjan@gmail.com";
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String message = request.getParameter("message");

		try {
			Mailer.send(to, name, email, subject, message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.print("message has been sent successfully");
		out.close();
	}

}
