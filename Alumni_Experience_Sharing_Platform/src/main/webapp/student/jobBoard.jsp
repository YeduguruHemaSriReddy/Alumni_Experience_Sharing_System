<%@ page import="java.sql.*" %>
<%@ page import="dao.DBConnection" %>

<html>

<head>

<title>Job Board</title>

<style>

body{
font-family:Arial;
background:#f4f6f9;
}

.job{
background:white;
margin:20px;
padding:20px;
border-radius:8px;
box-shadow:0 2px 10px rgba(0,0,0,0.1);
}

</style>

</head>

<body>

<h2>Job Opportunities</h2>

<%

Connection conn = DBConnection.getConnection();

String sql="SELECT * FROM jobs";

Statement st=conn.createStatement();

ResultSet rs=st.executeQuery(sql);

while(rs.next()){

%>

<div class="job">

<h3><%=rs.getString("company")%></h3>

<p>Role: <%=rs.getString("role")%></p>

<p>Location: <%=rs.getString("location")%></p>

<p><%=rs.getString("description")%></p>

</div>

<%

}

%>

</body>

</html>