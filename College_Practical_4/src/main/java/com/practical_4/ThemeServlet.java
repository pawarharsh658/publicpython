package com.practical_4;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ThemeServlet")
public class ThemeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ThemeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String themeColor = "white";
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("theme")) {
					themeColor = c.getValue();
				}
			}
		}
		
		out.println("<html><body style='background-color:" + themeColor + ";'>");
		out.println("<h2>Welcome Back!</h2>");
		out.println("<p>Your selected theme color is: " + themeColor + "</p>");
		out.println("<a href='index.html'>Change Theme</a>");
		out.println("</body></html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		
		String theme = request.getParameter("theme");  
		Cookie cookie = new Cookie("theme", theme);  
		cookie.setMaxAge(60 * 60 * 24); // 1 day  
		response.addCookie(cookie);  
		response.sendRedirect("ThemeServlet");  
	}

}
