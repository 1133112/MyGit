<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Update Success</title>
</head>
<body>
	Update success! Click the button below to return to the home page
	<a href="selectCourseBymakerId2?id=<%=session.getAttribute("makerId")%>"><input type="button" value="renturn"></a>
</body>
</html>