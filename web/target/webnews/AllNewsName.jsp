<%@page import="pojos.News"%>
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

<p><font size="4" style="color:#0000FF"><a href=?operation=add>Добавить новость</a></font></p>
<TABLE border="0" cellspacing="0" cellpadding="0">

<%
ArrayList<News> array = (ArrayList<News>)request.getAttribute("array_news");
for (int i=0; i<array.size(); i++) {
%>
	<TR>		
		<TD VALIGN=TOP ALIGN=LEFT>
			<p><font size="5" style="color:#FF0000"><a href=?operation=show&id=<%= array.get(i).getId() %>> <%= array.get(i).getId() %>. <%= array.get(i).getTitle() %></a></font><p>
			<p><font size="3" style="color:#0000FF"><%= array.get(i).getCategory()%></font><p>
			<p><font size="3" style="color:#006400"><%= array.get(i).getDrelease() %></font><p>
			<p><font size="3" style="color:#8B008B"><%= array.get(i).getAuthor() %>, <%= array.get(i).getAgency() %></font><p>			
			<p><font size="3" style="color:#0000FF"><%= array.get(i).getAnnotation() %></font><p>
			<p><font size="2"><%= array.get(i).getDocument() %></H4><BR>
		</TD>
	<TR>
<%
}
%>
</TABLE>
</body>
</html>