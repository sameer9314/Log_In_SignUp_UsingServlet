<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Password Recovery Page</title>
<script>
	function validate(){
		var email = document.forms["loginform"]["email"].value;
	     if (email == "")
	    {
	    alert("Enter the Email ID");
	    return false;
	    }
	}
</script>
</head>
<body>
		<form name="password-recover" action="password-recover" method="post" onsubmit="return validate()">
		<label>Email id :</label><input type="text" name="email">
		<div></div>
		<input type="submit" value="Submit">
		</form>
</body>
</html>