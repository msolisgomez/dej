<%-- 
    Document   : pagina3
    Created on : 14-10-2015, 12:15:56 AM
    Author     : Duoc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <form action="http://localhost:8080/practicaJSTL/Controlador" method="get">
        <h5>Eliminar Cliente:</h5>
        <h4>Ingrese ID Cliente</h4>
        <input type="text" name="id" value="" />
         <input type="hidden" name="seleccion" value="4" />
        <input type="submit" value="Eliminar" />
         </form>
        <%
            Object valor = request.getAttribute("valor");
            if (valor != null) {
                String cant = String.valueOf(valor);
                String OK = "Cliente Eliminado";
                String NOK = "Cliente no eliminado";
                pageContext.setAttribute("cant", cant);
                pageContext.setAttribute("OK", OK);
                pageContext.setAttribute("NOK", NOK);
            }
        %>
    <c:set var="cant" value="${cant}" />
    <c:if test="${cant>='1'}"><c:out value="${OK}" /></c:if>
    <c:if test="${cant=='0'}"><c:out value="${NOK}" /></c:if>
    </body>
</html>
