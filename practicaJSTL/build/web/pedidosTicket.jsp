

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%ResultSet resultset =null;%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ticket del pedido generado </title>
    </head>
    <body>
         <form action="http://localhost:8080/practicaJSTL/Controlador" method="get">
             
      
              <a href="index.jsp"> home </a> <br/>
        <a href="misPedidos.jsp"> mis pedidos </a> <br/><br/><br/>
        <center> 
        Muchas gracias : CLIENTE XXX <br/>
        Tu numero de pedido es : pedidoXXX <br/>
        Monto de su pedido : xxx<br/><br/><br/><br/>
        
        
        
            por favor pase por caja para que espere su pedido
        </center>
         </form>
    </body>
</html>
