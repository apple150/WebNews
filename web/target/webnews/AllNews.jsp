<%@page import="dto.News"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
<title>All News</title>
</head>
<body>
<%
response.setCharacterEncoding("Cp1251");
%>
<H2 style="color:#0000FF">НОВОСТНОЙ ПОРТАЛ News.by</H2>

<TABLE border="1" cellspacing="0" cellpadding="0">
<%
ArrayList<News> array = (ArrayList<News>)request.getAttribute("array_news");
for (int i=0; i<array.size(); i++) {
%>
	<TR>
		<TD VALIGN=TOP ALIGN=CENTER><%= array.get(i).getId() %></TD>							
		<TD VALIGN=TOP ALIGN=CENTER><%= array.get(i).getCategory() %></TD>
		<TD VALIGN=TOP ALIGN=CENTER><%= array.get(i).getAuthor() %></TD>
		<TD VALIGN=TOP ALIGN=CENTER><%= array.get(i).getAgency() %></TD>
		<TD VALIGN=TOP ALIGN=CENTER><%= array.get(i).getDrelease() %></TD>		
		<TD VALIGN=TOP ALIGN=LEFT><%= array.get(i).getTitle() %></TD>
		<TD VALIGN=TOP ALIGN=LEFT><%= array.get(i).getAnnotation() %></TD>
		<TD VALIGN=TOP ALIGN=LEFT><%= array.get(i).getDocument() %></TD>		
	<TR>
<%
}
%>
</TABLE>
</body>
</html>