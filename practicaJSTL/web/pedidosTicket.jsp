

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ticket del pedido generado </title>
    </head>
    <body>
         <form action="http://localhost:8080/practicaJSTL/Controlador" method="get">
              <hr color="blue"/>
             <img src="good-food.jpg" width="300" height="300" alt="good-food"/>
              <hr color="blue"/>
      
              <a href="http://localhost:8080/practicaJSTL/Controlador?pressedButton=iniciarPagina"> home </a> <br/>
        <a href="misPedidos.jsp"> mis pedidos </a> <br/><br/><br/>
        <center> 
        Muchas gracias : <c:out value="${nombre}"/><br/>
        Tu numero de pedido es : <c:out value="${ticket}"/> <br/>
        Monto de su pedido :<c:out value="${total}"/><br/><br/><br/><br/>
        
        
        
            por favor pase por caja para que espere su pedido
        </center>
         </form>
    </body>
</html>
