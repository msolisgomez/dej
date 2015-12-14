

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
             <hr color="blue"/>
             <img src="good-food.jpg" width="300" height="300" alt="good-food"/>
             Busca tus ultimos pedidos y vuelve a solicitarlos de inmediato
              <hr color="blue"/>
        <table border="4">
            <tr>
              <td style="text-align:right">Rut:<input type="text" name="rut"  value="" /><input type="submit" value="buscar" name="pressedButton" /> </td> <br/><br/>
           </tr>
        </table>
              <a href="http://localhost:8080/practicaJSTL/Controlador?pressedButton=iniciarPagina"> home </a> <br/>
        <a href="misPedidos.jsp"> mis pedidos </a> <br/><br/><br/>
         <hr color="blue"/>
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
     

     <table border="2">
         <tr><td><b>Ticket:</b><c:out value="${obj.getTicket()}" /></td>  <td><b>Rut:</b><c:out value="${obj.getRut()}" /></td><td><b>Medio de pago:</b><c:out value="${obj.getMedio_pago()}" /></td><td><b>Agranda beb y papas: </b><c:out value="${obj.getAgranda_bebida_papas()}"/></td> <td><b>Para llevar:</b><c:out value="${obj.getPara_llevar()}" /></td> -<td><b>Total:</b><c:out value="${obj.getTotal()}" /></td></tr></br>
             </table>
</c:forEach>
          <hr color="blue"/>
                <input type="submit" value="hacer pedido" name="pressedButton" /> 
         </form>
          <%
            Object valor= request.getAttribute("valor");
            if(valor!=null){
            String cant= String.valueOf(valor);
            String OK="ENCONTRADO";
            String NOK="NO ENCONTRADO";
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
