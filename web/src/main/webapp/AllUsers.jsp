<%@page import="dto.User"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
<title>All Users</title>
</head>
<body>
<%
response.setCharacterEncoding("Cp1251");
%>
<H2 style="color:#0000FF">Пользователи портала News.by</H2>

<TABLE border="1" cellspacing="0" cellpadding="5">
<%
ArrayList<User> array = (ArrayList<User>)request.getAttribute("array_users");
for (int i=0; i<array.size(); i++) {
%>
	<TR>
		<TD VALIGN=TOP ALIGN=CENTER><%= array.get(i).getId() %></TD>							
		<TD VALIGN=TOP ALIGN=CENTER><%= array.get(i).getRole() %></TD>
		<TD VALIGN=TOP ALIGN=LEFT><%= array.get(i).getName() %></TD>
		<TD VALIGN=TOP ALIGN=LEFT><%= array.get(i).getFam() %></TD>
		<TD VALIGN=TOP ALIGN=LEFT><%= array.get(i).getEmail() %></TD>		
		<TD VALIGN=TOP ALIGN=LEFT><%= array.get(i).getPassword() %></TD>		
	<TR>
<%
}
%>
</TABLE>
</body>
</html>