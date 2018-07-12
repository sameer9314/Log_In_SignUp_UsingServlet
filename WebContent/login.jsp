<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
<script>
	function validate(){
		var email = document.forms["loginform"]["email"].value;
	     if (email == "")
	    {
	    alert("Enter the Email ID");
	    return false;
	    }
	     var password = document.forms["loginform"]["password"].value;
	     if(password == "")
	     {
	     alert("Enter the password");
	     return false;
	     }
	}
</script>
</head>
<body>
	<form name=loginform action="loginsuccessfull" method="post" onsubmit="return validate()">
		
		<label>Email id :</label><input type="text" name="email">
		<div></div>
		<label>Password :</label> <input type="password" name="password">
		
		<input type="submit" value="Login">
		
		</form>
		<form name="forgetPassword" action="forget-password" method="post">
		<input type="submit" value="Forget Password">
		</form>
</body>
</html>