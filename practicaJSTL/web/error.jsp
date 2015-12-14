<%-- 
    Document   : pagina8
    Created on : 20-oct-2015, 18:25:00
    Author     : msolis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ERROR</title>
        
    </head>
    <body>
        <form action="http://localhost:8080/practicaJSTL/Controlador" method="get">
            <img src="good-food.jpg" width="300" height="300" alt="good-food"/>
    <center><h1>NO SE ENCUENTRA PEDIDO ASOCIADO A SU RUT... </h1></center>
    <table border="1">
        <thead>
            <tr>
                <th> <a href="misPedidos.jsp"> Buscar otro rut </a></th>
                <th><a href="http://localhost:8080/practicaJSTL/Controlador?pressedButton=iniciarPagina">Home</a></th>
            </tr>
        </thead>
       
    </table>

       </form>
    </body>
</html>
