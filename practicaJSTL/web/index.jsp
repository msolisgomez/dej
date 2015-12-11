<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="dao.ProductoDAOImpl"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>John master Home</title>
    </head>
    <hr color="blue"/>
    <body>
        <p align="right"><a href="index.jsp" > Ayuda </a></p>
        <form action="http://localhost:8080/practicaJSTL/Controlador" method="get">

            <img src="good-food.jpg" width="300" height="300" alt="good-food"/>

            <center>    
                Bienvenido a john master indiquenos su rut y nombre para generar su pedido <br/><br/>
            </center>
            <hr color="blue"/>
            <a href="index.jsp"> home </a> <br/>
            <a href="regCli.jsp"> Registro de cliente </a> <br/>
            <a href="misPedidos.jsp"> mis pedidos </a> <br/><br/><br/>
            <center>
                <table border="4">
                    <tr>
                        <td style="text-align:right">Nombre: <input type="text" name="nombre" value="<c:out value="${nombre}"/>"  /></td> <br/>
                    <td style="text-align:right">Rut:    <input type="text" name="rut"  value= "<c:out value="${rut}"/>" <br/><br/><br/><br/>
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

            <input type="submit" value="agregar" name="pressedButton" />
       

   
    <hr color="blue"/>


    <hr color="blue"/>
    <input type="checkbox" name="agranda_bebida_papas" value="ON" />Agranda bebida y papas<br/>
    <input type="checkbox" name="para_llevar" value="ON" />         Para llevar<br/> <br/>
    <b>Medio de pago:</b><br/>
    Efectivo:<input type="radio" name="medio_pago" value="efectivo" checked="true" /><br/>
    Tarjeta credito:<input type="radio" name="medio_pago" value="tcredito" /><br/><br/>
    
    <input type="submit" name="pressedButton" value="ENVIAR PEDIDO" />

   

     <table border="1" width="40%" align="center" >

        <tr>

           
            <th>Cantidad</th>
            <th>Descripcion</th>
            <th>Total</th>

        </tr>
        <c:out value="${sessionScope.Questions.questionPaperID}" />
        <c:forEach var="det" items="${sessionScope.sessionPedidoDet}">

            <tr>
                <td><c:out value="${det.cantidad}"/></td>
                <td><c:out value="${det.producto.descripcion}"/></td>
                <td><c:out value="${det.total}"/></td>

            </tr>

        </c:forEach>
            
            
    </table>

      

<h1><b>total pedido:<c:out value="${total}"/></b></h1> 







     
        
        

</form>    
</body>
</html>
