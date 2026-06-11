package com.practical_2;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/LifeCycle")
public class LifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LifeCycle() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Initializing the Object");
		// TODO Auto-generated method stub
	}


	
	public void destroy() {
		System.out.println("Detroying the Object");
		// TODO Auto-generated method stub
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("service method called");
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		out.println("<h1>servlet lifecycle Demonstration</h1>"); 
		out.println("<P>check the server console for lifecycle message</p>"); 
		out.println("Aryan Deshmukh");
		
	}
	

}
