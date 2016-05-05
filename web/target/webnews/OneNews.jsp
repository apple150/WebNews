<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
<title>One Been News</title>
</head>
<body>
<H2>НОВОСТНОЙ ПОРТАЛ News.by</H2>
<TABLE border="1" cellspacing="0" cellpadding="5">
	<TR>
	<TD>${requestScope.mynews.title}</TD>
	<TD>${mynews.title}</TD>
	<c:out value="123 ${requestScope.mynews.title}" />
	<%-- 
	<TD>${pageContext.session.id}</TR>
	--%>
	<TR>
</TABLE>
</body>
</html>