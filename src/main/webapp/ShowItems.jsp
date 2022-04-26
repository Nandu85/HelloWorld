<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.io.File" %>
<%@page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Hello....</h1>

<%ArrayList<String> paths=(ArrayList)request.getAttribute("paths"); %>
<br/>
<h3>---------------------------------------------------------------------</h3><br/>
<%

int i=0;

while(paths.size()!=i) {
	
%>

 <img src="<%=paths.get(i) %>" alt="Not Found" width="200px" /> 


 <%
i++;

} %>

<!-- <img src="images\\cakes\\cakes1.jpg" alt="Not Found" /> -->
</body>
</html>