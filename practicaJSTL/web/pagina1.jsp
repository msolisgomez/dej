

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
        <h5>Ingrese Nombre Cliente:</h5>
        <input type="text" name="nombre" value="" />
         <input type="hidden" name="seleccion" value="2" />
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
