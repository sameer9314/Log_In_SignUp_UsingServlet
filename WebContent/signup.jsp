<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sign Up</title>
<script type="text/javascript">
    function validateForm()
     {
    var y = document.forms["myForm"]["user_name"].value;
     if (y == "")
       {
           alert("Enter the UserName");
           return false;
       }
    var x = document.forms["myForm"]["email"].value;
     if (x == "")
    {
    alert("Enter the Email ID");
    return false;
    }
     else{
   
    var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;

    if (!filter.test(x)) {
    alert('Please provide a valid email address');
   
    return false;
    }
    }
    var z = document.forms["myForm"]["password"].value;
    if(z == "")
    {
    alert("Enter the password");
    return false;
    }

    }
</script>
</head>
<body>
	<form name="myForm" action="signup-successful" onsubmit="return validateForm()"
		method="post">

		<label>Username</label>
	    <input type="text" name="user_name" placeholder="Enter username">
		<br><br> 
		<label>Email</label>
		<input type="text" name="email" placeholder="Enter email">
		<br><br>
		<label>Phone Number</label>
		<input type="text" name="phoneNumber" placeholder="Enter phone number">
		<br><br>
		<label>Password</label>
	    <input type="password" name="password" placeholder="Enter password">
	    <br><br>
		<br> <input type="Submit" value="SignUp"><br>
	</form>
</body>
</html>