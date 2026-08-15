<%@ page import="java.sql.*" %>
<%@ page import="dao.DBConnection" %>

<html>

<head>
<title>Admin Dashboard</title>
</head>

<body>

<h1>Admin Dashboard</h1>

<h3>Pending Users</h3>

<table border="1">

<tr>

<th>ID</th>
<th>Name</th>
<th>Email</th>
<th>Role</th>
<th>Action</th>

</tr>

<%

Connection conn = DBConnection.getConnection();

String sql = "SELECT * FROM users WHERE status='pending'";

Statement st = conn.createStatement();

ResultSet rs = st.executeQuery(sql);

while(rs.next()){

%>

<tr>

<td><%=rs.getInt("id")%></td>
<td><%=rs.getString("name")%></td>
<td><%=rs.getString("email")%></td>
<td><%=rs.getString("role")%></td>

<td>

<a href="approveUser?id=<%=rs.getInt("id")%>">Approve</a>

</td>

</tr>

<% } %>

</table>

</body>
</html>