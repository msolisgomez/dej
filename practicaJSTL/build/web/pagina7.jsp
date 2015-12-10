<%-- 
    Document   : pagina7
    Created on : 17-oct-2015, 10:29:50
    Author     : msolis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <title>JSP Page</title>
    </head>
    <body>
        <form action="http://localhost:8080/practicaJSTL/Controlador" method="get">
        <h5>Dar de baja productos:</h5>
            Ingrese ID: <input type="text" name="id" value="" /> </br>
             Baja: <input type="radio" name="baja" value="false" /> 
        <input type="hidden" name="seleccion" value="11" />
        <input type="submit" value="Dar de baja producto" />
         </form>
         <%
            Object valor = request.getAttribute("valor");
            if (valor != null) {
                String cant = String.valueOf(valor);
                String OK = "Producto dado de baja";
                String NOK = "No se pudo dar de baja";
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
