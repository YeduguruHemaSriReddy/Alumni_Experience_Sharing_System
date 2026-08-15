<%@ page import="model.User"%>

<%
User user=(User)session.getAttribute("user");
if(user==null){
response.sendRedirect("../login.jsp");
return;
}
%>

<html>

<head>

<title>Create Post</title>

<style>

body{
font-family:Arial;
background:#f4f6f9;
}

.container{
width:500px;
margin:auto;
margin-top:50px;
background:white;
padding:20px;
border-radius:8px;
box-shadow:0 2px 10px rgba(0,0,0,0.1);
}

input,textarea{
width:100%;
padding:10px;
margin:10px 0;
}

button{
background:#007bff;
color:white;
border:none;
padding:10px;
width:100%;
}

</style>

</head>

<body>

<div class="container">

<h2>Create Experience Post</h2>

<form action="../createPost" method="post">

<input type="text" name="title" placeholder="Post Title" required>

<textarea name="content" placeholder="Share your experience..." required></textarea>

<button type="submit">Publish Post</button>

</form>

</div>

</body>

</html>