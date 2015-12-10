/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import bean.Cliente;
import bean.Producto;
import dao.ClienteDAO;
import dao.ClienteDAOImpl;
import dao.ProductoDAO;
import dao.ProductoDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Duoc
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         String seleccion = request.getParameter("seleccion");
         ClienteDAO cdao = ClienteDAOImpl.getCdao();
         ProductoDAO pdao=ProductoDAOImpl.getPdao();
         if (seleccion.equals("1")) {
         response.sendRedirect("pedidosTicket.jsp");
                    
                   
        }
          if (seleccion.equals("2")) {
        
         Integer rut=Integer.parseInt(request.getParameter("rut")); 
         String nombre=request.getParameter("nombre");
        
         
         Integer valor = cdao.clienteIngresa(new Cliente(rut,nombre));
         request.setAttribute("valor", valor);
         request.getRequestDispatcher("regCli.jsp").forward(request,response);
         
                  
                  
        }
          
           if (seleccion.equals("3")) {
         response.sendRedirect("pagina3.jsp");
                    
                   
        }
           if (seleccion.equals("4")){
          
            Integer id = Integer.parseInt(request.getParameter("id"));
            Integer valor=0;
            if(cdao.clienteExiste(id)){
             valor = cdao.clienteElimina(id);
            }
            request.setAttribute("valor", valor);
            request.getRequestDispatcher("pagina3.jsp").forward(request,response);
                          
                        
              }   
           
            if (seleccion.equals("5")) {
          List<Cliente> datos = cdao.clienteTodos();
          request.setAttribute("datos", datos);
             request.getRequestDispatcher("pagina5.jsp").forward(request, response);
                    
                   
        }
           if (seleccion.equals("6")) {
         response.sendRedirect("pagina6.jsp");
                    
                   
        }
//            if (seleccion.equals("7")) {
//        
//         String nombre=request.getParameter("nombre");
//        // Integer precio=Integer.parseInt(request.getParameter("precio
//         Integer valor=0;
//         Boolean baja=Boolean.parseBoolean(request.getParameter("baja"));
//        Integer precio = 0;
//        precio = Integer.parseInt(request.getParameter("precio"));
//            try {
//                precio = Integer.parseInt(request.getParameter("precio"));
//            } catch (NumberFormatException e) {
//                request.getRequestDispatcher("pagina8.jsp").forward(request, response);
//               
//            }
//            if (precio >0 && precio < 600000) {
//                 valor = pdao.productoIngresa(new Producto(nombre,precio,baja));
//                }
//                if (valor == 0) {
//                    request.getRequestDispatcher("pagina8.jsp").forward(request,response);
//                }
//                else{
//                request.setAttribute("valor", valor);
//                request.getRequestDispatcher("pagina6.jsp").forward(request,response);
//                }
         
                  //Integer valor = pdao.productoIngresa(new Producto(nombre,precio,baja));
         
//         request.setAttribute("valor", valor);
//         request.getRequestDispatcher("pagina6.jsp").forward(request,response);
              
                  
       // }
            
//            }
            if (seleccion.equals("8")) {
          List<Producto> datos = pdao.productoTodos();
          request.setAttribute("datos", datos);
             request.getRequestDispatcher("pagina2.jsp").forward(request, response);
                    
                   
        }
               if (seleccion.equals("9")) {
         response.sendRedirect("pagina4.jsp");
                    
                   
        }
     
                if (seleccion.equals("10")) {
         response.sendRedirect("pagina7.jsp");
                    
                   
        }
//                if (seleccion.equals("11")) {
//                   Integer id=Integer.parseInt(request.getParameter("id"));
//                    Boolean baja = Boolean.parseBoolean(request.getParameter("baja"));
//                               Integer valor = pdao.productoBaja(new Producto(id,baja));
//         
//                    
//                   
//        }
//                if(seleccion.equals("12")){
//                    Producto pro = new Producto();
//                Integer id_producto = Integer.parseInt(request.getParameter("id_producto"));
//                Integer cantidad = Integer.parseInt(request.getParameter("cantidad"));
//                Integer total;
//                Integer valor;
//
//            valor=pdao.productoGetPrec(new Producto(id_producto,0));
//            total = cantidad * valor;
//           total=pro.getPrecio()*cantidad;
//            
//            request.setAttribute("cantidad", cantidad);
//            request.setAttribute("valor", valor);
//            request.setAttribute("total", total);
//            request.getRequestDispatcher("pagina4.jsp").forward(request,response);
//                }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
