<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="css/All.css" />
<title>ManagerRegister</title>
</head>
<body>
	<div class="list_center">
		<form action="makerReg" method="post">
			<center>
				<h2>Please enter your registration information</h2>
			</center>
			<table width="200" height="100" border="0" align="center">
				<tr>
					<td>Name:</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="text" name="password"></td>
				</tr>
				<tr>
					<td><input type="submit" value="register"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>