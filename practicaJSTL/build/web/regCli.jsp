
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.sql.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%ResultSet resultset =null;%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
             <form action="http://localhost:8080/practicaJSTL/Controlador" method="get">
           
            
             <h5>Bienvenido,Ingrese sus datos:</h5>
                Rut :<input type="text" name="rut" value="" /></br>
                Nombre :<input type="text" name="nombre" value="" />
        
         <input type="hidden" name="seleccion" value="2" />
        <input type="submit" value="Almacenar" />
        
        <sql:setDataSource var="tab" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost/et_dej4501"
     user="root"  password="root"/>
        <sql:query dataSource="${tab}" var="result">
        SELECT * from cliente;
        </sql:query>
        <table border="1" width="30%">
<tr>
   <th>Rut</th>
   <th>Nombre</th>
</tr>
   <c:forEach var="row" items="${result.rows}">
<tr>
   <td><c:out value="${row.rut}"/></td>
   <td><c:out value="${row.nombre}"/></td>
      </tr>
</c:forEach>
</table>
         </form>
        <%
            Object valor= request.getAttribute("valor");
            if(valor!=null){
            String cant= String.valueOf(valor);
            String OK="Cliente ingresado correctamente";
            String NOK="no ingresado";
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
