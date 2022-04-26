<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
    <title> Example of core-import tag </title>
</head>
<body>
 <c:set var="income" scope="session" value="${4000}"/>  
<c:if test="${income > 8000}">  
   <p>My income is: <c:out value="${income}"/><p>  
</c:if> 
    <c:import var="info" url="https://www.w3schools.in/" charEncoding="UTF-8" />
    <c:out value = "${info}" escapeXml="false"/> 
    
    <%-- <c:set var="url" value="2" scope="request"/>  
  <c:if test="${url<1}">  
     <c:redirect url="http://javatpoint.com"/>  
  </c:if>  
  <c:if test="${url>1}">  
     <c:redirect url="http://facebook.com"/>  
  </c:if>   --%>
</body>
</html>