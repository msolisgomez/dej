<%-- 
    Document   : pagina4
    Created on : 14-10-2015, 12:16:02 AM
    Author     : Duoc
--%>

<%@page import="bean.Producto"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
          <form action="http://localhost:8080/practicaJSTL/Controlador" method="get">
        <h5>Comprar productos:</h5>
        Ingrese ID: <input type="text" name="id" value="" /> </br>
        cantidad:  <input type="text" name="cantidad" value="" /></br>
       
        <input type="hidden" name="seleccion" value="12" />
        <input type="submit" value="Pagar" /></br></br>
        <%
          /*List<Producto> datos = (List<Producto>)
                    request.getAttribute("datos");
                    pageContext.setAttribute("datos",datos);
                    
                   Integer tot=0;  
            Integer cantidad = Integer.parseInt(request.getParameter("cantidad"));*/
            String valor = request.getParameter("valor");
            String cantidad = request.getParameter("cantidad");
            String total = request.getParameter("total");
            
        %>
         
  
valor producto: <fmt:formatNumber value="${valor}" pattern="#,##0" /> -</br>
cantidad: <c:out value="${cantidad}" />-</br>
<b>total:</b> <fmt:formatNumber value="${total}" pattern="#,##0" /> -</br>


<%--
<fmt:setLocale value="es_CL"/>
 total:  <input type="text" name="total" value="" /></br>
<c:forEach var="obj" items="${datos}">
<c:out value="${valor}" />
<c:out value="${total}" />
tot="${obj.getPrecio()*cantidad}" 
<c:out value="${tot}}" />
             ID: <% out.print(request.getParameter("id")); %></br>
Cantidad: <% out.print(request.getParameter("cantidad")); %></br>
total:<% out.print(request.getParameter("tot")); %></br>

--%>

        
         </form>
    </body>
</html>
