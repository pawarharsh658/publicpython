<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*"%>
<%
String id = request.getParameter("id");
String name = request.getParameter("name");
String email = request.getParameter("email");
String password = request.getParameter("password");

try {
	Class.forName("com.mysql.cj.jdbc.Driver");//class.forName-tell java to load the jdbc driver  
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "unknownbuddy");
	PreparedStatement ps = con.prepareStatement("INSERT INTO U_register(id,name,email,password) VALUES(?,?,?,?)");
	//? is a place holder instead of writing value later will pass  
	ps.setString(1, id);
	//this fills the ? wale values setString(index,value)  
	ps.setString(2, name);
	ps.setString(3, email);
	ps.setString(4, password);
	int i = ps.executeUpdate();
	
	//here excecute update is happen if that execute update is successful then i=1 else it is 0  
	// it return the int valuei.e rows affected after the successful updation  
			
	if (i > 0) {
		out.println("<h3>Registration Successful!</h3>");
	} else {
		out.println("<h3>Registration Failed!</h3>");
		ps.executeUpdate();
	}
} catch (Exception e) {
	out.println(e);
}
%>
<br>
<a href="display.jsp">view entry</a>
