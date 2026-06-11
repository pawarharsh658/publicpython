<%@ page import="java.sql.*"%>
<html>
<head>
<title>Display Users</title>
</head>
<body>
	<h2>Registered Users</h2>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Password</th>
		</tr>
		<%
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "unknownbuddy");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM U_register");
			while (rs.next()) {
		%>
		<tr>
			<td><%=rs.getInt("id")%></td>
			<td><%=rs.getString("name")%></td>
			<td><%=rs.getString("email")%></td>
			<td><%=rs.getString("password")%></td>
		</tr>
		<%
		}
		con.close();
		} catch (Exception e) {
		out.println(e);
		}
		%>
	</table>
</body>
</html>
