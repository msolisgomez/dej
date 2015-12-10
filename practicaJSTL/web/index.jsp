<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="dao.ProductoDAOImpl"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%ResultSet resultset =null;%>
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
               <td style="text-align:right">Nombre: <input type="text" name="nombre" value="" /></td> <br/>
               <td style="text-align:right">Rut:    <input type="text" name="rut"  value="" /></td> <br/><br/><br/><br/>
           </tr>
        </table>
             <hr color="blue"/>
             </center>
         <center>
         Seleccione un producto o combo,indique su cantidad y agregue el pedido :<br/><br/>
        
      <%
    try{
Class.forName("com.mysql.jdbc.Driver").newInstance();
Connection connection = 
         DriverManager.getConnection
            ("jdbc:mysql://localhost/et_dej4501?user=root&password=root");

       Statement statement = connection.createStatement() ;

       resultset =statement.executeQuery("select * from producto") ;
%>
<center>
    <select name="sele">
        <%  while(resultset.next()){ %>
            <option><%= resultset.getString(2)%></option> 
        <% } %>
        <input type="submit" value="agregar" name="agregar" />
    </select>
    
</center>
    <%

        }
        catch(Exception e)
        {
             out.println("error capturado en catch"+e);
        }
%>
         </center>
         <hr color="blue"/>
        
       
        <hr color="blue"/>
        <input type="checkbox" name="agranda_bebida_papas" value="ON" />Agranda bebida y papas<br/>
        <input type="checkbox" name="para_llevar" value="ON" />         Para llevar<br/> <br/>
        <b>Medio de pago:</b><br/>
        Efectivo:<input type="radio" name="medio_pago" value="" /><br/>
        Tarjeta credito:<input type="radio" name="medio_pago" value="" /><br/><br/>
        <input type="hidden" name="seleccion" value="1" />
        <input type="submit" value="ENVIAR PEDIDO" />
        
        <sql:setDataSource var="tab" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost/et_dej4501"
     user="root"  password="root"/>
        <sql:query dataSource="${tab}" var="result">
        SELECT * from producto;
        </sql:query>
        
        <table border="1" width="40%" align="center" >
           
<tr>
     
   <th>id_producto</th>
   <th>descripcion</th>
   <th>valor</th>
  
   </tr>
   
   <c:forEach var="row" items="${result.rows}">
       
   <tr>
   
   <td><c:out value="${row.id_producto}"/></td>
   <td><c:out value="${row.descripcion}"/></td>
   <td><c:out value="${row.valor}"/></td>
  
   </tr>
  
</c:forEach>
</table>
       
        </form>    
    </body>
</html>
