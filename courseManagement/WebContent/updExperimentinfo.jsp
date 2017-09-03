<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="css/All.css" />
<title>updateExperimentInfo</title>
</head>
<body>
	<center>
		<h3>Update Experment Information</h3>
	</center>
	<div class="list_center">
		<form action="updateE" method="post">
			<table width="300" height="500" border="0" align="center">
				<tr>
					<td align="center">Title:</td>
					<td><input type="text" name="eTitle"></td>
				</tr>
				<tr>
					<td align="center">Introduce:</td>
					<td><textarea id="ta1" name="eIntroduce" style="width: 200px; height: 200px;"></textarea></td>
				</tr>
				<tr>
					<td><input type="hidden" name="experimentId" value="<c:out value="${experimentid}"/>"></td>
				</tr>
				<tr>
					<td><input type="hidden" name="makerId" value="<c:out value="${makerId}"/>"></td>
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