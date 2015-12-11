

<%@page import="bean.Pedido"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%ResultSet resultset =null;%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mis pedidos</title>
    </head>
    <body>
         <form action="http://localhost:8080/practicaJSTL/Controlador" method="get">
             Busca tus ultimos pedidos y vuelve a solicitarlos de inmediato
        <table border="4">
            <tr>
              <td style="text-align:right">Rut:<input type="text" name="rut"  value="" /><input type="submit" value="buscar" name="pressedButton" /> </td> <br/><br/>
           </tr>
        </table>
              <a href="index.jsp"> home </a> <br/>
        <a href="misPedidos.jsp"> mis pedidos </a> <br/><br/><br/>
        <sql:setDataSource var="tab" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost/et_dej4501"
     user="root"  password="root"/>
        <sql:query dataSource="${tab}" var="result">
        SELECT * from pedido;
        </sql:query>
        <table border="1" width="40%">
<tr>
   <th>Ticket</th>
   <th>Rut</th>
   <th>Medio pago</th>
   <th>Agranda beb y papas</th>
   <th>Para llevar</th>
   <th>Total</th>
   </tr>
   <c:forEach var="row" items="${result.rows}">
<tr>
   <td><c:out value="${row.ticket}"/></td>
   <td><c:out value="${row.rut}"/></td>
   <td><c:out value="${row.medio_pago}"/></td>
   <td><c:out value="${row.agranda_bebida_papas}"/></td>
   <td><c:out value="${row.para_llevar}"/></td>
   <td><c:out value="${row.total}"/></td>
   </tr>
</c:forEach>
</table>
        
        <%
            List<Pedido> datos = (List<Pedido>)
                    request.getAttribute("datos");
                    pageContext.setAttribute("datos",datos);
         %>
         
  
 <c:forEach var="obj" items="${datos}">
     


<c:out value="${obj.getTicket()}" /> - <c:out value="${obj.getRut()}" /> - <c:out value="${obj.getMedio_pago()}" />- <c:out value="${obj.getAgranda_bebida_papas()}"/> - <c:out value="${obj.getPara_llevar()}" /> -<c:out value="${obj.getTotal()}" /><br>
             
</c:forEach>
        
         </form>
    </body>
</html>
