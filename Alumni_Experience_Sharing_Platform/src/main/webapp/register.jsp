<!DOCTYPE html>
<html>

<head>
<title>Register</title>
<link rel="stylesheet" href="css/style.css">
</head>

<body>

<div class="container">

<h2>Register</h2>

<form action="register" method="post">

<input type="text" name="name" placeholder="Full Name" required>

<input type="email" name="email" placeholder="College Email (@srit.ac.in)" required>

<input type="password" name="password" placeholder="Password" required>

<select name="role">

<option value="">Select Role</option>
<option value="student">Student</option>
<option value="alumni">Alumni</option>

</select>

<button type="submit">Register</button>

</form>

<div class="link">
Already registered?  
<a href="login.jsp">Login here</a>
</div>

</div>

</body>
</html>