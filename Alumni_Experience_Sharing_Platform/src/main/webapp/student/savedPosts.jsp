<%@ page import="java.sql.*" %>
<%@ page import="dao.DBConnection" %>

<html>

<head>
<title>Saved Posts</title>
</head>

<body>

<h2>Bookmarked Posts</h2>

<%

Connection conn = DBConnection.getConnection();

String sql = "SELECT * FROM posts WHERE id IN (SELECT post_id FROM bookmarks)";

Statement st = conn.createStatement();

ResultSet rs = st.executeQuery(sql);

while(rs.next()){
%>

<h3><%=rs.getString("title")%></h3>

<p><%=rs.getString("content")%></p>

<hr>

<% } %>

</body>

</html>