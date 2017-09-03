<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="css/All.css" />
<title>Add Course Page</title>
</head>
<body>
	<center>
		<h3>Please Input Your Course Information</h3>
	</center>
	<div class="list_center">
		<form action="addCourse" method="post">
			<table width="300" height="500" border="0" align="center">
				<tr>
					<td align="center">Title:</td>
					<td><input type="text" name="cTitle"></td>
				</tr>
				<tr>
					<td align="center">Introduce:</td>
					<td><input type="text" name="cIntroduce"></td>
				</tr>
				<tr>
					<td align="center">State:</td>
					<td><select name="State" id="state">
							<option value="Development">Development</option>
							<option value="Test">Test</option>
							<option value="Online">Online</option>
							<option value="Offline">Offline</option>
							<option value="Abandoned">Abandoned</option>
					</select></td>
				</tr>
				<tr>
					<td align="center">Maker:</td>
					<td><select name="makerName" id="maker">
							<c:forEach items="${makers}" var="m">
								<option value="<c:out value="${m.name}"/>"><c:out value="${m.name}"/></option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td>
						<div class="submit">

							<input type="submit" value="Sure">

						</div>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>