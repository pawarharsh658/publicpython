package com.practical_3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		response.setContentType("text/html"); 
		PrintWriter out=response.getWriter(); 
		
		String name=request.getParameter("name"); 
		String email=request.getParameter("email"); 
		String age=request.getParameter("age"); 
		
		out.println("<html><body>"); 
		out.println("<h2>User Detail Submitted Successfully</h2>"); 
		out.println("<p><b>Name:</b>"+name+"</p>"); 
		out.println("<p><b>Email:</b>"+email+"</p>"); 
		out.println("<p><b>Age:</b>"+age+"</p>"); 
		out.println("</body><html>");
	}

}
