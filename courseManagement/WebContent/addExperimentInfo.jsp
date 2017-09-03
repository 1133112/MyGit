<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="css/All.css" />
<title>addExperimentInfo</title>
</head>
<body>
	<center>
		<h3>Please Input Experment Info</h3>
	</center>
	<div class="list_center">
		<form action="addExperimentInfo" method="post">
			<table width="300px" border="0" align="center">
				<tr>
					<td align="center">Title:</td>
					<td><input type="text" name="eTitle"></td>
				</tr>
				<tr>
					<td align="center">Introduce:</td>
					<td><textarea id="ta1" name="eIntroduce" style="width: 200px; height: 200px;"></textarea></td>
				</tr>
				<tr>
					<td><input type="hidden" name="id" value="<%=request.getParameter("id")%>"></td>
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