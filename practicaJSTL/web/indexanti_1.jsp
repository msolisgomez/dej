
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
             <form action="http://localhost:8080/practicaJSTL/Controlador" method="get">
            <input type="hidden" name="seleccion" value="1" />
            <input type="submit" value="Ingresar cliente" />
        </form>
         <form action="http://localhost:8080/practicaJSTL/Controlador" method="get">
            <input type="hidden" name="seleccion" value="6" />
            <input type="submit" value="Ingresar Producto" />
        </form>
        <form action="http://localhost:8080/practicaJSTL/Controlador" method="get">
            <input type="hidden" name="seleccion" value="3" />
            <input type="submit" value="Eliminar Cliente" />
        </form>
         <form action="http://localhost:8080/practicaJSTL/Controlador" method="get">
            <input type="hidden" name="seleccion" value="10" />
            <input type="submit" value="Dar de baja Producto" />
        </form>
         <form action="http://localhost:8080/practicaJSTL/Controlador" method="get">
            <input type="hidden" name="seleccion" value="5" />
            <input type="submit" value="Ver Clientes" />
        </form>
         <form action="http://localhost:8080/practicaJSTL/Controlador" method="get">
            <input type="hidden" name="seleccion" value="8" />
            <input type="submit" value="Ver Productos" />
        </form>
         <form action="http://localhost:8080/practicaJSTL/Controlador" method="get">
            <input type="hidden" name="seleccion" value="9" />
            <input type="submit" value="Comprar" />
        </form>
    </body>
</html>
