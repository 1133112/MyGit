<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>indexM</title>
</head>
<body>
	<table width="50%" align="center" border="1">
		<thead>
			<tr height="50">
				<th>ID</th>
				<th>Title</th>
				<th>Introduce</th>
				<th>Operation</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${experiment}" var="experiment">
				<tr>
					<td align="center"><c:out value="${experiment.experimentId}" /></td>
					<td align="center"><c:out value="${experiment.eTitle}" /></td>
					<td align="center"><c:out value="${experiment.eIntroduce}" /></td>

					<td>
						<ul>
							<li><a href="selectCourse"><input type="button" value="return" /></a></li>

						</ul>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>