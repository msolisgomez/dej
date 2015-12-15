

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
      
              <a href="http://localhost:8080/practicaJSTL/Controlador?pressedButton=iniciarPagina"> HOME </a> <br/>
        <a href="misPedidos.jsp"> MIS PEDIDOS </a> <br/><br/><br/>
        <center> 
        Muchas gracias :  <b><c:out value="${nombre}"/> </b><br/>
        Tu numero de pedido es :  <b><fmt:formatNumber value="${ticket}"pattern="0000"/></b> <br/> 
        Monto de su pedido :  <b><c:out value="${total}"/></b><br/><br/><br/><br/>
                        
        <b>Por favor pase por caja para que espere su pedido</b>
        </center>
         </form>
    </body>
</html>
