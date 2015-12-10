<%-- 
    Document   : pagina6
    Created on : 14-10-2015, 12:16:16 AM
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
                <h5>INGRESO DE PRODUCTOS: </h5>
            
            Nombre: <input type="text" name="nombre" value="" /><br />
            Precio: <input type="text" name="precio" value="" /><br />
            Alta:<input type="radio" name="baja" value="true" />
            Baja: <input type="radio" name="baja" value="false" />
                 <input type="hidden" name="seleccion" value="7" />
            <input type="submit" value="Almacenar" />
        </form>
            <%
            Object valor= request.getAttribute("valor");
            if(valor!=null){
            String cant= String.valueOf(valor);
            String OK="ingresado correctamente";
            String NOK="no ingresado";
            pageContext.setAttribute("cant",cant);
            pageContext.setAttribute("OK",OK);
            pageContext.setAttribute("NOK",NOK);
            }
            %>
            <c:set var="cant" value="${cant}" />
            <c:if test="${cant>='1'}"><c:out value="${OK}" /></c:if>
            <c:if test="${cant=='0'}"><c:out value="${NOK}" /></c:if>
            
    </body>
</html>
