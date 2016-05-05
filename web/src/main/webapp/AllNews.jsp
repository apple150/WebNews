<%@page import="dto.News"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
<title>All News</title>
</head>
<body>
<H2 style="color:#0000FF">НОВОСТНОЙ ПОРТАЛ News.by</H2>
<p><font size="4" style="color:#0000FF"><a href=?operation=add>Добавить новость</a></font></p>
<TABLE border="0" cellspacing="0" cellpadding="0">
<c:forEach var="array" items="${requestScope.array_news}">
	<TR>
		<TD>
			<p><font size="5" style="color:#FF0000"><a href="?operation=show&id=${array.id}">${array.title}</a></font></p>
			<p><font size="3" style="color:#0000FF">${array.category}</font></p>
			<p><font size="3" style="color:#006400">${array.drelease}</font></p>
			<p><font size="3" style="color:#8B008B">${array.author}, ${array.agency}</font></p>
			<p><font size="3" style="color:#0000FF">${array.annotation}</font></p>
			<p><font size="2">${array.document}</font></p>
		</TD>
	</TR>
</c:forEach>
</TABLE>
</body>
</html>