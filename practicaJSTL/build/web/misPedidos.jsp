<%@page import="bean.Pedido"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mis pedidos</title>
    </head>
    <body>
        <form action="http://localhost:8080/practicaJSTL/Controlador" method="get">
            <img src="good-food.jpg" width="300" height="300" alt="good-food"/>
             <hr color="blue"/>
            <b>Busca tus ultimos pedidos y vuelve a solicitarlos de inmediato</b>
             <hr color="blue"/>
            <table border="4">
                <tr>
                    <td style="text-align:right">Rut:<input type="text" name="rut"  value="" /><input type="submit" value="Buscar Pedidos" name="pressedButton" /> </td> <br/><br/>
                </tr>
            </table>
            <a href="http://localhost:8080/practicaJSTL/Controlador?pressedButton=iniciarPagina"> HOME </a> <br/>
            <a href="misPedidos.jsp"> MIS PEDIDOS </a> <br/><br/><br/>

            <table border="1" width="40%">
                <tr>
                    <th>Ticket</th>
                    <th>Rut</th>
                    <th>Medio pago</th>
                    <th>Agranda beb y papas</th>
                    <th>Para llevar</th>
                    <th>Total</th>
                    <th>Repetir</th>
                </tr>
                <c:forEach var="pedido" items="${pedidos}">
                    <tr>
                        <td><c:out value="${pedido.ticket}"/></td>
                        <td><c:out value="${pedido.rut}"/></td>
                        <td><c:out value="${pedido.medio_pago}"/></td>
                        <td><c:out value="${pedido.agranda_bebida_papas}"/></td>
                        <td><c:out value="${pedido.para_llevar}"/></td>
                        <td><c:out value="${pedido.total}"/></td>
                        <td><a href="http://localhost:8080/practicaJSTL/Controlador?pressedButton=repetirPedido&ticket=<c:out value='${pedido.ticket}'/>&rut=<c:out value='${pedido.rut}'/>" >Repetir</a></td>
                    </tr>
                </c:forEach>
            </table>

        </form>
    </body>
</html>
