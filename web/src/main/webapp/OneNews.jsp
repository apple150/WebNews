<%@page import="dto.News"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="mynews" class="dto.News" scope="request"></jsp:useBean>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
<title>Одна новость</title>
</head>
<body>
<H2>НОВОСТНОЙ ПОРТАЛ News.by</H2>
<TABLE border="0" cellspacing="0" cellpadding="0">
	<TR>
		<TD>
			<p><font size="5" style="color:#FF0000"><a href="?operation=edit&id=${mynews.id}">${mynews.title}</a></font></p>
			<p><font size="3" style="color:#0000FF">${mynews.category}</font></p>
			<p><font size="3" style="color:#006400">${mynews.drelease}</font></p>
			<p><font size="3" style="color:#8B008B">${mynews.author}, ${mynews.agency}</font></p>
			<p><font size="3" style="color:#0000FF">${mynews.annotation}</font></p>
			<p><font size="2">${mynews.document}</font></p>
		</TD>	
	</TR>
</TABLE>
</body>
</html>