<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="adminController">
<p>
<input type="hidden" name="operation" value="addwrite">
<input type="hidden" name="parentid" value="<%= request.getParameter("id") %>">
id:<input name="id"><br>
keywords:<input name="keywords"><br>
description:<input name="description"><br>
title:<input name="title"><br>
title4menu:<input name="title4menu"><br>
maintext:<br>
<textarea rows="15" cols="80" name="maintext"></textarea>
<br>
<input type="submit">
</p>
</form>
</body>
</html>