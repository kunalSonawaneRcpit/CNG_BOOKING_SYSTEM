<%@page import="com.kunal.dbconnect.*" %>
<%@page import="java.sql.*" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
	int sno=Integer.parseInt(request.getParameter("id"));
	Connection con=DbConnect.getConnect();
	String sts="Approved";
	PreparedStatement ps1=con.prepareStatement("delete from pumps1 where pid=?");
	ps1.setInt(1, sno);
	int i=ps1.executeUpdate();
	if(i>0)
	{
		response.sendRedirect("DeleteCng.jsp");
	}
	else
	{
		response.sendRedirect("failed.htm");
	}
%>
</body>
</html>