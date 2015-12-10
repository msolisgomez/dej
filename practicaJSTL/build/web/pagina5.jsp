<%-- 
    Document   : pagina5
    Created on : 14-10-2015, 12:16:08 AM
    Author     : Duoc
--%>

<%@page import="java.util.List"%>
<%@page import="bean.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Datos Cliente</title>
    </head>
    <body>
               <%
            List<Cliente> datos = (List<Cliente>)
                    request.getAttribute("datos");
                    pageContext.setAttribute("datos",datos);
            
        %>
        <c:forEach var="obj" items="${datos}">
<c:out value="${obj.getId()}" /> - <c:out value="${obj.getNombre()}" /><br>
</c:forEach>
    </body>
</html>
