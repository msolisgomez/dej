<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="dao.ProductoDAOImpl"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!DOCTYPE html>
<html xmlns:h="http://xmlns.jcp.org/jsf/html" xmlns:f="http://xmlns.jcp.org/jsf/core">
     
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>John master Home</title>
 
    </head>

    <hr color="blue"/>
    <body>
        <p align="right"><a href="index.jsp" > Ayuda </a></p>
        <form action="http://localhost:8080/practicaJSTL/Controlador" name="form1" id="form1" method="get">

            <img src="good-food.jpg" width="300" height="300" alt="good-food"/>

            <center>    
                <b>Bienvenido a JOHN MASTER indiquenos su Nombre y Rut para generar su pedido</b> <br/><br/>
            </center>
            <hr color="blue"/>
            <a href="http://localhost:8080/practicaJSTL/Controlador?pressedButton=iniciarPagina"> HOME </a> <br/>
            <a href="regCli.jsp"> REGISTRO DE CLIENTE </a> <br/>
            <a href="misPedidos.jsp"> MIS PEDIDOS </a> <br/><br/><br/>
            <center>
   <table border="4">
                    <tr>
                        <td style="text-align:right">Nombre: <input type="text" name="nombre" value="<c:out value="${nombre}"/>"  /></td> <br/>
                        <td style="text-align:right">Rut:  <input type="text" name="rut"  value= "<c:out value="${rut}"/>"/></td> <br/>
                         
                        <span class="error">${messages.rut}</span><br>  
                        <c:if test ="${nombre.trim().isEmpty()||rut.trim().isEmpty() }">
                               <td colspan="2"><font color="red">
                                <c:out value="COMPLETA LOS DATOS:RUT Y NOMBRE"/>
                            </font></td>
                          </c:if>
                         </tr>
                </table>
                
                <hr color="blue"/>
            </center>
            <center>
                Seleccione un producto o combo,indique su cantidad y agregue el pedido :<br/><br/>
            </center>

            <select NAME="sele">
                <c:forEach var="item" items="${productos}">
                    <option value="<c:out value="${item.id_producto}" />" > <c:out value="${item.descripcion}" /> X $<c:out value="${item.valor}" /> </option>
                </c:forEach>
            </select>

            <input type="submit" value="AGREGAR" name="pressedButton" />
       
    <hr color="blue"/>

    <hr color="blue"/>
    <input type="checkbox" name="agranda_bebida_papas" value="ON" />Agranda bebida y papas<br/>
    <input type="checkbox" name="para_llevar" value="ON" />         Para llevar<br/> <br/>
    <b>Medio de pago:</b><br/>
    Efectivo:<input type="radio" name="medio_pago" value="efectivo" checked="true" /><br/>
    Tarjeta credito:<input type="radio" name="medio_pago" value="tcredito" /><br/><br/>
    
   

   

     <table border="1" width="40%" align="center" >

        <tr>
            <th>ID producto</th>
            <th>Cantidad</th>
            <th>Descripcion</th>
            <th>Total</th>
        </tr>
        <c:out value="${sessionScope.Questions.questionPaperID}" />
        <c:forEach var="det" items="${sessionScope.sessionPedidoDet}">

            <tr>
                <td><c:out value="${det.producto.id_producto}"/></td>
                <td><c:out value="${det.cantidad}"/></td>
                <td><c:out value="${det.producto.descripcion}"/></td>
                <td><c:out value="${det.total}"/></td>  
           </tr>
                                 
        </c:forEach>
       </table>
        <p align="center">Ingrese el <b>ID producto</b> si desea eliminarlo de su pedido:</p>
        <p align="center"><input type="text" name="id_producto" value="" /></p>
        <p align="center"><input type="submit" name="pressedButton" align="right" value="ELIMINAR PRODUCTO"  /></p> 
        <p align="center"><input type="submit" name="pressedButton" value="ENVIAR PEDIDO" /></p>
<h1><b>total pedido:<c:out value="${total}"/></b></h1> 
</form>
 <%
            Object valor = request.getAttribute("valor");
            if (valor != null) {
                String cant = String.valueOf(valor);
                String OK = "operacion realizada exitosamente";
                String NOK = "No se pudo realizar";
                pageContext.setAttribute("cant", cant);
                pageContext.setAttribute("OK", OK);
                pageContext.setAttribute("NOK", NOK);
            }
        %>
        <%
            Object val = request.getAttribute("val");
            if (valor != null) {
                String cant = String.valueOf(val);
                String OK = "operacion realizada exitosamente";
                String NOK = "No se pudo realizar";
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
