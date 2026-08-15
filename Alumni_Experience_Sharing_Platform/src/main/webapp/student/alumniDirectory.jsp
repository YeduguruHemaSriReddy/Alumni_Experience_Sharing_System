<%@ page import="java.sql.*" %>
<%@ page import="dao.DBConnection" %>

<html>

<head>
<title>Alumni Directory</title>
</head>

<body>

<h2>Alumni Directory</h2>

<%

Connection conn = DBConnection.getConnection();

String sql = "SELECT * FROM users WHERE role='alumni' AND status='approved'";

Statement st = conn.createStatement();

ResultSet rs = st.executeQuery(sql);

while(rs.next()){
%>

<div style="border:1px solid #ccc;padding:10px;margin:10px">

<h3><%=rs.getString("name")%></h3>

<p>Email: <%=rs.getString("email")%></p>

<form action="mentorship.jsp" method="get">

<input type="hidden" name="alumniId" value="<%=rs.getInt("id")%>">

<button type="submit">Request Mentorship</button>

</form>

</div>

<% } %>

</body>

</html>