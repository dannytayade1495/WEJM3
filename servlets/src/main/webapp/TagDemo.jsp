<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%-- <jsp:include page="DemoJsp1.jsp"/> --%>
<%-- <jsp:forward page="DemoJsp1.jsp"/> --%>
<%
String url = "http://localhost:8081/servlets/DemoJsp1.jsp";
response.sendRedirect(url);
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%-- <%!String url = "https://www.google.co.in";%>
<%
response.sendRedirect(url);
%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tags Demo</title>
</head>
<body style="color: orange;">
	<h1>This is the Demo JSP</h1>
	<%!List<String> list = new ArrayList<String>();%>
	<%
	list.add("A");
	list.add("B");
	%>
	<%=list%>
	<br>
	<%!static int a, b, c;%>
	<%!public static void sum() {
	a = 10;
	b = 20;
	c = a + b;
}%>
	<%
	sum();
	%>
	<%=c%>
</body>
</html>