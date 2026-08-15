<%@ page import="model.User" %>

<%

User user = (User) session.getAttribute("user");

if(user==null){

response.sendRedirect("../login.jsp");

return;

}

%>

<html>

<head>

<title>Student Dashboard</title>

<link rel="stylesheet" href="../css/style.css">

</head>

<body>

<div class="navbar">

Welcome <%=user.getName()%>

</div>

<div style="padding:20px">

<div class="card">

<h3>Alumni Directory</h3>

<a href="alumniDirectory.jsp">Open</a>

</div>

<div class="card">

<h3>Experience Posts</h3>

<a href="../viewPosts.jsp">Open</a>

</div>

<div class="card">

<h3>Job Board</h3>

<a href="jobBoard.jsp">Open</a>

</div>

<div class="card">

<h3>Mentorship</h3>

<a href="mentorship.jsp">Open</a>

</div>

<div class="card">

<h3>Events</h3>

<a href="../events.jsp">Open</a>

</div>

<div class="card">

<h3>Logout</h3>

<a href="../logout.jsp">Logout</a>

</div>

</div>

</body>

</html>