<%@ page import="java.sql.*"%>
<%@ page import="dao.DBConnection"%>
<%@ page import="model.User"%>

<%
User user=(User)session.getAttribute("user");

if(user==null){
response.sendRedirect("../login.jsp");
return;
}

int alumniId=user.getId();
%>

<html>

<head>

<title>Mentorship Requests</title>

<style>

body{
font-family:Arial;
background:#f4f6f9;
margin:0;
}

.header{
background:#007bff;
color:white;
padding:15px;
font-size:22px;
}

.container{
padding:20px;
}

.card{
background:white;
padding:15px;
margin-bottom:15px;
border-radius:8px;
box-shadow:0 2px 10px rgba(0,0,0,0.1);
}

button{
padding:6px 12px;
border:none;
border-radius:4px;
cursor:pointer;
}

.accept{
background:green;
color:white;
}

.reject{
background:red;
color:white;
}

</style>

</head>

<body>

<div class="header">

Mentorship Requests

</div>

<div class="container">

<%

Connection conn=DBConnection.getConnection();

String sql="SELECT * FROM mentorship_requests WHERE alumni_id=?";

PreparedStatement ps=conn.prepareStatement(sql);

ps.setInt(1,alumniId);

ResultSet rs=ps.executeQuery();

while(rs.next()){

%>

<div class="card">

<p><b>Student ID:</b> <%=rs.getInt("student_id")%></p>

<p><b>Message:</b> <%=rs.getString("message")%></p>

<p><b>Status:</b> <%=rs.getString("status")%></p>

<form action="../updateMentorship" method="post">

<input type="hidden" name="id" value="<%=rs.getInt("id")%>">

<button name="action" value="Accepted" class="accept">Accept</button>

<button name="action" value="Rejected" class="reject">Reject</button>

</form>

</div>

<%

}

%>

</div>

</body>

</html>