<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>makerLogin</title>
</head>
<body>
	<div class="list_center">
		<form action="makerLogin" method="post">
			<center>
				<h2>Welcom to Course Management System.Please Login Or Register</h2>
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
					<td><input type="submit" value="login"></td>
					<td><a href="makerReg.jsp">register</a></td>
				</tr>
			</table>
		</form>
	</div>
	<div class="list_center">
		<center>
			<h2>If you want to login as a Curriculum manager , click the button below</h2>
		</center>
		<center>
			<a href="managerLogin.jsp"><input type="submit" value="manager"></a>
		</center>
	</div>
</body>
</html>