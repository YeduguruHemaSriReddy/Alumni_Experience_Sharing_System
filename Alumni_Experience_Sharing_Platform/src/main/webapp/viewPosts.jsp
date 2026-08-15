<%@ page import="java.sql.*" %>
<%@ page import="dao.DBConnection" %>

<html>

<head>

<title>Experience Posts</title>

<style>

body{
font-family:Arial;
background:#f4f6f9;
margin:0;
}

.navbar{
background:#007bff;
color:white;
padding:15px;
}

.post{
background:white;
margin:20px;
padding:20px;
border-radius:8px;
box-shadow:0 2px 10px rgba(0,0,0,0.1);
}

</style>

</head>

<body>

<div class="navbar">
Experience Posts
</div>

<%

Connection conn = DBConnection.getConnection();

String sql="SELECT * FROM posts ORDER BY id DESC";

Statement st=conn.createStatement();

ResultSet rs=st.executeQuery(sql);

while(rs.next()){

%>

<div class="post">

<h3><%=rs.getString("title")%></h3>

<p><%=rs.getString("content")%></p>

</div>

<%

}

%>

</body>

</html>