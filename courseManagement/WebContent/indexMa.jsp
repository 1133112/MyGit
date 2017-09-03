<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="css/All.css" />
<title>indexMa</title>
</head>
<body>
	<table width="80%" align="center" border="1">
		<thead>
			<tr>
				<th>CourseId</th>
				<th>Title</th>
				<th>Introduce</th>
				<th>Maker</th>
				<th>Time</th>
				<th>State</th>
				<th>Operation</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${courselist}" var="Course">
				<tr>
					<td align="center"><c:out value="${Course.courseId}" /></td>
					<td align="center"><c:out value="${Course.cTitle}" /></td>
					<td align="center"><c:out value="${Course.cIntroduce}" /></td>
					<td align="center"><c:out value="${Course.makerName}" /></td>
					<td align="center"><c:out value="${Course.time}" /></td>
					<td align="center"><c:out value="${Course.state}" /></td>

					<td>
						<ul>
							<li><a
								href="MakerseeExperimentInfo?id=<c:out value="${Course.courseId}"/>&makerId=<%=session.getAttribute("makerId") %>">
									<input type="button" value="See" />
							</a></li>
							<li><a href="addExperimentInfo.jsp?id=<c:out value="${Course.courseId}"/>"><input type="button"
									value="Add" /></a></li>
						</ul>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>