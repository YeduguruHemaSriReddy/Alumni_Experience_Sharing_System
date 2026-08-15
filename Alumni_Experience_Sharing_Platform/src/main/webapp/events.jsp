<%@ page import="java.sql.*" %>
<%@ page import="dao.DBConnection" %>

<html>

<head>

<title>Events</title>

</head>

<body>

<h2>Upcoming Events</h2>

<%

Connection conn = DBConnection.getConnection();

String sql="SELECT * FROM events";

Statement st=conn.createStatement();

ResultSet rs=st.executeQuery(sql);

while(rs.next()){

%>

<h3><%=rs.getString("title")%></h3>

<p><%=rs.getString("description")%></p>

<p>Date: <%=rs.getString("event_date")%></p>

<hr>

<%

}

%>

</body>

</html>